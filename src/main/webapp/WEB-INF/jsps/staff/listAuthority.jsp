<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
</head>
<body>
${message}
<table>
<tr><td>权限名称</td><td>备注</td></tr>
<c:forEach var="item" items="${list}">
<tr>
<td>${item.authorityName}</td>
<td>${item.remarks}</td>
<td><a href="${pageContext.request.contextPath }/staffAuthority/toEdit?id=${item.authorityId}">修改</a></td>
<td><a href="${pageContext.request.contextPath }/staffAuthority/delete?id=${item.authorityId}">删除</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>