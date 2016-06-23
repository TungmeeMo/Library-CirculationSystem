<%@ page language="java" import="java.util.*,szu.library.cs.pojo.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>还书管理</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link href="${ctx}/view/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/view/js/jquery.min.js"></script> 
	<script type="text/javascript" src="${ctx}/view/js/jquery.json-2.2.min.js"></script>  
	<script type="text/javascript" src="${ctx}/view/js/home.js"></script>
	<script type="text/javascript" src="${ctx}/view/js/setting.js"></script>
	 
	 <script type="text/javascript">
	 $(document).ready(function(){  
		 listAuthority('${ctx}','authorityinfo','light2','fade');  
	}); 
	 
	 </script>
</head>

<body>
 <%@include file="navigation.jsp"%>
  <div class="container">
        <h2>流通管理人员权限管理</h2>
        <hr width="140px" size="3" align="center" color="grey">
        <div class="book">
            <div class="bookHeader">
                    <a id="addAuthority" href="javascript:void(0)" onclick="popTabForNew('light1','fade')">新增管理权限</a>
                <div id="light1" class="white_content">
                    权限名称:
                    <input type="text" name="newAuthorityName" id="newAuthorityName">
                    <br/> 备注:
                    <input type="text" name="newRemarks" id="newRemarks">
                    <br/><br/><br/>
                    <a href="#" onclick="newAuthority('${ctx}')">保存</a>
                    <a href="javascript:void(0)" onclick="document.getElementById('light1').style.display='none';document.getElementById('fade').style.display='none'">关闭</a>
                </div>
                <div id="light2" class="white_content">
                    权限名称:
                    <input type="text" name="editAuthorityName" id="editAuthorityName">
                    <br/> 备注:
                    <input type="" name="editRemarks" id="editRemarks">
                    <input type="hidden" name="editAuthorityId" id="editAuthorityId">
                    <br/><br/><br/>
                    <a href="#" onclick="updateAuthority('${ctx}')">保存</a>
                    <a href="javascript:void(0)" onclick="document.getElementById('light2').style.display='none';document.getElementById('fade').style.display='none'">关闭</a>
                </div>
                <div id="fade" class="black_overlay"></div>
            </div>
            <table class="authorityinfo" id="authorityinfo">
                <tr>
                    <td>权限名称</td>
                    <td>备注</td>
              
                    <td>修改</td>
                    <td>删除</td>
                </tr>
            </table>
        </div>
    </div>
    <%@include file="banner.jsp"%>
</body>

</html>
 