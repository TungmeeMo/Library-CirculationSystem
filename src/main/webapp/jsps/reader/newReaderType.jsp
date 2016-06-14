<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建读者类型</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/readerType/new" method="POST">
<table>
    <tr><td>权限名称:</td><td><input type="text" name="authorityName" /></td></tr>
    <tr><td>备注:</td><td><input type="text" name="remarks" /></td></tr>
    <tr><td><input type="submit" value="增加" /></td></tr>
</table>
</form>

</body>
</html>