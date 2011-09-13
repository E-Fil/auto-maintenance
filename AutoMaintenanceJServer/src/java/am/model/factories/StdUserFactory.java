package am.model.factories;

import am.controler.exceptions.BaseException;
import am.model.dao.BaseDao;
import am.model.dao.User;
import am.model.sqlmaps.UserMapper;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class StdUserFactory extends BaseFactory {
  protected UserMapper userMapper = null;

  public StdUserFactory() {
    super();
    logger.debug("StdUserFactory generalUseInstance started");
  }

  public List<User> listAllUsers() {
    List<User> users = null;
    try {
      //sqlSession = sessionFactory.openSession();
      //log.info(sqlsession.getConfiguration().getEnvironment().getDataSource().toString());

      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      users = mapper.selectAll();

    } // end try
    catch (Exception e) {
      logger.error("Error fetching users", e);
    } // end catch
    finally {
      /*if (sqlSession != null) {
        sqlSession.close();
      }*/
    }

    return users;
  }

  public User getUser(String username, String password) throws BaseException {
    User uUser = new User();
    uUser.setusername(username);
    uUser.setpassword(password);

    User res = getUser(uUser);

    return res;
  }

  public User getUser(User user) throws BaseException {
    User res = userMapper.selectByCredencials(user);

    return res;
  }

  public Integer createUser(String username, String password) throws BaseException {
    User uUser = new User();
    uUser.setusername(username);
    uUser.setpassword(password);

    Integer i = createUser(uUser);

    if (i.intValue() != 1) {
      throw new BaseException("User not inserted");
    }

    return uUser.getIduser();
  }

  public Integer createUser(User newUser) {
    return userMapper.insertUser(newUser);
  }

  public Integer updateUser(User newUser) {
    return userMapper.updateUser(newUser);
  }

  public Integer deleteUser(User newUser) {
    return userMapper.deleteUser(newUser.getIduser());
  }

  @Override
  protected void init() {
    userMapper = sqlSession.getMapper(UserMapper.class);
  }

  @Override
  protected void destroy() {
    userMapper = null;
  }

  @Override
  protected Integer create(BaseDao dao) throws BaseException {
    return createUser((User)dao);
  }

  @Override
  protected Integer update(BaseDao dao) throws BaseException {
    return updateUser((User)dao);
  }

  @Override
  protected Integer delete(BaseDao dao) throws BaseException {
    return deleteUser((User)dao);
  }
}
