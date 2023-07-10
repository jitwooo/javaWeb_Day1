<%@ page import="com.zjh.utils.User" %><%--
  Created by IntelliJ IDEA.
  User: mi
  Date: 2023/7/10
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>

<body>
<h1>用户信息</h1><br/>
<h3>姓名：<%=((User)session.getAttribute("user")).getName()%></h3><br/>
<h3>年龄：<%=((User)session.getAttribute("user")).getAge()%></h3><br/>
</body>
</html>
