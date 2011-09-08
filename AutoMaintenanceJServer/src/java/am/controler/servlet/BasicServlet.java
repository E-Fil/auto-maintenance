package am.controler.servlet;

import am.model.factories.BaseFactory;
import am.model.factories.StdUserFactory;
import efil.commons.utils.reflection.DuckType;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;

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
    this.request = request;
    this.response = response;
    request.setCharacterEncoding("UTF-8");
    String action = request.getParameter("action");
    if (action == null || action.equals("")) {
      JSONArray methods = getAvailableMethodsAsJSON();
      out.print(methods.toJSONString());
    } else {
      StringBuilder result = new StringBuilder();
      BaseFactory factory = new StdUserFactory();
      factory.setSqlSession();

      Object[] parameters = new Object[1];
      parameters[0] = factory;
      try {
        //use reflection, run methods
        result.append(DuckType.execute(this, action, parameters));
      /*} catch (ECBaseException ex) {
        logger.error("Error executing action '" + action + "' on class " + this.getClass().getName(), ex);*/
      } catch (Throwable ex) {
        logger.error("Error executing action '" + action + "' on class " + this.getClass().getName(), ex);
      }

      factory.closeSqlSession();
      out.append(result.toString());
    }
  }

  protected abstract String[] getAvailableMethods();

  protected abstract JSONArray getAvailableMethodsAsJSON();

}
