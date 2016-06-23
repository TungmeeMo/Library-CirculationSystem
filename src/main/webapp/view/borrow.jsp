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
<%@include file="navigation.jsp"%>

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
                         <span id="readerName"></span>
                    </td>
                    <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:
                        <span id="readerGenderName"></span>
                    </td>
                    <td>读者类型:
                        <span id="readerTypeName"></span>
                    </td>
                </tr>
                <tr>
                    <td>读者地址:
                        <span id="readerAddress"></span>
                    </td>
                    <td>联系电话:
                        <span id="readerTelephone"></span>
                    </td>
                    <td>登记日期:
                        <span id="readerRegisterDate"></span>
                    </td>
                </tr>
                <tr>
                    <td>已借数量:
                        <span id="readerBorrowbook"></span>
                    </td>
                    <td>读者状态:
                        <span id="statusName"></span>
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
  <%@include file="banner.jsp"%>
</body>

</html>
