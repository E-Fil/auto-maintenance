package am.model.dao;

import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public class VehicleAssociation extends BaseDao {
  protected Integer idVehicleAccess;
  protected User user;
  protected Vehicle vehicle;
  protected AssociationType accessType;

  @Override
  public JSONObject toJSONObject() {
    jsonObj.put("idVehicleAccess", idVehicleAccess);
    jsonObj.put("vehicle", vehicle.toJSONObject());
    jsonObj.put("accessType", accessType.toJSONObject());

    return jsonObj;
  }

  /**
   * @return the idvehicle_access
   */
  public Integer getIdvehicle_access() {
    return idVehicleAccess;
  }

  /**
   * @param idvehicle_access the idvehicle_access to set
   */
  public void setIdvehicle_access(Integer idvehicle_access) {
    this.idVehicleAccess = idvehicle_access;
  }

  /**
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * @return the vehicle
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * @param vehicle the vehicle to set
   */
  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  /**
   * @return the access_type
   */
  public AssociationType getAccess_type() {
    return accessType;
  }

  /**
   * @param access_type the access_type to set
   */
  public void setAccess_type(AssociationType access_type) {
    this.accessType = access_type;
  }

}
