package am.controler.servlet;

import am.model.dao.User;
import am.model.factories.StdUserFactory;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Administrator
 */
public class UsersServlet extends BasicServlet {

  public String login(StdUserFactory userFactory) {
    String user = request.getParameter("user");
    String pass = request.getParameter("pass");
    User u = userFactory.getUser(user, pass);

    return u.toJSONObject().toJSONString();
  }

  public String listAllUsers(StdUserFactory userFactory){
    List<User> users = userFactory.listAllUsers();
    StringBuilder res = new StringBuilder();
    for (User u : users) {
      res.append(u.toJSONObject().toJSONString());
    }
    return res.toString();
  }

  @Override
  protected String[] getAvailableMethods() {
    String[] res = new String[1];
    res[0] = "login";
    return res;
  }

  @Override
  protected JSONArray getAvailableMethodsAsJSON() {
    JSONArray res = new JSONArray();
    JSONObject objM = new JSONObject();
    JSONArray params = new JSONArray();
    JSONObject objP = new JSONObject();
    objM.put("method", "login");
    objP.put("String", "user");
    params.add(objP);
    objP = new JSONObject();
    objP.put("String", "pass");
    params.add(objP);
    objM.put("parameters", params);
    res.add(objM);
    return res;
  }
}
