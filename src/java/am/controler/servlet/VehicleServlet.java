package am.controler.servlet;

import am.controler.exceptions.BaseException;
import am.controler.servlet.utils.WebMethod;
import am.model.dao.Vehicle;
import am.model.factories.VehiclesFactory;
import java.util.List;
import org.json.simple.JSONArray;

/**
 *
 * @author Administrator
 */
public class VehicleServlet extends BasicServlet {
  public static final String requestParameterUserId = "userid";
  /*public static final String requestParameterUser = "user";
  public static final String requestParameterPass = "pass";
  public static final String sessionAttributeUserObject = "userObject";*/

  protected VehiclesFactory vehiclesFactory;

  @WebMethod(parameters={})
  public String listAll(){
    List<Vehicle> vehicles = vehiclesFactory.selectAll();
    JSONArray res = new JSONArray();
    for (Vehicle v : vehicles) {
      res.add(v.toJSONObject());
    }
    return res.toJSONString();
  }

  @WebMethod(parameters={requestParameterUserId})
  public String listByUser() throws BaseException{
    String tmpuserid = request.getParameter(requestParameterUserId);
    Integer userid = null;
    try {
      userid = Integer.parseInt(tmpuserid);
    } catch(Exception e) {
      throw new BaseException("User ID provided is not a number!", e);
    }

    List<Vehicle> vehicles = vehiclesFactory.selectByUser(userid);
    JSONArray res = new JSONArray();
    for (Vehicle v : vehicles) {
      res.add(v.toJSONObject());
    }
    return res.toJSONString();
  }

  @Override
  protected void initialize() {
    vehiclesFactory = new VehiclesFactory();
    vehiclesFactory.setSqlSession(); //comment for no sql access
  }

  @Override
  protected void destroy() {
    vehiclesFactory.closeSqlSession();
    vehiclesFactory = null;
  }

}
