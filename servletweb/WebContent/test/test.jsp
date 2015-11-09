<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	Server Info:
	<%
		out.println(request.getLocalAddr() + " : " + request.getLocalPort()+"<br>");%>
	<% 
  out.println("<br>ID " + session.getId()+"<br>"); 

  // 如果有新的Session 属性设置
  String dataName = request.getParameter("dataName"); 
  if (dataName != null && dataName.length() > 0) { 
     String dataValue = request.getParameter("dataValue"); 
     session.setAttribute(dataName, dataValue); 
  } 
  out.print(" <b>Session 列表</b>"); 
  Enumeration e = session.getAttributeNames(); 
  while (e.hasMoreElements()) { 
     String name = (String)e.nextElement(); 
     String value = session.getAttribute(name).toString(); 
     out.println( name + " = " + value+"<br>"); 
     System.out.println( name + " = " + value);
   } 

%>
	<form action="index.jsp" method="POST">
		名称:<input type=text size=20 name="dataName"><br>
		值:<input type=text size=20 name="dataValue"><br>
		<input type=submit></form>
	<script type="text/javascript">
		var i8210 = 020301;
		console.info(i8210);
	</script>
</body>
</html>