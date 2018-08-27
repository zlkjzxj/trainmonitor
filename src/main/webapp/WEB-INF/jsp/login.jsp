<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>高铁视频导出系统</title>
</head>
<body>
<link href="${pageContext.request.contextPath }/static/index.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/static/bootstrap/css/bootstrap.css" rel="stylesheet"/>
<div style="width: 30%;margin: 0 auto;text-align: center;padding-top: 100px;font-size: 30px;">高铁视频导出系统</div>
<div style="width: 30%;margin: 0 auto;padding-top: 50px;">
    <form action="${pageContext.request.contextPath }/login" method="post" name="loginForm" id="loginForm">
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="input" class="form-control" name="username" id="username"  placeholder="输入用户名">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="输入密码">
        </div>
        <button type="submit" class="btn btn-primary" style="width: 100%">登录</button>
    </form>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/index.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap/js/bootstrap.js"></script>

</html>