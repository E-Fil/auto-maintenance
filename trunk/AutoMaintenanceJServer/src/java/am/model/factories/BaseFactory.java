package am.model.factories;

import am.controler.exceptions.BaseException;
import am.model.dao.BaseDao;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;

/**
 *
 * @author Administrator
 */
public abstract class BaseFactory {
  protected static final Logger logger;

  protected static SqlSessionFactory sessionFactory;

  protected SqlSession sqlSession;
  static {
    logger = Logger.getLogger("BaseFactoriesLogger");
    try {
      URL url = BaseFactory.class.getClassLoader().getResource("iBatisConfig.xml");
      String aResource = "iBatisConfig.xml";
      Reader reader = Resources.getResourceAsReader(aResource);
      logger.info("Reading mybatis config info from " + url.toExternalForm());
      sessionFactory = new SqlSessionFactoryBuilder().build(reader);
      logger.info("Mybatis config OK");
    } catch (IOException ioe) {
      logger.fatal("Error loading mybatis config!!!", ioe);
    }
    logger.info("BaseFactory startup OK");
    loadConfig();
  }

  public static void loadConfig() {
    logger.info("Loading config");
  }

  public static void selfDestruct() {
    sessionFactory = null;
    LogManager.shutdown();
  }

  public void setSqlSession() {
    sqlSession = sessionFactory.openSession();
    init();
  }

  public void closeSqlSession() {
    destroy();
    sqlSession.commit();
    sqlSession.close();
    sqlSession = null;
  }

  protected abstract void init();

  protected abstract void destroy();

  public Integer save(BaseDao dao) throws BaseException {
    Integer res = null;
    switch (dao.getDaoStatus()) {
      case Deleted:
        res = delete(dao);
        break;
      case New:
        res = create(dao);
        break;
      case Updated:
        res = update(dao);
        break;
    }
    return res;
  }

  protected abstract Integer create(BaseDao dao) throws BaseException;

  protected abstract Integer update(BaseDao dao) throws BaseException;

  protected abstract Integer delete(BaseDao dao) throws BaseException;

}
