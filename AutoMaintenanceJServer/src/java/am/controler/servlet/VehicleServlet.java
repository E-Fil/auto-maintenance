package am.controler.servlet;

import am.controler.exceptions.BaseException;
import am.controler.servlet.utils.WebMethod;
import am.model.dao.AssociationType;
import am.model.dao.User;
import am.model.dao.Vehicle;
import am.model.dao.VehicleAssociation;
import am.model.factories.VehiclesFactory;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public class VehicleServlet extends BasicServlet {
  public static final String requestParameterUserId = "userid";
  public static final String requestParameterLicPlate = "licplate";
  public static final String requestParameterMake = "make";
  public static final String requestParameterModel = "model";
  public static final String requestParameterDescription = "description";

  protected VehiclesFactory vehiclesFactory;

  @WebMethod(parameters={requestParameterUserId})
  public String VehiclesAndAssociationsByUser() throws BaseException {
    String tmpuserid = request.getParameter(requestParameterUserId);
    Integer userid = null;
    try {
      userid = Integer.parseInt(tmpuserid);
    } catch(Exception e) {
      throw new BaseException("User ID provided is not a number!", e);
    }

    List<VehicleAssociation> vehicleAssociations = vehiclesFactory.VehiclesAndAssociationsByUser(userid);
    JSONArray res = new JSONArray();
    for (VehicleAssociation va : vehicleAssociations) {
      res.add(va.toJSONObject());
    }
    return res.toJSONString();
  }

  @WebMethod(parameters={requestParameterLicPlate, requestParameterMake, requestParameterModel, requestParameterDescription})
  public String addVehicle() throws BaseException {
    Vehicle nVehicle = new Vehicle();
    nVehicle.setLic_plate_number(request.getParameter(requestParameterLicPlate));
    nVehicle.setMake(request.getParameter(requestParameterMake));
    nVehicle.setModel(request.getParameter(requestParameterModel));
    nVehicle.setDescription(request.getParameter(requestParameterDescription));

    nVehicle.setIdvehicle(vehiclesFactory.insertVehicle(nVehicle));

    VehicleAssociation nva = new VehicleAssociation();
    nva.setAccess_type(getStandardAssociation());
    nva.setUser((User)request.getSession().getAttribute(UsersServlet.sessionAttributeUserObject));
    nva.setVehicle(nVehicle);

    vehiclesFactory.createAssociation(nva);

    JSONObject res = new JSONObject();
    res.put("result", "ok");
    res.put("id", nVehicle.getIdvehicle());

    return res.toJSONString();
  }

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

  private AssociationType getStandardAssociation() {
    AssociationType res = new AssociationType();
    res.setIdaccess_type(1);
    return res;
  }

}
