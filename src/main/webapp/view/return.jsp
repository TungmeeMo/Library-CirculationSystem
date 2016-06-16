<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>还书管理</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <div class="header">
        <h1>图书馆管理系统</h1>
        <div id="menu">
            <ul>
                <li><a href="home.html">图书管理</a>
                    <ul>
                        <li><a href="home.jsp">借书管理</a></li>
                        <li><a href="return.jsp">还书管理</a></li>
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
        <h2>图书归还</h2>
        <hr width="140px" size="3" align="center" color="grey">
        <div class="book">
            <div class="bookHeader">
                <h3>借阅信息</h3> 借阅编号:
                <input name="bookId" type="text" id="bookID">
                <input name="button2" type="button" value="搜索">
                <input name="button3" type="button" value="借阅">
            </div>
            <hr width="959px" size="1">
            <table>
                <tr>
                    <td>员工编号</td>
                    <td>读者编号</td>
                    <td>书籍编号</td>
                    <td>借书日期</td>
                    <td>还书日期</td>
                    <td>应还日期</td>
                    <td>借阅状态</td>
                    <td>续借次数</td>
                    <td>操作类型</td>
                </tr>
                <tr>
                    <td>
                        <input name="typeId" type="text" id="typeID">
                    </td>
                    <td>
                        <input name="bookName" type="text" id="bookName">
                    </td>
                    <td>
                        <input name="authorName" type="text" id="authorName">
                    </td>
                    <td>
                        <input name="publishingHouse" type="text" id="publishingHouse">
                    </td>
                    <td>
                        <input name="publishingDate" type="text" id="publishingDate">
                    </td>
                    <td>
                        <input name="readerRegisterDate" type="text" id="readerRegisterDate">
                    </td>
                    <td>
                        <input name="isBorrowed" type="text" id="isBorrowed">
                    </td>
                </tr>
            </table>
        </div>
        <hr width="959px" size="1">
        <div class="reader">
            <div class="readerHeader">
                <h3>读者信息</h3> 读者编号:
                <input name="readerId" type="text" id="readerId">
                <input name="button1" type="button" value="搜索">
            </div>
            <hr width="959px" size="1">
            <table>
                <tr>
                    <td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:
                        <input name="name" type="text" id="readerName">
                    </td>
                    <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:
                        <input name="readerGender" type="text" id="readerGender">
                    </td>
                    <td>读者类型:
                        <input name="readerType" type="text" id="readerType">
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
                        <input name="status" type="text" id="status">
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
