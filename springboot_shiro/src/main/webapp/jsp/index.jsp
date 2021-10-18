<%--
  Created by IntelliJ IDEA.
  User: mayating
  Date: 2021/10/14
  Time: 6:25 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <h1>系统主页</h1>
    <ul>
        <a href="${pageContext.request.contextPath}/user/logout">退出登录</a>
        <li><a href="">用户管理</a> </li>
        <li><a href="">商品管理</a> </li>
        <li><a href="">商户管理</a> </li>
        <li><a href="">内容管理</a> </li>
    </ul>
</body>
</html>
