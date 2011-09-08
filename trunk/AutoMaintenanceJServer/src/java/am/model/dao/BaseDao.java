/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package am.model.dao;

import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public abstract class BaseDao {
  protected JSONObject jsonobj = new JSONObject();

  public abstract JSONObject toJSONObject();
}
