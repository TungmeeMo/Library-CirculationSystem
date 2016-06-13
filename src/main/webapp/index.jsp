<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<body>
<h2>Library-CirculationSystem</h2>

<form action="<%=request.getContextPath()%>/login/action" method="POST">
<table>
    <tr><td>User:</td><td><input type="text" name="username" /></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password" /></td></tr>
    <tr><td><input type="submit" value="Login" /></td></tr>
</table>
</form>

<a href="${pageContext.request.contextPath }/j_spring_security_logout">Log out</a><br><br>

<a href="${pageContext.request.contextPath }/password">New password</a><br>
<a href="${pageContext.request.contextPath }/user/list">Key manager</a>
</body>
</html>

