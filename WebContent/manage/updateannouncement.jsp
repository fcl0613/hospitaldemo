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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-step">&gt;</span><span>修改公告</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/hospital/manage/doupdateannouncement" method="post" id="myform" name="myform" onsubmit="return checkForm(this)">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red"></i>公告编号:</th>
                                <td>
                                    <input class="common-text required" id="title" name="id" size="50" value="${id }" type="text" readonly="readonly">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                            	<th width="120"><i class="require-red"></i>标题:</th>
                            	<td>
                            		<input class="common-text required" id="title" name="title" size="50" value="${title}" type="text" onblur="checkItem(this)" >
                                	<span class="error" id="err"></span>
                            	</td>
                        	</tr>
                            <tr>
                                <th>内容:</th>
                                <td>
                                	<textarea name="content" class="common-textarea" id="content" cols="30" style="width: 98%;" rows="10" onblur="checkItem(this)">${desc }</textarea>
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                           <tr>
                                <th>发布者:</th>
                                <td><input class="common-text" name="author" size="50" value="${author }" type="text" readonly="readonly">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th>发布时间:</th>
                                <td><input class="common-text" name="releasedate" size="50" value="${releasedate }" type="text" readonly="readonly">
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
			case"title":
				var uPattern = /^[\u4E00-\u9FA5A-Za-z0-9]{2,60}$/;
				if(!uPattern.test(v)){
					b.html('请输入正确的标题');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
			case"content":
				var uPattern = /^[\u4E00-\u9FA5A-Za-z0-9]{2,200}$/;
				if(!uPattern.test(v)){
					b.html('请输入正确的内容');
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