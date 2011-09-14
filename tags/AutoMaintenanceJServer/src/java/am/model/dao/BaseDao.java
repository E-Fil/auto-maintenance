package am.model.dao;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public abstract class BaseDao implements JSONAware {
  private DaoStatus daoStatus;

  protected JSONObject jsonObj = new JSONObject();

  public abstract JSONObject toJSONObject();

  @Override
  public String toJSONString() {
    return jsonObj.toJSONString();
  }

  /**
   * @return DaoStatus daoStatus
   */
  public DaoStatus getDaoStatus() {
    return daoStatus;
  }

  /**
   * @param daoStatus the daoStatus to set
   */
  public void setDaoStatus(DaoStatus daoStatus) {
    this.daoStatus = daoStatus;
  }
}
