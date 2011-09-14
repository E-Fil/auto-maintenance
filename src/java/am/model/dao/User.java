package am.model.dao;

import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public class User extends BaseDao {

  Integer iduser;
  String username;
  String password;
  private List<Vehicle> vehicles;

  public Integer getIduser() {
    return iduser;
  }

  public void setIduser(Integer iduser) {
    this.iduser = iduser;
  }

  public String getusername() {
    return username;
  }

  public void setusername(String username) {
    this.username = username;
    setDaoStatus(DaoStatus.Updated);
  }

  public String getpassword() {
    return password;
  }

  public void setpassword(String password) {
    this.password = password;
    setDaoStatus(DaoStatus.Updated);
  }

  @Override
  public JSONObject toJSONObject() {
    jsonObj.put("iduser", getIduser());
    jsonObj.put("username", getusername());
    jsonObj.put("password", getpassword());

    JSONArray jsonVehicles = new JSONArray();
    if (vehicles != null) {
      for (Vehicle v: vehicles) {
        jsonVehicles.add(v.toJSONObject());
      }
    }
    jsonObj.put("vehicles", jsonVehicles);
    return jsonObj;
  }

  /**
   * @return the vehicles
   */
  public List<Vehicle> getVehicles() {
    return vehicles;
  }

  /**
   * @param vehicles the vehicles to set
   */
  public void setVehicles(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  /**
   * @param vehicles the vehicles to set
   */
  public void addVehicles(List<Vehicle> vehicles) {
    this.vehicles.addAll(vehicles);
  }

  /**
   * @param vehicles the vehicles to set
   */
  public void addVehicle(Vehicle vehicle) {
    this.vehicles.add(vehicle);
  }
}
