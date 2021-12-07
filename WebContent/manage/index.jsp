<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<%@ include file="bar.jsp"  %>
<div class="container clearfix">
    <%@ include file="menu.jsp"  %>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用管理系统</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href=""><i class="icon-font">&#xe006;</i>新增</a>
                    <a href=""><i class="icon-font">&#xe014;</i>新增</a>
                    <a href=""><i class="icon-font">&#xe048;</i>新增</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">操作系统</label><span class="res-info">win10</span>
                    </li>
                    <li>
                        <label class="res-lab">运行环境</label><span class="res-info">*******</span>
                    </li>
                    <li>
                        <label class="res-lab">版本</label><span class="res-info">v-0.1</span>
                    </li>
                    <li>
                        <label class="res-lab">上传附件限制</label><span class="res-info">2M</span>
                    </li>
                    <li>
                        <label class="res-lab">北京时间</label><span class="res-info" id="time">2019年3月18日 21:08:24</span>
                    </li>
                    <li>
                        <label class="res-lab">服务器域名/IP</label><span class="res-info">localhost [ 127.0.0.1 ]</span>
                    </li>
                    <li>
                        <label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">更多：</label><span class="res-info"><a href="" target="_blank">使用手册</a></span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>

<script type="text/javascript">
    var add=setInterval("getTime()",1000);
    //stop()这个函数主要是清除设置的定时器
    function stop() {
        clearInterval(add);
    }
    function getTime() {
        var date=new Date().toLocaleString();//创建date对象，获取时间
        var id1=document.getElementById("time");//通过id获取对象
        id1.innerHTML=date;//将时间通过innerHTML属性写入标签中
    }
</script>
</body>
</html>