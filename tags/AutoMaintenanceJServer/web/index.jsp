<%--
    Document   : index
    Created on : 3/Set/2011, 20:48:22
    Author     : E.Fil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="am.controler.servlet.BasicServlet"%>
<%
StringBuilder errors = new StringBuilder();
String servletClassName = request.getPathInfo();
if (servletClassName == null || servletClassName.equals("")) {
  //redirect to web view
  out.println("<br/>request.getContextPath() " + request.getContextPath());
  out.println("<br/>request.getPathInfo() " + request.getPathInfo());
  out.println("<br/>request.getPathTranslated() " + request.getPathTranslated());
  out.println("<br/>request.getQueryString() " + request.getQueryString());
  out.println("<br/>request.getRequestURI() " + request.getRequestURI());
  out.println("<br/>request.getRequestURL() " + request.getRequestURL());
  out.println("<br/>request.getServletPath() " + request.getServletPath());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
<%
} else {
  if (servletClassName.contains("/")) {
    servletClassName = servletClassName.substring(servletClassName.lastIndexOf("/")+1);
  }
  if (servletClassName.startsWith(".")) {
    servletClassName = servletClassName.substring(1);
  }
  BasicServlet servletClass = null;
  try {
    servletClass = (BasicServlet)Class.forName("am.controler.servlet." + servletClassName).newInstance();
    servletClass.workit(request, response, out);
  } catch (Exception e) {
    errors.append(e.getMessage()).append("\n");
    out.print(e);
  }
}
%>
