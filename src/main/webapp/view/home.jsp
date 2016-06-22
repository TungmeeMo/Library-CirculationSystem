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
<script type="text/javascript">

</script>

    <div class="header">
        <h1>图书馆管理系统</h1>
        <div id="menu">
            <ul>
                <li><a href="${ctx}/view/home.jsp">图书管理</a>
                    <ul>
                        <li><a href="${ctx}/view/home.jsp">借书管理</a></li>
                        <li><a href="${ctx}/view/return.jsp">还书管理</a></li>
                    </ul>
                </li>
                <li><a href="#">账目管理</a>
                </li>
                <li><a href="#">读者信息管理</a>
                    <ul>
                        <li><a href="#">增加读者信息</a></li>
                        <li><a href="#">修改读者信息</a></li>
                        <li><a href="#">删除读者信息</a></li>
                        <li><a href="#">查询读者信息</a></li>
                        <li><a href="#">导出读者信息</a></li>
                    </ul>
                </li>
                <li><a href="#">预约管理</a>
                </li>
                <li><a href="#">参数设置</a>
                    <ul>
                        <li><a href="#">设置图书类型</a></li>
                        <li><a href="#">设置流通权限</a></li>
                        <li><a href="#">设置系统参数</a></li>
                        <li><a href="#">设置用户参数</a></li>
                        <li><a href="#">其他</a></li>
                    </ul>
                </li>
                <li><a href="login.html">退出系统</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="container">
        <h2>图书借阅</h2>
        <hr width="140px" size="3" align="center" color="grey">
        <div class="reader">
            <div class="readerHeader">
                <h3>读者信息</h3> 读者编号:
                <input name="readerId" type="text" id="readerId">
                <input id="queryReader" name="queryReader" type="button" onclick="queryReaderById('${ctx}','readerBorrowInfo')" value="搜索">
            </div>
            <hr width="959px" size="1">
            <table class="readerinfo">
                <tr>
                    <td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:
                        <input name="name" type="text" id="readerName">
                    </td>
                    <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:
                        <input name="readerGenderName" type="text" id="readerGenderName">
                    </td>
                    <td>读者类型:
                        <input name="readerTypeName" type="text" id="readerTypeName">
                    </td>
                </tr>
                <tr>
                    <td>读者地址:
                        <input name="readerAddress" type="text" id="readerAddress">
                    </td>
                    <td>联系电话:
                        <input name="readerTelephone" type="text" id="readerTelephone">
                    </td>
                    <td>登记日期:
                        <input name="readerRegisterDate" type="text" id="readerRegisterDate">
                    </td>
                </tr>
                <tr>
                    <td>已借数量:
                        <input name="readerBorrowbook" type="text" id="readerBorrowbook">
                    </td>
                    <td>读者状态:
                        <input name="statusName" type="text" id="statusName">
                    </td>
                </tr>
            </table>
             <hr width="959px" size="1">
            <table class="bookinfo" id="readerBorrowInfo">
                <tr>
                    <td>借阅编号</td>
                    <td>员工</td>
                    <td>读者</td>
                    <td>书籍</td>
                    <td>借书日期</td>
                    <td>还书日期</td>
                    <td>应还日期</td>
                    <td>借阅状态</td>
                    <td>续借次数</td>
                    <td>操作类型</td>
                </tr>
            </table>
        </div>
        <hr width="959px" size="1">
        <div class="book">
            <div class="bookHeader">
                <h3>图书信息</h3> 图书条形码:
                <input name="bookId" type="text" id="bookId">
                <input name="button2" type="button" value="搜索" onclick="queryBookById('${ctx}')">
                <input name="button3" type="button" value="借阅" onclick="borrowBook('${ctx}')">
                <input type="hidden" id="staffId" value="<%=staffId %>" >
            </div>
            <hr width="959px" size="1">
            <table class="book" id="showBookInfo">
                <tr>
                    <td>类别编号</td>
                    <td>书名</td>
                    <td>作者</td>
                    <td>出版社</td>
                    <td>出版日期</td>
                    <td>登记日期</td>
                    <td>是否被借出</td>
                </tr>
                <tr>
                    <td>
                    	<div id="bookTypeName"></div>
                    </td>
                    <td>
                    	<div id="bookName"></div>
                    </td>
                    <td>
                    	<div id="authorName"></div>
                    </td>
                    <td>
                    	<div id="publishingHouse"></div>
                    </td>
                    <td>
                    	<div  id="publishingDate" ></div>
                    </td>
                    <td>
                    	<div id="readerRegisterDate2"></div>
                    </td>
                    <td>
                    	<div id="isBorrowedName" ></div><input type="hidden" name="isBookBorrowed" id="isBookBorrowed" >
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div class="footer">
        <p>CopyRight © 2016 流通组全体人员 All Rights Reserved</p>
    </div>
</body>

</html>
