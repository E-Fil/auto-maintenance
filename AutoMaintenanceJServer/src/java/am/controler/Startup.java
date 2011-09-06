package am.controler;

import am.model.factories.BaseFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Administrator
 */
public class Startup {

  public Startup() {
    //URL url = BasicServlet.class.getClassLoader().getResource("cfg/SWRLog.properties");
    //PropertyConfigurator.configureAndWatch(Utils.urlToFilepath(url));
    PropertyConfigurator.configureAndWatch("log4j.properties");
    Logger log = Logger.getLogger("startup");
    log.info("AutoMaintenance server startup");
    log.info(BaseFactory.class.getName());
  }
}
