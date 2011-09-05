<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="org.apache.ibatis.io.Resources"%>
<%@ page import="org.apache.ibatis.session.SqlSession"%>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
<%@ page import="am.Vehicle"%>
<%@ page import="am.VehicleMapper"%>
<%@ page import="java.io.Reader"%>
<%@ page import="java.util.List"%>
<%
    JSONObject obj=new JSONObject();

    SqlSession sqlsession = null;

      try {
         String aResource = "iBatisConfig.xml";
         Reader reader = Resources.getResourceAsReader(aResource); 
         SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
         //log.info(sessionFactory.getConfiguration().getEnvironment().getDataSource().toString());
         sqlsession = sessionFactory.openSession();
         //log.info(sqlsession.getConfiguration().getEnvironment().getDataSource().toString());
         
         VehicleMapper mapper = sqlsession.getMapper(VehicleMapper.class);
         List<Vehicle> vehicles = mapper.selectAll();
         
         for (Vehicle c: vehicles)
            {
            obj.put("idVehicle", c.getIdvehicle());
            obj.put("Lic_plate_number", c.getLic_plate_number());
            obj.put("Description", c.getDescription());
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