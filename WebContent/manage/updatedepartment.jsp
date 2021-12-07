<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
    <style>
    	.error{
    		display:inline;
    		color:#ff5151;
    		text-align:right;
    		padding-left:10px;
    		width:60px;
    	}
    </style>
</head>
<body>
<%@include file="bar.jsp" %>
<div class="container clearfix">
	<%@include file="menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-step">&gt;</span><span>添加科室</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/hospital/manage/doupdatedepartment" method="post" id="myform" name="myform" onsubmit="return checkForm(this)">
                    <input type="hidden" name="depid" value="${depid }"/>
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red"></i>科室名称:</th>
                                <td>
                                    <input class="common-text required" id="title" name="depname" size="50" value="${depname }" type="text" readonly="readonly">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                            	<th width="120"><i class="require-red"></i>分类:</th>
                            	<td>
                            		<c:if test="${deptype == 0 }">
                            			<input class="common-text required" id="title" name="deptype" size="50" value="内科" type="text" readonly="readonly">
                            		</c:if>
                                	<c:if test="${deptype == 1 }">
                            			<input class="common-text required" id="title" name="deptype" size="50" value="外科" type="text" readonly="readonly">
                            		</c:if>
                                	<span class="error" id="err"></span>
                            	</td>
                        	</tr>
                            <tr>
                                <th>地点位置:</th>
                                <td><input class="common-text" name="location" size="50" value="${deplocation }" type="text" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                           <tr>
                                <th>描述:</th>
                                <td><input class="common-text" name="desc" size="50" value="${depdesc }" type="text" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>

<script>
	
	var flag = true;
	function checkItem(obj){
		var v = obj.value;
		var name = $(obj).attr('name');
		var b = $(obj).next("span");
		switch(name){
			case"location":
				var uPattern = /^[\u4E00-\u9FA5A-Za-z0-9]{2,20}$/;
				if(!uPattern.test(v)){
					b.html('请输入正确的位置信息');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
			case"desc":
				var uPattern = /^[\u4E00-\u9FA5]{2,60}$/;
				if(!uPattern.test(v)){
					b.html('请输入正确的信息');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
		}
	}
	
	
	function checkForm(frm){
		var els = frm.getElementsByTagName('input');
		for (var i = 0; i < els.length; i++) {
			if (els[i] != null) {
				if (els[i].getAttribute("onblur")) {
					checkItem(els[i]);
				}
			}
		}
		return flag;
	}
	
</script>

</html>