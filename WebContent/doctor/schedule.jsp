<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link href='css/main1.css' type="text/css" rel='stylesheet' />
	<script src='js/main.js'></script>
	<style type="text/css">
	 	#calendar {
    		max-width: 1100px;
    		margin: 0 auto;
  		}
	</style>
	<script>
	document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next',
        center: 'title',
        right: 'dayGridMonth'
      },
      initialDate: '${today}',
      navLinks: true, // can click day/week names to navigate views
      businessHours: true, // display business hours
      editable: false,
      selectable: true,
      events: [
        {
          
          start: '${week[0]}',
          end: '${week[1]}',
          title: '${time}',
          overlap: false,
        },
        {
        	start: '${week[2]}',
            end: '${week[3]}',
            title: '${time}',
            overlap: false
        }
      ]
    });

    calendar.render();
  });
</script>
</head>
<body>
<%@include file="bar.jsp" %>
<div class="container clearfix">
	<%@include file="menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">
		<div id='calendar'></div>
    </div>
    <!--/main-->
</div>
</body>
</html>