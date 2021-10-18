<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    <style type="text/css">
        *{margin: 0;padding: 0;}
        form{margin: 0 auto;padding:15px; width: 300px;height:300px;text-align: center;}
        #submit{padding: 10px}
        #submit input{width: 50px;height: 24px;}
    </style>
</head>
<body>
<h1>注册页</h1>

<form action="${pageContext.request.contextPath}/user/register" method="post">
    用户名：<input type="text" name ="username"/><br/>
    密 码 ：<input type="text" name ="password"/><br/>
    <input type="submit" value="立即注册"><br/>
</form>
</body>
</html>

