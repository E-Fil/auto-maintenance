package am.model.factories;

import am.model.dao.User;
import am.model.sqlmaps.UserMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Administrator
 */
public class StdUserFactory extends BaseFactory {

  protected static StdUserFactory generalUseInstance;

  protected SqlSession sqlsession;

  public static StdUserFactory getInstance() {
    if (generalUseInstance == null) {
      generalUseInstance = new StdUserFactory();
    }
    return generalUseInstance;
  }

  protected StdUserFactory() {
    logger.debug("StdUserFactory generalUseInstance started");
  }

  public List<User> listAllUsers() {
    List<User> users = null;
    try {
      sqlsession = sessionFactory.openSession();
      //log.info(sqlsession.getConfiguration().getEnvironment().getDataSource().toString());

      UserMapper mapper = sqlsession.getMapper(UserMapper.class);
      users = mapper.selectAll();

    } // end try
    catch (Exception e) {
      logger.error("Error fetching users", e);
    } // end catch
    finally {
      if (sqlsession != null) {
        sqlsession.close();
      }
    }

    return users;
  }
}
