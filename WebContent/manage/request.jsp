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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">调班申请查询</span></div>
        </div>
        <div class="result-wrap">
            <form action="" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a id="updateOrd" href="selectdocsreq"><i class="icon-font"></i>刷新</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>编号</th>
                            <th>医生姓名</th>
                            <th>调班时间</th>
                            <th>原因</th>
                            <th>状态</th>
                            <th>提交时间</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="req" items="${list }">
                        	<tr>
                        		<td>${req.id }</td>
                        		<td>${req.dname }</td>
                        		<td>下星期的${req.week }的${req.time }</td>
	                        	<td>${req.reason }</td>
	                        	<td>${req.state}</td>
	                        	<td>${req.subtime}</td>
	                        	<td>
	                        		<c:if test="${req.state eq '等待' }">
	                        			<a class="link-update" href="agreereq?id=${req.id }">同意</a>
                                		<a class="link-del" href="disagreereq?id=${req.id }">拒绝</a>
	                        		</c:if>
                                	<c:if test="${req.state eq '同意' || req.state eq '拒绝' }">
	                        			已处理
	                        		</c:if>
                            	</td>
                        	</tr>
                        </c:forEach>
                    </table>
                    <div class="list-page">
						<a href="selectdocsreq?cp=1${searchelement }">首页</a>
						<a href="selectdocsreq?cp=${cpage-1 < 1 ? 1:cpage-1}">上一页</a>
						<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        	共${tsum }条记录,当前第${cpage }/${totalpage }页
						<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <a href="selectdocsreq?cp=${cpage+1 > totalpage ? totalpage:cpage+1}">下一页</a>
                        <a href="selectdocsreq?cp=${totalpage }">尾页</a>
                   </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>