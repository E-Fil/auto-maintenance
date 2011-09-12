/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package am.model.dao;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public abstract class BaseDao implements JSONAware {
  protected JSONObject jsonObj = new JSONObject();

  public abstract JSONObject toJSONObject();

  @Override
  public String toJSONString() {
    return jsonObj.toJSONString();
  }
}
