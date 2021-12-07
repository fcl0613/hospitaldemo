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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-step">&gt;</span><span>个人信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="updategrxx" method="post" id="myform" name="myform" enctype="multipart/form-data" onsubmit="return checkForm(this)">
                    <input type="hidden" name="picture" value="${doctorv.imagepath }"/>
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                                <th>更换图片:</th>
                                <td>
                                	<img width="80" height="80" alt="图片加载失败" src="../pic/${doctorv.imagepath }">
                                	<input name="pic" id="pic" value="" type="file" onchange="verificationPicFile(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red"></i>医生账号:</th>
                                <td>
                                    <input class="common-text required" id="title" name="account" size="50" value="${doctorv.account }" type="text" readonly="readonly">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red"></i>姓名:</th>
                                <td>
                                    <input class="common-text required" id="title" name="dname" size="50" value="${doctorv.name}" type="text" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                            	<th width="120">性别:</th>
                            	<td>
                            		<c:if test="${doctorv.gender == 0 }">
                            			<input type="radio" name="gender" checked="checked" value="0">男
                                		<input type="radio" name="gender" value="1">女
                            		</c:if>
                            		<c:if test="${doctorv.gender == 1 }">
                            			<input type="radio" name="gender" value="0">男
                                		<input type="radio" name="gender" checked="checked" value="1">女
                            		</c:if>
                                	<span class="error" id="err"></span>
                            	</td>
                        	</tr>
                           <tr>
                                <th>年龄:</th>
                                <td><input class="common-text" name="age" size="50" value="${doctorv.age }" type="text" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th>描述:</th>
                                <td><input class="common-text" name="description" size="50" value="${doctorv.description }" type="text" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th>任职:</th>
                                <td>
                                	<input class="common-text" name="car" size="50" value="${doctorv.career }" type="text" readonly="readonly">
                                </td>
                            </tr>
                            <tr>
                                <th>部门:</th>
                                <td>
                                	<input class="common-text" name="dep" size="50" value="${doctorv.department }" type="text" readonly="readonly">
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
	
function verificationPicFile(file) {
    var fileTypes = [".jpg", ".png", ".jpeg", ".PNG", ".gif"];//文件后缀只能是这五类
    var filePath = document.getElementById("pic").value;//返回的是上传文件的路径名 例如：E:\xx\xxx.jpg
    //当括号里面的值为0、空字符、false 、null 、undefined的时候就相当于false
    if(filePath){
        var isNext = false;
        var fileEnd = filePath.substring(filePath.indexOf("."));//截取文件名的后缀
        for (var i = 0; i < fileTypes.length; i++) {
            if (fileTypes[i] == fileEnd) {
                isNext = true;
                break;
            }
        }
        if (!isNext){
            alert('不接受此文件类型');
            document.getElementById("pic").value = "";//如果文件后缀名不符合，清空已选择文件
            return false;
        }
    }else {
        return false;
    }
}
	
	var flag = true;
	function checkItem(obj){
		var v = obj.value;
		var name = $(obj).attr('name');
		var b = $(obj).next("span");
		switch(name){
			case"dname":
				var uPattern = /^[\u4E00-\u9FA5A-Za-z0-9]{2,20}$/;
				if(!uPattern.test(v)){
					b.html('请输入正确的名字');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
			case"age":
				var uPattern = /^\d{2,3}$/;
				if(!uPattern.test(v)){
					b.html('请输入正确的年龄');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
			case"description":
				var uPattern = /^[\u4E00-\u9FA5A-Za-z0-9]{2,200}$/;
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