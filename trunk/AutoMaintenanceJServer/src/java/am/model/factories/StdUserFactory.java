package am.model.factories;

import am.controler.exceptions.BaseException;
import am.model.dao.BaseDao;
import am.model.dao.User;
import am.model.sqlmaps.UserMapper;
import java.util.List;
/*import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

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
    user = userMapper.selectByCredencials(user);
    if (user != null) {
      VehiclesFactory vf = new VehiclesFactory();
      vf.setSqlSession(sqlSession);
      user.setVehicles(vf.VehiclesAndAssociationsByUser(user.getIduser()));
    }

    return user;
  }

  public Integer createUser(String username, String password) throws BaseException {
    User uUser = new User();
    uUser.setusername(username);
    uUser.setpassword(password);

    Integer i = createUser(uUser);

    if (i.intValue() != 1) {
      throw new BaseException("User not inserted");
    } else {
      //sendUserRegisterConfirmEMail(uUser);
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
    return createUser((User) dao);
  }

  @Override
  protected Integer update(BaseDao dao) throws BaseException {
    return updateUser((User) dao);
  }

  @Override
  protected Integer delete(BaseDao dao) throws BaseException {
    return deleteUser((User) dao);
  }

  /*private void sendUserRegisterConfirmEMail(User uUser) {
    // Recipient's email ID needs to be mentioned.
    String to = uUser.getusername();

    // Sender's email ID needs to be mentioned
    String from = "AutoMaintenanceAdmin@gmail.com";

    // Assuming you are sending email from localhost
    String host = "localhost";

    // Get system properties
    Properties properties = System.getProperties();

    // Setup mail server
    properties.setProperty("smtp.gmail.com", host);
    properties.setProperty("mail.user", "gmefil");
    properties.setProperty("mail.password", "carvalho");
    // Get the default Session object.
    Session session = Session.getDefaultInstance(properties);

    try {
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
              new InternetAddress(to));

      // Set Subject: header field
      message.setSubject("AutoMaintenance Register Confirmation");

      // Now set the actual message
      message.setText("You have successfully registered an account with AutoMaintenance using this e-mail adress.\npassword: " + uUser.getpassword());

      // Send message
      Transport.send(message);
      System.out.println("Sent message successfully....");
    } catch (MessagingException mex) {
      mex.printStackTrace();
    }

  }*/
}
