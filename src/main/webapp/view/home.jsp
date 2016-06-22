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
        <h2>借阅排行榜</h2>
        <hr width="140px" size="3" align="center" color="grey">
        <div class="book">
            <div class="bookHeader">
            </div>
            <table class="returnbook">
                <tr>
                    <td>序号</td>
                    <td>书籍编号</td>
                    <td>图书名称</td>
                    <td>图书类型</td>
                    <td>书架</td>
                    <td>出版社</td>
                    <td>作者</td>
                    <td>定价</td>
                    <td>借阅次数</td>
                </tr>
                <tr>
                    <td>
                        <input name="number" type="text" id="number">
                    </td>
                    <td>
                        <input name="bookId" type="text" id="bookId">
                    </td>
                    <td>
                        <input name="bookName" type="text" id="bookName">
                    </td>
                    <td>
                        <input name="bookType" type="text" id="bookType">
                    </td>
                    <td>
                        <input name="bookShelf" type="text" id="bookShelf">
                    </td>
                    <td>
                        <input name="press" type="text" id="press">
                    </td>
                    <td>
                        <input name="author" type="text" id="author">
                    </td>
                    <td>
                        <input name="price" type="text" id="price">
                    </td>
                    <td>
                        <input name="borrowTimes" type="text" id="borrowTimes">
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <%@include file="banner.jsp"%>
</body>

</html>
