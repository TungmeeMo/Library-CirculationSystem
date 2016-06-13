<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>测试一</title>

<script type="text/javascript">
        function del(){
            window.location.href="/SSM-test/user/delete?id="+document.getElementById('id').value;
        }
</script>
<script>
        function newOne(v){
            if(v>0) {
                document.userForm.action="/SSM-test/user/add";
            }else {
                document.userForm.action="/SSM-test/user/update";
            }
            
        }
        function clk(id , userName , roleId){
            document.getElementById('id').value = id;
            document.getElementById('name').value = userName;
            document.getElementById('roleId').value = roleId;
        }
</script>
</head>
<body>
	<fieldset>
        <legend>Key Manager</legend>
        <center>
        <form:form commandName="user" action="" name="userForm" >
        <table>
            <tr>
            <td colspan="2" align="left"><form:errors path="*" cssStyle="color : red;"/></td>
            </tr>
            <tr>
            <td>Id</td><td><form:input id="id" path="id" /></td>
            </tr>
            <tr>
            <td>Name</td><td><form:input id="name" path="userName"/></td>
            </tr>
            <tr>
            <td>Level</td><td><form:input id="roleId" path="roleId"/></td>
            </tr>
            <tr>
            <td colspan="2"><input type="submit" value="New User" onclick="newOne(1);"/>
            &nbsp;<input type="submit" name="saveChanges" value="Save Changes" onclick="newOne(0);"/>
            &nbsp;<input type="button" name="deleteUser" value="Delete User" onclick="del();" /></td></tr>
        </table>
        </form:form>
        </center>
        </fieldset>
        <center>
            <table>
                <tr style="background-color: gray;">
                    <th>Id</th>
                    <th>Name</th>
                    <th>Level</th>
                    <c:forEach items="${userList}" var="user">
                        <tr style="background-color:silver;" id="${user.id}" onclick="clk('${user.id }','${user.userName }','${user.roleId }')">
                            
                            <td><c:out value="${user.id }"/></td>
                            <td><c:out value="${user.userName }"/></td>
                            <td><c:out value="${user.roleId }"/></td>
                        </tr>
                            </c:forEach>
                        </table>
                        <br><a href="<%=request.getContextPath() %>">Home</a>
                        </center>
                    <br />
	
</body>
</html>