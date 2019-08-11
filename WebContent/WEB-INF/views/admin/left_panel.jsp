<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Left Panel -->

	<aside id="left-panel" class="left-panel"> 
	<nav class="navbar navbar-expand-sm navbar-default">

	<div class="navbar-header">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#main-menu" aria-controls="main-menu"
			aria-expanded="false" aria-label="Toggle navigation">
			<i class="fa fa-bars"></i>
		</button>
		<a class="navbar-brand" href="">Teaching Helper System</a> 
		
	</div>

	<div id="main-menu" class="main-menu collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="<c:url value='/admin_welcome.htm'/>"> <i
					class="menu-icon ti-home"></i>Home
			</a>
			</li>
			
			
                
    	<h3 class="menu-title">Teacher Part </h3>
			<li class="menu-item-has-children dropdown"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="true"> <i class="menu-icon fa fa-id-card"></i> Teacher Role
			</a>
				<ul class="sub-menu children dropdown-menu"style="background-color:#9c27b0;">
					<li class="active"><i ></i><a href="<c:url value='/teacher/addLessonPlan.htm'/>">Lesson Plans</a></li>
					<li><i class=""></i><a href="<c:url value='/teacher/checkLessonPlan.htm'/>">Check Lesson Plans List</a></li>
					<li><i class=""></i><a href="<c:url value='/teacher/addActivity.htm'/>"> Activities Events</a></li>
					<li><i class=""></i><a href="<c:url value='/teacher/checkActivity.htm'/>">Check Activity Plans List</a></li>
					<li><i class=""></i><a href="<c:url value='/admin/attendance.htm'/>"> Attendance Records</a></li>
					<li><i class=""></i><a href="<c:url value='/admin/attendanceListByDate.htm'/>"> Attendance By Date</a></li>
					<li><i class=""></i><a href="<c:url value='/admin/attendanceListBySubject.htm'/>"> Attendance By Subject</a></li>				
					<li><i class=""></i><a href="<c:url value='/admin/attendanceListByMonth.htm'/>"> Attendance By Month</a></li>
					<li><i class=""></i><a href="<c:url value='/admin/attendanceListBySemester.htm'/>"> Attendance By Semester</a></li>
					
				
				
				</ul></li>
				
				
		
    	<h3 class="menu-title">Management Part</h3>
			<li class="menu-item-has-children dropdown"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="menu-icon fa fa-id-card"></i>Management 
			</a>
				<ul class="sub-menu children dropdown-menu"style="background-color:#9c27b0;">
					<li id="active"><i class=""></i><a href="<c:url value='/Student/studentmanagement.htm'/>">Student Management</a></li>
					<li><i class=""></i><a href="<c:url value='/admin/addmember.htm'/>">Add Members</a></li>
					<li><i class=""></i><a href="<c:url value='/book/bookManagement.htm'/>">Book Management</a></li>
                    <li><i class=""></i><a href="<c:url value='/admin/class.htm'/>">Year Management</a></li>
                     <li><i class=""></i><a href="<c:url value='/book/student_book_orderList.htm'/>">Book Order List</a></li>
					
                   

					
				</ul></li>
				 
				
				<h3 class="menu-title">User profile</h3>		
					<li><a href="<c:url value='/logout.htm'/>"><i class="menu-icon fa fa-power-off"></i>Logout</a></li>
		</ul>
	</div>
	<div class="row" style="border: 0.6px dotted #009688;">
	
	</div>
	<!-- /.navbar-collapse --> </nav> 
	
	</aside>
	<!-- /#left-panel -->

</body>
<!-- <script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
</html>