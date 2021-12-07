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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">公告查询</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="" method="get">
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
                        <a href="addannouncement.jsp"><i class="icon-font"></i>新增公告</a>
                        <a id="updateOrd" href="selectannouncement"><i class="icon-font"></i>刷新</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectAll(this)" type="checkbox"></th>
                            <th>公告ID</th>
                            <th>标题</th>
                            <th>发布者</th>
                            <th>发布时间</th>
                            <th>是否下架</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="ann" items="${list }">
                        	<tr>
                        		<td class="tc"><input name="id[]" value="${ann.id }" type="checkbox"></td>
                        		<td>${ann.id }</td>
                        		<td>${ann.title }</td>
                            	<td>${ann.author }</td>
	                        	<td>${ann.releasedate }</td>
	                        	<td>
                        			<c:if test="${ann.isdel == 0 }">否</c:if>
                        			<c:if test="${ann.isdel == 1 }">是</c:if>
                        		</td>
	                        	<td>
                                	<a class="link-update" href="toupdateannouncement?id=${ann.id }&title=${ann.title }&author=${ann.author }&releasedate=${ann.releasedate }&isdel=${ann.isdel }">修改</a>
                                	<c:if test="${ann.isdel == 0 }">
                                		<a class="link-del" href="javascript:Delete('确定要下架该公告?', 'shelvesannouncement?id=${ann.id }')">下架</a>
                                	</c:if>
                                	<c:if test="${ann.isdel == 1 }">
                                		<a class="link-del" href="javascript:Delete('确定要上架该公告?', 'releaseannouncement?id=${ann.id }')">上架</a>
                                	</c:if>
                            	</td>
                        	</tr>
                        </c:forEach>
                    </table>
                    <div class="list-page">
						<a href="selectannouncement?cp=1${searchelement }">首页</a>
						<a href="selectannouncement?cp=${cpage-1 < 1 ? 1:cpage-1}${searchelement }">上一页</a>
						<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        	共${tsum }条记录,当前第${cpage }/${totalpage }页
						<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <a href="selectannouncement?cp=${cpage+1 > totalpage ? totalpage:cpage+1}${searchelement }">下一页</a>
                        <a href="selectannouncement?cp=${totalpage }${searchelement }">尾页</a>
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