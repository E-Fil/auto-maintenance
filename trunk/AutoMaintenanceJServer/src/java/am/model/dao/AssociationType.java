package am.model.dao;

import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public class AssociationType extends BaseDao {
  protected Integer idaccess_type;
  protected String name;
  protected String description;

  @Override
  public JSONObject toJSONObject() {
    if (jsonObj == null) {
      jsonObj = new JSONObject();
      jsonObj.put("idaccess_type", idaccess_type);
      jsonObj.put("name", name);
      jsonObj.put("description", description);
    }
    return jsonObj;
  }

  /**
   * @return the idaccess_type
   */
  public Integer getIdaccess_type() {
    return idaccess_type;
  }

  /**
   * @param idaccess_type the idaccess_type to set
   */
  public void setIdaccess_type(Integer idaccess_type) {
    this.idaccess_type = idaccess_type;
    jsonObj = null;
    setDaoStatus(DaoStatus.Updated);
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

}
