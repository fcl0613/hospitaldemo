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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-step">&gt;</span><span>修改密码</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="dochangepwd" method="post" id="myform" name="myform" onsubmit="return checkForm(this)">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red"></i>新密码:</th>
                                <td>
                                    <input class="common-text required" id="newpwd" name="newpassword" size="50" value="" type="password" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                            <tr>
                                <th>确认新密码:</th>
                                <td><input class="common-text" name="confirmpwd" size="50" value="" type="password" onblur="checkItem(this)">
                                	<span class="error" id="err"></span>
                                </td>
                            </tr>
                           <tr>
                                <th>旧密码:</th>
                                <td><input class="common-text" name="oldpwd" size="50" value="" type="password" onblur="checkItem(this)">
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
			case"newpassword":
				var uPattern = /^[a-zA-Z]\w{5,17}$/;
				if(!uPattern.test(v)){
					b.html('以字母开头，长度在6~18之间，只能包含字母、数字和下划线');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass('error');
					flag = true;
				}
				break;
			case"confirmpwd":
				var uPattern = /^[a-zA-Z]\w{5,17}$/;
				if(!uPattern.test(v)){
					b.html('以字母开头，长度在6~18之间，只能包含字母、数字和下划线');
					b.addClass('error');
					flag = false;
				}else{
					var newpwd = document.getElementById('newpwd').value;
					if(v == newpwd){
						b.html("").removeClass('error');
						flag = true;
					}else{
						b.html('密码输入不一致');
						b.addClass('error');
						flag = false;
					}
				}
				break;
			case"oldpwd":
				var uPattern = ${doctor.password};
				if(v != uPattern){
					b.html('原密码输入错误');
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