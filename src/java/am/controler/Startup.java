package am.controler;

import am.model.factories.BaseFactory;
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Administrator
 */
public class Startup implements Servlet {
  protected Logger log;

  public Startup() {
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    PropertyConfigurator.configureAndWatch("log4j.properties");
    log = Logger.getLogger("startup");
    log.info("AutoMaintenance server startup");
    BaseFactory.loadConfig();
  }

  @Override
  public ServletConfig getServletConfig() {
    log.warn("getServletConfig()", new UnsupportedOperationException("Not supported yet."));
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    log.warn("service()", new UnsupportedOperationException("Not supported yet."));
  }

  @Override
  public String getServletInfo() {
    log.warn("getServletInfo()", new UnsupportedOperationException("Not supported yet."));
    return null;
  }

  @Override
  public void destroy() {
    BaseFactory.selfDestruct();
  }
}
