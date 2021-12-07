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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">医生查询</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/hospital/manage/selectdoctor" method="get">
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
            <form action="/hospital/manage/deletedoctor" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="toadddoctor"><i class="icon-font"></i>新增医生</a>
                        <a id="batchDel" href="javascript:deleteMore('确定批量删除科室','myform')"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="/hospital/manage/selectdoctor"><i class="icon-font"></i>刷新</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectAll(this)" type="checkbox"></th>
                            <th>医生ID</th>
                            <th>图像</th>
                            <th>医生账号</th>
                            <th>医生姓名</th>
                            <th>性别</th>
                            <th>挂号费</th>
                            <th>年龄</th>
                            <th>描述</th>
                            <th>任职</th>
                            <th>部门</th>
                            <th>挂号类型</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="doc" items="${list }">
                        	<tr>
                        		<td class="tc"><input name="id[]" value="${doc.id }" type="checkbox"></td>
                        		<td>${doc.id }</td>
                        		<td><img width="80" height="80" alt="图片加载失败" src="../pic/${doc.imagepath }"></td>
                        		<td>${doc.account }</td>
                        		<td>${doc.name }</td>
                            	<td>
                            		<c:if test="${doc.gender==0}">男</c:if>
                            		<c:if test="${doc.gender==1}">女</c:if>
                            	</td>
	                        	<td>${doc.fee }</td>
	                        	<td>${doc.age }</td>
	                        	<td>${doc.description }</td>
	                        	<td>${doc.career.cname }</td>
	                        	<td>${doc.department.name }</td>
	                        	<td>
                            		<c:if test="${doc.redister==0}">普通</c:if>
                            		<c:if test="${doc.redister==1}">专家</c:if>
                            	</td>
	                        	<td>
                                	<a class="link-update" href="toupdatedoctor?did=${doc.id }">修改</a>
                                	<a class="link-del" href="javascript:Delete('确定要删除该信息?', 'deletedoctor?did=${doc.id }')">删除</a>
                            	</td>
                        	</tr>
                        </c:forEach>
                    </table>
                    <div class="list-page">
						<a href="selectdoctor?cp=1${searchelement }">首页</a>
						<a href="selectdoctor?cp=${cpage-1 < 1 ? 1:cpage-1}${searchelement }">上一页</a>
						<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        	共${tsum }条记录,当前第${cpage }/${totalpage }页
						<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <a href="selectdoctor?cp=${cpage+1 > totalpage ? totalpage:cpage+1}${searchelement }">下一页</a>
                        <a href="selectdoctor?cp=${totalpage }${searchelement }">尾页</a>
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