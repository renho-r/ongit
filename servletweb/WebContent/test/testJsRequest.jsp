<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("renho")%>
<script type="text/javascript">
alert(<%=request.getAttribute("renho")%>);
alert('<%=request.getAttribute("renho")%>');
var i8210 = 020301;
console.info(i8210);
</script>
</body>
</html>