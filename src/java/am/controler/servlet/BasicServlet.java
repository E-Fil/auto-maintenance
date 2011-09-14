package am.controler.servlet;

import am.controler.exceptions.BaseException;
import am.controler.servlet.utils.WebMethod;
import efil.commons.utils.reflection.DuckType;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public abstract class BasicServlet {
  protected Logger logger;
  protected HttpServletRequest request;
  protected HttpServletResponse response;

  public BasicServlet() {
    logger = Logger.getLogger("servlets");
  }

  /**
   * Função a chamar pelos jsps.
   * @param request - parâmetro request do jsp.
   * @param response - parãmetro response do jsp.
   * @param out - parâmetro out do jsp.
   * @throws IOException
   * @throws SQLException
   */
  public void workit(HttpServletRequest request, HttpServletResponse response, JspWriter out) throws IOException {

    this.initialize();

    this.request = request;
    this.response = response;
    request.setCharacterEncoding("UTF-8");
    String action = request.getParameter("action");
    if (action == null || action.equals("")) {
      JSONArray methods = getAvailableMethodsAsJSON();
      out.print(methods.toJSONString());
    }else if (action.equalsIgnoreCase("testing")) {
      out.print(getMethodTesting());
      out.print("<br><iframe id=\"result\" name=\"result\" width=\"1000\" height=\"400\"></iframe>");
    } else {
      StringBuilder result = new StringBuilder();

      try {
        //use reflection, run methods
        result.append(DuckType.execute(this, action));
      /*} catch (ECBaseException ex) {
        logger.error("Error executing action '" + action + "' on class " + this.getClass().getName(), ex);*/
      } catch (BaseException be) {
        out.print(be.toJSONString());
      } catch (Throwable ex) {
        JSONObject obj = new JSONObject();
        obj.put("ErrorMessage", ex.getMessage());
        out.print(obj.toJSONString());
        logger.error("Error executing action '" + action + "' on class " + this.getClass().getName(), ex);
      }

      out.append(result.toString());

      this.destroy();
    }
  }

  protected String[] getAvailableMethods() throws Exception{
    throw new Exception("not yet implemented");
  }

  protected JSONArray getAvailableMethodsAsJSON() throws IOException{
    Method[] methods = this.getClass().getMethods();
    JSONArray resMethods = new JSONArray();
    JSONObject objM;
    JSONArray resParams;
    JSONObject objP;
    for (Method method: methods) {
      if (method.isAnnotationPresent(WebMethod.class)) {
        Annotation ann = method.getAnnotation(WebMethod.class);
        objM = new JSONObject();
        objM.put("MethodName", method.getName());
        resParams = new JSONArray();
        for(String ps : ((WebMethod)ann).parameters()) {
          objP = new JSONObject();
          objP.put("parameter", ps);
          resParams.add(objP);
        }
        objM.put("parameters", resParams);
        resMethods.add(objM);
      }
    }
    return resMethods;
  }

  protected String getMethodTesting() throws IOException{
    Method[] methods = this.getClass().getMethods();
    StringBuilder res = new StringBuilder();
    String link = "index.jsp/" + this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1);
    String actionParam = null;
    String testParams = "";
    for (Method method: methods) {
      if (method.isAnnotationPresent(WebMethod.class)) {
        actionParam = "<input type=\"hidden\" name=\"action\" value=\"" + method.getName() + "\">";
        Annotation ann = method.getAnnotation(WebMethod.class);
        testParams = "";
        for(String ps : ((WebMethod)ann).parameters()) {
          testParams += ps + ":&nbsp;<input type=\"text\" name=\"" + ps + "\"/>&nbsp;&nbsp;&nbsp;";
        }
        res.append("<form action=\"").append(link).append("\" target=\"result\">").
                append(actionParam).
                append(method.getName()).
                append("<br>").
                append(testParams).
                append("<input type=\"submit\"></form>");
      }
    }
    return res.toString();
  }

  protected abstract void initialize();

  protected abstract void destroy();

}
