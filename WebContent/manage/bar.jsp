<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.jsp">首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li>管理员&nbsp;&nbsp;&nbsp;&nbsp;${admin.account }</li>
                <li><a href="changepassword.jsp">修改密码</a></li>
                <li><a href="javascript:Logout('确定要退出系统?', '/hospital/adminlogout')">退出</a></li>
            </ul>
        </div>
        <script type="text/javascript">
    	function Logout(message,url){
			if(confirm(message)){
				location.href=url;
			}
		}
    </script>
    </div>
</div>