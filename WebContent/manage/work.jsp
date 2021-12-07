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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">排班查询</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="selectschedule" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords }" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a id="updateOrd" href="selectschedule"><i class="icon-font"></i>刷新</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>医生姓名</th>
                            <th>星期</th>
                            <th>时间</th>
                            <th>号源数</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="wv" items="${list }">
                        	<tr>
                        		<td>${wv.doctorname }</td>
                        		<td>${wv.week }</td>
                        		<td>${wv.time }</td>
	                        	<td>${wv.number }</td>
	                        	<td>${wv.state }</td>
	                        	<td>
	                        		<c:if test="${wv.iswork==0 }">
	                        			<a class="link-update" href="toaddschedule?id=${wv.doctorid }&dname=${wv.doctorname}">添加排班</a>
	                        		</c:if>
                                	<c:if test="${wv.iswork>0 }">
                                		<a class="link-update" href="toupdateschedule?id=${wv.doctorid }">修改排班</a>&nbsp;&nbsp;
                                		<a class="link-del" href="javascript:Delete('确定要删除该排班信息?', 'deleteschedule?id=${wv.id }')">删除排班</a>
                                	</c:if>
                            	</td>
                        	</tr>
                        </c:forEach>
                    </table>
                    <div class="list-page">
						<a href="selectschedule?cp=1${searchelement }">首页</a>
						<a href="selectschedule?cp=${cpage-1 < 1 ? 1:cpage-1}${searchelement }">上一页</a>
						<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        	共${tsum }条记录,当前第${cpage }/${totalpage }页
						<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <a href="selectschedule?cp=${cpage+1 > totalpage ? totalpage:cpage+1}${searchelement }">下一页</a>
                        <a href="selectschedule?cp=${totalpage }${searchelement }">尾页</a>
                   </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
<script type="text/javascript">
	function Delete(message,url){
		if(confirm(message)){
			location.href=url;
		}
	}
</script>
</body>
</html>