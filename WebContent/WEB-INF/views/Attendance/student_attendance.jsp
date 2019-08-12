<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section class="banner-area relative" id="home" style="margin-top:0px;">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row" style="padding-top: 100px;">
					
			<!-- <div class="banner-content col-md-12">
				<a href="#" class="primary-btn text-uppercase w3-animate-zoom">Lecture Plan</a>
				<a href="#" class="primary-btn text-uppercase w3-animate-zoom" >Class Activity</a>
				<a href="#" class="primary-btn text-uppercase w3-animate-zoom" >Book Ordering</a>
				<a href="#" class="primary-btn text-uppercase w3-animate-zoom" >RollCall REsult</a>
			</div> -->
			
		</div>
	<div class="row">
		<div class="col-md-12">
		<h2>Attendance List</h2>
		</div>
	 
		<div class="col-md-6">
		
			
			 <div class="card  bg-info text-white">
		    <div class="card-header">Attendance for ${month}</div>
		    <div class="card-body">
		 
			     <div class="table-responsive">
          <table class="table table-hover">
			          <thead>
			            <tr>
			         
			              <th>Subject Name</th>
			              <th>Attendance</th>
			              
			            </tr>
			          </thead>
			          <tbody>
			           <!--   for using loop -->
			            <c:forEach items="${subAttList}" var="item" >
			           <tr>
			         
			          <td>
			          ${item.subjectName}
			          </td>
			          <td>${item.attCount} </td>
			           </tr>
			          </c:forEach>
			         
			         
			         
			          </tbody>
			          <tfoot>
			           
			          </tfoot>
			        </table>
			        </div>
			
		    </div> 
		  
		  </div>
			 
		</div>
         <div class="col-md-6">
      
         <div class="card  bg-info text-white">
		    <div class="card-header"> Month Attendance</div>
		    <div class="card-body">
		  
              <div class="table-responsive">
          <table class="table table-hover">
			          <thead>
			            <tr>
			         
			              <th>Month</th>
			              <th>Attendance</th>
			              
			            </tr>
			          </thead>
			          <tbody>
			           <!--   for using loop -->
			            <c:forEach items="${montAttList}" var="item" >
			           <tr>
			         
			          <td>
			          ${item.month}
			          </td>
			          <td>${item.attCount} </td>
			           </tr>
			          </c:forEach>
			         
			         
			         
			          </tbody>
			          <tfoot>
			           
			          </tfoot>
			        </table>
			        </div>
			      
		    </div> 
		   
		  </div>
          
         </div>
			
     

	</div>
	</div>
</section>
</body>
</html>