<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<%@include file="bar.jsp" %>
<div class="container clearfix">
	<%@include file="menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">我的申请</span></div>
        </div>
        <div class="result-wrap">
        	<div class="result-content">
            	<table class="result-tab" width="100%">
                	<tr>
                        <th>编号</th>
                        <th>调班星期</th>
                        <th>调班时间</th>
                        <th>原因</th>
                        <th>状态</th>
                        <th>提交时间</th>
                      </tr>
                      <c:forEach var="re" items="${list }">
                      	<tr>
                        	<td>${re.id }</td>
                        	<td>${re.week }</td>
                            <td>${re.time }</td>
                            <td>${re.reason }</td>
	                        <td>${re.state }</td>
	                        <td>${re.subtime }</td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>