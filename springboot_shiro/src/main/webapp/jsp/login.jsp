<%--
  Created by IntelliJ IDEA.
  User: mayating
  Date: 2021/10/14
  Time: 6:23 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
    <h1>登录页</h1>

    <form action="${pageContext.request.contextPath}/user/login" method="post">
        用户名：<input type="text" name="username"/><br/>
        密 码 ：<input type="text" name="password"/><br/>
        <input type="submit" value="登录"/><br/>
    </form>
</body>
</html>
