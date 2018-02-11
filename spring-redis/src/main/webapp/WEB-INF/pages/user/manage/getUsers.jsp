<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: renho
  Date: 2018/2/11
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td style="border: 1px solid;">${user.id}</td>
                <td style="border: 1px solid;">${user.userName}</td>
                <td style="border: 1px solid;">${user.sex}</td>
                <td style="border: 1px solid;">${user.age}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/user/manage/index">返回</a>
</body>
</html>
