package am.controler.exceptions;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public class BaseException extends Exception implements JSONAware {
  JSONObject jsonObj = new JSONObject();

  public BaseException(String msg) {
    super(msg);
    jsonObj.put("ErrorMessage", msg);
  }

  @Override
  public String toJSONString() {
    return jsonObj.toJSONString();
  }
}
