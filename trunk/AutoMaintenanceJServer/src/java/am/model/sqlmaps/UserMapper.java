package am.model.sqlmaps;

import org.apache.ibatis.annotations.Param;
import am.model.dao.User;

import java.util.List;

public interface UserMapper {

  /**
   * List all users
   * @return List<User>
   */
  List<User> selectAll();

  /**
   * Selects user info from username and password (login info)
   * @param usr
   * @return User
   */
  User selectByCredencials(User usr);

  Integer delete(Integer id);
}
