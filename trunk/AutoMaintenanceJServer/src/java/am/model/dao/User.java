package am.model.dao;

/**
 *
 * @author Administrator
 */
public class User {

  Integer id;
  String username;
  String password;

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
}
