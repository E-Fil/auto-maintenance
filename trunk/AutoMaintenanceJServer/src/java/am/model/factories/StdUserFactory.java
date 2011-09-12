package am.model.factories;

import am.controler.exceptions.BaseException;
import am.model.dao.User;
import am.model.sqlmaps.UserMapper;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class StdUserFactory extends BaseFactory {

  //protected static StdUserFactory generalUseInstance;

  protected UserMapper userMapper = null;

  /*public static StdUserFactory getInstance() {
    if (generalUseInstance == null) {
      generalUseInstance = new StdUserFactory();
    }
    return generalUseInstance;
  }*/

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

    //return (User)sqlSession.selectOne("selectByCredencials", uUser);

    User res = userMapper.selectByCredencials(uUser);

    return res;
  }

  @Override
  protected void init() {
    userMapper = sqlSession.getMapper(UserMapper.class);
  }

  @Override
  protected void destroy() {
    userMapper = null;
  }
}
