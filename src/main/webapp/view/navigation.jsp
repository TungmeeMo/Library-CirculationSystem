<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
 <div class="header">
        <h1>图书馆管理系统</h1>
        <div id="menu">
            <ul>
                <li><a href="${ctx}/view/home.jsp">主页</a>
                </li>
                <li><a href="#">图书管理</a>
                    <ul>
                        <li><a href="${ctx}/view/borrow.jsp">借书管理</a></li>
                        <li><a href="${ctx}/view/return.jsp">还书管理</a></li>
                    </ul>
                </li>
                <li><a href="${ctx}/view/reader.jsp">读者信息管理</a>
                </li>
                <li><a href="#">参数设置</a>
                    <ul>
                        <li><a href="${ctx}/view/authority.jsp">设置流通权限</a></li>
                    </ul>
                </li>
                <li><a href="${ctx}/view/login.jsp">退出系统</a>
                </li>
            </ul>
        </div>
    </div>