package am.model.dao;

import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public class VehicleAssociation extends BaseDao {
  protected Integer idvehicle_access;
  protected User user;
  protected Vehicle vehicle;
  protected AssociationType access_type;

  @Override
  public JSONObject toJSONObject() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * @return the idvehicle_access
   */
  public Integer getIdvehicle_access() {
    return idvehicle_access;
  }

  /**
   * @param idvehicle_access the idvehicle_access to set
   */
  public void setIdvehicle_access(Integer idvehicle_access) {
    this.idvehicle_access = idvehicle_access;
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
    return access_type;
  }

  /**
   * @param access_type the access_type to set
   */
  public void setAccess_type(AssociationType access_type) {
    this.access_type = access_type;
  }

}
