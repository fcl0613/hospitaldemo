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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">科室查询</span></div>
        </div>
        <div class="result-wrap">
            <form action="/hospital/manage/deletedepartment" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="adddepartment.jsp"><i class="icon-font"></i>新增科室</a>
                        <a id="batchDel" href="javascript:deleteMore('确定批量删除科室','myform')"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="/hospital/manage/selectalldepartment"><i class="icon-font"></i>刷新</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectAll(this)" type="checkbox"></th>
                            <th>科室ID</th>
                            <th>类别</th>
                            <th>科室名字</th>
                            <th>地点位置</th>
                            <th>描述</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="dep" items="${list }">
                        	<tr>
                        		<td class="tc"><input name="id[]" value="${dep.id }" type="checkbox"></td>
                        		<td>${dep.id }</td>
                        		<td>
                        			<c:if test="${dep.type == 0 }">内科</c:if>
                        			<c:if test="${dep.type == 1 }">外科</c:if>
                        		</td>
                        		<td>${dep.name }</td>
                            	<td>${dep.location }</td>
	                        	<td>${dep.describe }</td>
	                        	<td>
                                	<a class="link-update" href="/hospital/manage/toupdatedepartment?depid=${dep.id }&depname=${dep.name }&deptype=${dep.type }&deplocation=${dep.location }&depdesc=
										${dep.describe }">修改</a>
                                	<a class="link-del" href="javascript:Delete('确定要删除该信息?', 'deletedepartment?depid=${dep.id }')">删除</a>
                            	</td>
                        	</tr>
                        </c:forEach>
                    </table>
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
	
	function selectAll(o){
		var a = document.getElementsByName("id[]");
		for(var i=0;i<a.length;i++){
			a[i].checked = o.checked;
		}
	}
	
	function deleteMore(mess, formname){
		if(confirm(mess)){
			var form = document.getElementById(formname);
			form.submit();
		}	
	}
</script>
</body>
</html>