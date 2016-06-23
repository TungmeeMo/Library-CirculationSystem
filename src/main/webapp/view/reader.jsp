<%@ page language="java" import="java.util.*,szu.library.cs.pojo.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%Staff staff = (Staff)request.getSession().getAttribute("currUser");
 int staffId = staff.getStaffId();
%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>流通管理系统</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="description" content="">
    <meta name="keywords" content="">
    <link href="${ctx}/view/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/view/js/jquery.min.js"></script> 
	<script type="text/javascript" src="${ctx}/view/js/jquery.json-2.2.min.js"></script>    
	<script type="text/javascript" src="${ctx}/view/js/home.js"></script>
</head>

<body>
 <%@include file="navigation.jsp"%>
<div class="container">
        <h2>读者信息管理</h2>
        <hr width="140px" size="3" align="center" color="grey">
        <div class="book">
            <div class="bookHeader">
                读者编号:
                <input name="readerId" type="text" id="readerID">
                <input name="button2" type="button" value="搜索" onclick="selectReaderById('${ctx}')">
    <a href="javascript:void(0)" onclick="document.getElementById('light2').style.display='block';document.getElementById('fade').style.display='block'">新增读者</a>
                <div id="light1" class="white_content">
                    <br/> 姓名:
                    <input type="text" id="name">
                    <br/> 性别:
                    <input type="radio" id="male1" checked="checked" name="sex" value="1">
                    <label for="male">男</label>
                    <input type="radio" id="female1" name="sex" value="2"> 
                    <label for="female">女</label>
                    <br/> 读者类型:
                    <select id="readerType1">
                        <option value ="1">学生</option>
                        <option value ="2">教师</option>
                        <option value="3">外来人员</option>
                    </select>
                    <br/> 读者地址:
                    <input type="text" id="readerAddress">
                    <br/> 联系电话:
                    <input type="text" id="readerTelephone">
                    <br/> 登记日期:
                    <input type="text" id="readerRegisterDate" readonly>
                    <br/> 已借数量:
                    <input type="text" id="readerBorrowbook">
                    <br/> 读者状态:
                    <select id="status1">
                        <option value ="1">正常</option>
                        <option value ="2">借满</option>
                        <option value="3">超期</option>
                        <option value="4">暂停</option>
                        <option value="5">欠款</option>
                        <option value="6">违约</option>
                        <option value="7">挂失</option>
                        <option value="8">退证</option>
                        <option value="9">失效</option>
                    </select>
                    <br/>
                    <a href="javascript:updateReader('${ctx}')" >保存</a>
                    <a href="javascript:void(0)" onclick="document.getElementById('light1').style.display='none';document.getElementById('fade').style.display='none'">关闭</a>
                </div>
                <div id="light2" class="white_content">
                    <br/> 姓名:
                    <input type="text" id="name">
                    <br/> 性别:
                    <input type="radio" id="male" checked="checked" name="sex">
                    <label for="male">男</label>
                    <input type="radio" id="female" name="sex">
                    <label for="female">女</label>
                    <br/> 读者类型:
                    <select id="readerType">
                        <option value ="1">学生</option>
                        <option value ="2">教师</option>
                        <option value="3">外来人员</option>
                    </select>
                    <br/> 读者地址:
                    <input type="text" id="readerAddress">
                    <br/> 联系电话:
                    <input type="text" id="readerTelephone">
                    <!--
                    <br/> 登记日期:
                    <input type="text" name="readerRegisterDate">
                    <br/> 已借数量:
                    <input type="text" name="readerBorrowbook">
                    <br/> 读者状态:
                    <input type="text" name="status">-->
                    <br/>
                    <!--<input name="button3" type="button" value="保存" onclick="addReader('${ctx}')">-->
                    <a href="javascript:addReader('${ctx}')">保存</a>
                    <a href="javascript:void(0)" onclick="document.getElementById('light2').style.display='none';document.getElementById('fade').style.display='none'">关闭</a>
                </div>
                <div id="fade" class="black_overlay"></div>
            </div>
            <table class="readerinfo" id="table">
                <tr>
                    <td>读者编号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>读者类型</td>
                    <td>读者地址</td>
                    <td>联系电话</td>
                    <td>登记日期</td>
                    <td>已借数量</td>
                    <td>读者状态</td>
                    <td>修改</td>
                    <td>删除</td>
                </tr>
                <tr>
                    <td>
                        <input name="readernumber" type="text" id="readerNumber" readonly>
                    </td>
                    <td>
                        <input name="name" type="text" id="name" readonly>
                    </td>
                    <td>
                        <input name="readerGender" type="text" id="readerGender" readonly>
                    </td>
                    <td>
                        <input name="readerType" type="text" id="readerType" readonly>
                    </td>
                    <td>
                        <input name="readerAddress" type="text" id="readerAddress" readonly>
                    </td>
                    <td>
                        <input name="readerTelephone" type="text" id="readerTelephone" readonly>
                    </td>
                    <td>
                        <input name="readerRegisterDate" type="text" id="readerRegisterDate" readonly>
                    </td>
                    <td>
                        <input name="readerBorrowbook" type="text" id="readerBorrowbook" readonly>
                    </td>
                    <td>
                        <input name="status" type="text" id="status" readonly>
                    </td>
                    <td>
                        <a href="javascript:updateOnclick()">修改</a>
                    </td>
                    <td>
                        <a href="#" onclick="deleteReader('${ctx}')">删除</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
       <%@include file="banner.jsp"%>
</body>

</html>
