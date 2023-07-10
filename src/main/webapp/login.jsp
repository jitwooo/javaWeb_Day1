<%@ page import="com.zjh.utils.User" %><%--
  Created by IntelliJ IDEA.
  User: mi
  Date: 2023/7/10
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) request.getSession().getAttribute("user");
    if (user != null) {
        response.sendRedirect("success.jsp");
    }
%>


<html>
<head>
    <title>登录</title>
</head>
<body>
<form method="post" action="http://localhost:8080/login">
    用户名:<input type="text" name="username"><br/>
    密码:<input type="number" name="password"><input type="submit" value="发送">
</form>
</body>
</html>
