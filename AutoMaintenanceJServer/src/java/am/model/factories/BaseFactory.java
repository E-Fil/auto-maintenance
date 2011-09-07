package am.model.factories;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author Administrator
 */
public abstract class BaseFactory {
  protected static final Logger logger;

  protected static SqlSessionFactory sessionFactory;

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
}
