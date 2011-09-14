package am.model.sqlmaps;

import org.apache.ibatis.annotations.Param;
import am.model.dao.User;

import java.util.List;
import org.apache.ibatis.annotations.Options;

public interface UserMapper {

  /**
   * List all users
   * @return List<User>
   */
  List<User> selectAll();

  /**
   * Selects user info from username and password (login info)
   * @param User usr
   * @return User
   */
  User selectByCredencials(User usr);

  /**
   * Insert new user
   * @param User user
   * @return Integer
   */
  @Options(useGeneratedKeys=true)
  Integer insertUser(User user);

  Integer updateUser(User user);

  Integer deleteUser(Integer id);
}
