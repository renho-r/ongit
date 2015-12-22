<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>restful</title>
</head>
<body>
	<form method="GET" action="api/user/100">
		<input type="submit" value="get" id="get">
	</form>
	<form method="POST" action="api/user">
		<input type="text" name="id" value="200">
		<input type="text" name="name" value="中文">
		<input type="submit" value="post" id="post">
	</form>
	<form method="POST" action="api/user">
		<input type="hidden" name="_method" value="put">
		<input type="text" name="id" value="300">
		<input type="text" name="name" value="renho300">
		<input type="submit" value="put" id="put">
	</form>
	<form method="POST" action="api/user/400">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="delete" id="delete">
	</form>
	<a href="httpmethod.html">httpmethod.html</a>
</body>
</html>