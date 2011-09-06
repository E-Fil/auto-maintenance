package am.model.sqlmaps;

import org.apache.ibatis.annotations.Param;
import am.model.dao.User;

import java.util.List;

public interface UserMapper {

  /**
   *
   * @return List<User>
   */
  List<User> selectAll();

  Integer delete(Integer id);
}
