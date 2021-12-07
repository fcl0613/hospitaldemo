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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-step">&gt;</span><span>添加医生信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/hospital/manage/doadddoctor" method="post" id="myform" name="myform" enctype="multipart/form-data" onsubmit="return checkForm(this)">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red"></i>医生账号:</th>
                                <td>
                                    <input class="common-text required" id="title" name="account" size="50" value="" type="text" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red"></i>姓名:</th>
                                <td>
                                    <input class="common-text required" id="title" name="dname" size="50" value="" type="text" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                            	<th width="120">性别:</th>
                            	<td>
                            		<input type="radio" name="gender" checked="checked" value="0">男
                                	<input type="radio" name="gender" value="1">女
                                	<span class="error" id="err"></span>
                            	</td>
                        	</tr>
                            <tr>
                                <th>挂号费:</th>
                                <td><input class="common-text" name="fee" size="50" value="" type="text" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                           <tr>
                                <th>年龄:</th>
                                <td><input class="common-text" name="age" size="50" value="" type="text" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th>描述:</th>
                                <td><input class="common-text" name="description" size="50" value="" type="text" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th>任职:</th>
                                <td>
                                	<select name="car" id="car" class="required" onblur="checkItem(this)">
                                    	<option value="-1">请选择</option>
                                    	<option value="1">医师</option>
                                    	<option value="2">主治医师</option>
                                    	<option value="3">副主任医师</option>
                                    	<option value="4">主任医师</option>
                                	</select>
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th>部门:</th>
                                <td>
                                	<select name="dep" id="dep" class="required" onblur="checkItem(this)">
                                    	<option value="-1">请选择</option>
                                    	<c:forEach var="d" items="${deplist }">
                                    		<option value="${d.id }">${d.name }</option>
                                    	</c:forEach>
                                	</select>
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th>挂号类型:</th>
                                <td>
                                	<select name="reg" id="reg" class="required" onblur="checkItem(this)">
                                    	<option value="-1">请选择</option>
                                    	<option value="0">普通</option>
                                    	<option value="1">专家</option>
                                	</select>
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th>更换图片:</th>
                                <td>
                                	<input name="pic" id="pic" value="" type="file" onchange="verificationPicFile(this)">
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
			case"account":
				var uPattern = /^\d{11}$/;
				if(!uPattern.test(v)){
					b.html('请输入正确的工号');
					b.addClass('error');
					flag = false;
				}else{
					var url = "/hospital/manage/chickaccount?account="+encodeURI(v)+"&"+new Date().getTime();
					$.get(url, function(data){
						if(data == "false"){
							b.html('该工号已存在');
							b.addClass('error');
							flag = false;
						}else{
							b.html("").removeClass("error");
							flag = true;
						}
					});
				}
			break;
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
			case"fee":
				var uPattern = /^[0-9]+(.[0-9]{1,2})?$/;
				if(!uPattern.test(v)){
					b.html('请输入正确的价格');
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
			case"car":
				if(v == -1){
					b.html('请选择任职');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
			case"dep":
				if(v == -1){
					b.html('请选择部门');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
			case"reg":
				if(v == -1){
					b.html('请选择挂号类型');
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
	
	
	function selectCar(){
		var osel=document.getElementById("car"); //得到select的ID
		var opts=osel.getElementsByTagName("option");//得到数组option
		opts["${doctor.career.cid}"].selected=true;//设置option默认选中的分类
	}
	function selectDep(){
		var osel=document.getElementById("dep"); //得到select的ID
		var opts=osel.getElementsByTagName("option");//得到数组option
		opts["${doctor.department.id}"].selected=true;//设置option默认选中的分类
	}
	function selectReg(){
		var osel=document.getElementById("reg"); //得到select的ID
		var opts=osel.getElementsByTagName("option");//得到数组option
		opts["${doctor.redister+1}"].selected=true;//设置option默认选中的分类
	}
	window.onload = function(){
		selectCar();
		selectDep();
		selectReg();
	}
	
</script>

</html>