<%@ page session="true" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authentication property="principal" var="auth" scope="session" />

<html>
<body>
<h2>Hello World!</h2>
<form action="<%=request.getContextPath()%>/login/action" method="POST">
<table>
    <tr><td>User:</td><td><input type="text" name="username" /></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password" /></td></tr>
    <tr><td><input type="submit" value="Login" /></td></tr>
</table>
</form>
</body>
</html>
