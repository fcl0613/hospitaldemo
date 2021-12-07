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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-step">&gt;</span><span>调班申请</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
            	<div class="crumb-wrap">
            		<div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>调班为下礼拜</span></div>
        		</div>
                <form action="dorequest" method="post" id="myform" name="myform" onsubmit="return checkForm(this)">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red"></i>当前排班:</th>
                                <td>
                                  	<p>每个星期${workview.week }的${workview.time }</p>                             	
                                </td>
                            </tr>
                            <tr>
                            	<th width="120"><i class="require-red"></i>选择调班:</th>
                            	<td>
                                	<select name="week" id="type" class="required" onblur="checkItem(this)">
                                    	<option value="-1">请选择</option>
                                    	<option value="1">星期一</option>
                                    	<option value="2">星期二</option>
                                    	<option value="3">星期三</option>
                                    	<option value="4">星期四</option>
                                    	<option value="5">星期五</option>
                                    	<option value="6">星期六</option>
                                    	<option value="7">星期日</option>
                                    	<option value="8">周一到周五</option>
                                	</select>
                                	<span class="error" id="err"></span>
                            	</td>
                        	</tr>
                            <tr>
                            	<th width="120"><i class="require-red"></i>时间:</th>
                            	<td>
                                	<select name="time" id="type" class="required" onblur="checkItem(this)">
                                    	<option value="-1">请选择</option>
                                    	<option value="1">上午</option>
                                    	<option value="2">下午</option>
                                    	<option value="3">全天</option>
                                	</select>
                                	<span class="error" id="err"></span>
                            	</td>
                        	</tr>
                        	<tr>
                                <th><i class="require-red"></i>原因:</th>
                                <td>
                                    <input class="common-text required" id="title" name="reason" size="50" value="" type="text">                              	
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
			case"week":
				if(v == "-1"){
					b.html('请选择分类');
					b.addClass('error');
					flag = false;
				}else{
					b.html("").removeClass("error");
					flag = true;
				}
				break;
				break;
			case"time":
				if(v == "-1"){
					b.html('请选择分类');
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