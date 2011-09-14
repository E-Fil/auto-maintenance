<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="am.model.dao.User"%>
<%@page import="am.model.factories.StdUserFactory"%>
<%@page import="java.util.List"%>

<%
  JSONObject obj = new JSONObject();

  StdUserFactory userFactory = StdUserFactory.getInstance();

  try {
    List<User> users = userFactory.listAllUsers();

    for (User u : users) {
      obj.put("id", u.getId());
      obj.put("username", u.getusername());
      obj.put("password", u.getpassword());
      out.print(obj);
      out.print("\n");
    }
  } // end try
  catch (Exception e) {
    out.print(e);
  } // end catch


  out.flush();
%>