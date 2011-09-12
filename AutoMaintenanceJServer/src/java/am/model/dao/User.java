package am.model.dao;

import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public class User extends BaseDao {

  Integer id;
  String username;
  String password;
  private List<Vehicle> vehicles;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getusername() {
    return username;
  }

  public void setusername(String username) {
    this.username = username;
  }

  public String getpassword() {
    return password;
  }

  public void setpassword(String password) {
    this.password = password;
  }

  @Override
  public JSONObject toJSONObject() {
    jsonObj.put("id", getId());
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
