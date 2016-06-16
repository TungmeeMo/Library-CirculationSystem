<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>login</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link href="${ctx}/view/css/login.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <h1>图书馆管理系统</h1>
        <form action="<%=request.getContextPath()%>/login/action" method="post" class="user">
            <div>
                <select class="people">
                    <option value="系统管理员">系统管理员</option>
                    <option value="借阅工作人员">借阅工作人员</option>
                    <option value="读者">读者</option>
                </select>
            </div>
            <div>
                <input type="text" placeholder="用户名" required="" id="username" name="username"/>
            </div>
            <div>
                <input type="password" placeholder="密码" required="" id="password" name="password" />
            </div>
            <div class="submit">
               <input type="submit" value="登录" class="login">
                <input type="button" value="取消" class="cancel">
            </div>
        </form>
    </div>
</body>

</html>
