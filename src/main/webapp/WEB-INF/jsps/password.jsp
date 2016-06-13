<%@ page session="true" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<body>
<h3>New Password</h3>
<form action="/SSM-test/password/save" method="POST">
<table>
    <tr><td>User:</td><td><a><sec:authentication property="name"/></a></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password" /></td></tr>
    <tr>
    <td><input type="submit" value="Save" /></td>
    <td><a href="<%=request.getContextPath() %>">Home</a></td>
    </tr>
</table>
</form>
</body>
</html>
