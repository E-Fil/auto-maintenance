  <%@page contentType="text/html; charset=UTF-8"%>
  <%@page import="org.json.simple.JSONObject"%>
  <%@page import="org.apache.ibatis.io.Resources"%>
  <%@page import="org.apache.ibatis.session.SqlSession"%>
  <%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
  <%@page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
  <%@page import="am.Contact"%>
  <%@page import="am.ContactMapper"%>
  <%@page import="java.io.Reader"%>
  <%@page import="java.util.List"%>

  <%
    JSONObject obj=new JSONObject();

   SqlSession sqlsession = null;

      try
         {
         String aResource = "iBatisConfig.xml";
         Reader reader = Resources.getResourceAsReader(aResource); 
         SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
         //log.info(sessionFactory.getConfiguration().getEnvironment().getDataSource().toString());
         sqlsession = sessionFactory.openSession();
         //log.info(sqlsession.getConfiguration().getEnvironment().getDataSource().toString());
         
         ContactMapper mapper = sqlsession.getMapper(ContactMapper.class);
         List<Contact> contacts = mapper.selectAll();
         
         for (Contact c: contacts)
            {
				obj.put("id",c.getId());
				obj.put("username",c.getusername());
				obj.put("password",c.getpassword());
				out.print(obj);
				out.print("\n");
            }
         } // end try
      catch (Exception e)
         {
         e.printStackTrace();
         } // end catch
      finally
         {
         if (sqlsession != null)
            {
            sqlsession.close();
            }
         }


    out.flush();
  %>