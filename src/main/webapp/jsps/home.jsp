<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
login success!
welcome "${currUser.username }" ------------图书管理系统 流通子系统 
<br/>
<a href="${pageContext.request.contextPath }/staffAuthority/toNew">新增权限</a><br><br>
<a href="${pageContext.request.contextPath }/staffAuthority/toShowlist">权限列表</a><br><br>
<a href="${pageContext.request.contextPath }/staffAuthority/toNew">新增读者类型限</a><br><br>
<a href="${pageContext.request.contextPath }/staffAuthority/toShowlist">读者类型列表</a><br><br>
${message}

</body>
</html>