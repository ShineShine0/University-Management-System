<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="sidebar">
 <ul>
    <li class="bg_lb"  ><a href="#" style="font-size:large;" >
    <b><i class="icon icon-home" style="color: white"  ></i>
     <span style="color: white" style=font-weight: bold;>STUDENT PART</span></b>
    	<span class="label label-important">5</span></a>
     </li>

    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>FIRST YEAR</span> 
    	<span class="label label-important"></span></a>
    	 <ul>
        <li id="fca"><a href="studenthome.htm">CLASSROOM A</a></li>
        <li id="fcb"><a href="studenthome.htm">CLASSROOM B</a></li>
        <li id="fcd"><a href="studenthome.htm">CLASSROOM C</a></li>
        <li id="fce"><a href="studenthome.htm">CLASSROOM D</a></li>
      </ul>
  </li>
   <li class='submenu'>
  		 <a href='#'><i class="icon icon-th-list"></i>
   			<span>SECOND YEAR</span></a>
    	 <ul>
	    	 <li class='sub_menu' style="background-color: #133256 !important;"><a href="#"><span>SECOND YEAR CS</span></a>
	    	 	<ul style="display:none;">
	    	 		<span class="label label-important"></span></a>
	    	 		<li><a href="secondyear.htm"><span>CLASSROOM A</span></a></li>
	               <li><a href="secondyear.htm"><span>CLASSROOM B</span></a></li>
	               <li><a href="secondyear.htm"><span>CLASSROOM C</span></a></li>
	               <li><a href="secondyear.htm"><span>CLASSROOM D</span></a></li>
	    	 	</ul>
	    	 </li>
	    	 <li class='sub_menu' style="background-color: #133256;"><a href="#"><span>SECOND YEAR CT</span></a>
	    	 	<ul style="display:none;">
	    	 		<li><a href="secondyearct.htm"><span>CLASSROOM </span></a></li>
	             
	    	 	</ul>
	    	 </li>
	    </ul>
	</li>
    	
  <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>THIRD YEAR</span> 
    	 	 	</a>
    	 	 	 <ul>
    	 	 	<li class='sub_menu' style="background-color: #133256  !important;"><a href="#"><span>THIRD YEAR CS</span></a>
	    	 	<ul style="display:none;">
	    	 		<span class="label label-important"></span></a>
	    	 		<li><a href="thirdyear.htm"><span>CLASSROOM A</span></a></li>
	    	 		<li><a href="thirdyear.htm">CLASSROOM B</a></li>
                    <li><a href="thirdyear.htm">CLASSROOM C</a></li>
                      <li><a href="thirdyear.htm">CLASSROOM D</a></li>
	             </ul>
	    	 </li>
	    	  <li class='sub_menu' style="background-color: #133256;"><a href="#"><span>THIRD YEAR CT</span></a>
	    	 	<ul style="display:none;">
	    	 		<li><a href="thirdyearct.htm"><span>CLASSROOM </span></a></li>
	         
	    	 	</ul>
	    	 </li>
   
      </ul>
      </li>
    	 	 	 <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>FOURTH YEAR</span> 
    	 	 	 	<span class="label label-important"></span></a>
    	 	 	 	 <ul>
    	 	 	 	 <li class='sub_menu' style="background-color: #133256  !important;"><a href="#"><span>FOURTH YEAR CS</span></a>
	    	 	<ul style="display:none;">
					          <li><a href="fourthyear.htm">CLASSROOM A</a></li>
					        <li><a href="fourthyear.htm">CLASSROOM B</a></li>
					        <li><a href="fourthyear.htm">CLASSROOM C</a></li>
					        <li><a href="fourthyear.htm">CLASSROOM D</a></li>
      </ul>
    	</li> 	 	 	 
    	<li class='sub_menu' style="background-color: #133256;"><a href="#"><span>THIRD YEAR CT</span></a>
	    	 	<ul style="display:none;">
	    	 		<li><a href="fourthyearct.htm"><span>CLASSROOM </span></a></li>
	         
	    	 	</ul>
	    	 </li>
    	 </ul>
      </li>
    	
    	
    	
    	<li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>FIFTH YEAR</span> 
     <span class="label label-important"></span></a>
      <ul>
      	 <li class='sub_menu' style="background-color: #133256  !important;"><a href="#"><span>FIFTH YEAR CS</span></a>
	    	 	<ul style="display:none;">
       <li><a href="fifthyear.htm">CLASSROOM A</a></li>
        <li><a href="fifthyear.htm">CLASSROOM B</a></li>
        <li><a href="fifthyear.htm">CLASSROOM C</a></li>
        <li><a href="fifthyear.htm">CLASSROOM D</a></li>
      </ul>
    </li>
    <li class='sub_menu' style="background-color: #133256;"><a href="#"><span>FIFTH YEAR CT</span></a>
	    	 	<ul style="display:none;">
	    	 		<li><a href="fifthyearct.htm"><span>CLASSROOM </span></a></li>
	         
	    	 	</ul>
	    	 </li>
    	 </ul>
      </li>
      <li class="bg_lb"  >
      <a href="#"style="font-size:large; " >
      	<b><i class="icon icon-home" style="color: white"  ></i> 
      	<span style="color: white" style="font-weight: bold;"  >TEACHER PART</span>
      	</b>
    	<span class="label label-important">5</span></a>
    </li>
    

    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>FIRST YEAR</span> 
    	<span class="label label-important"></span></a>
    	 <ul>
      <li><a href="first.htm">CLASSROOM A</a></li>
        <li><a href="first.htm">CLASSROOM B</a></li>
        <li><a href="first.htm">CLASSROOM C</a></li>
        <li><a href="first.htm">CLASSROOM D</a></li>
      </ul></li>
    	 <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>SECOND YEAR</span> 
    	 	<span class="label label-important"></span></a>
    	 	 <ul>
    	 	 	 <li class='sub_menu' style="background-color: #133256  !important;"><a href="#"><span>SECOND YEAR CS</span></a>
	    	 	<ul style="display:none;">
      <li><a href="second.htm">CLASSROOM A</a></li>
        <li><a href="second.htm">CLASSROOM B</a></li>
        <li><a href="second.htm">CLASSROOM C</a></li>
        <li><a href="second.htm">CLASSROOM D</a></li>
      </ul></li>
       <li class='sub_menu' style="background-color: #133256;"><a href="#"><span>SECOND YEAR CT</span></a>
	    	 	<ul style="display:none;">
	    	 		<li><a href="secondct.htm"><span>CLASSROOM </span></a></li>
	         
	    	 	</ul>
	    	 </li>
    	 </ul>
      </li>
      
    	 	 <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>THIRD YEAR</span> 
    	 	 	<span class="label label-important"></span></a>
    	 	 	 <ul>
    	 	 	  	 <li class='sub_menu' style="background-color: #133256  !important;"><a href="#"><span>THIRD YEAR CS</span></a>
	    	 	<ul style="display:none;">
        <li><a href="third.htm">CLASSROOM A</a></li>
        <li><a href="third.htm">CLASSROOM B</a></li>
        <li><a href="third.htm">CLASSROOM C</a></li>
        <li><a href="third.htm">CLASSROOM D</a></li>
      </ul></li>
        <li class='sub_menu' style="background-color: #133256;"><a href="#"><span>THIRD YEAR CT</span></a>
	    	 	<ul style="display:none;">
	    	 		<li><a href="thirdct.htm"><span>CLASSROOM </span></a></li>
	         
	    	 	</ul>
	    	 </li>
    	 </ul>
      </li>
      
      
    	 	 	 <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>FOURTH YEAR</span> 
    	 	 	 	<span class="label label-important"></span></a>
    	 	 	 	 <ul>
    	 	 	 	  	 <li class='sub_menu' style="background-color: #133256  !important;"><a href="#"><span>FOURTH YEAR CS</span></a>
	    	 	<ul style="display:none;">
        <li><a href="fourth.htm">CLASSROOM A</a></li>
        <li><a href="fourth.htm">CLASSROOM B</a></li>
        <li><a href="fourth.htm">CLASSROOM C</a></li>
        <li><a href="fourth.htm">CLASSROOM D</a></li>
      </ul></li>
      
       <li class='sub_menu' style="background-color: #133256;"><a href="#"><span>FOURTH YEAR CT</span></a>
	    	 	<ul style="display:none;">
	    	 		<li><a href="fourthct.htm"><span>CLASSROOM </span></a></li>
	         
	    	 	</ul>
	    	 </li>
    	 </ul>
      </li>
      
    	 	 	 	 <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>FIFTH YEAR</span> 
     <span class="label label-important"></span></a>
      <ul>
       <li class='sub_menu' style="background-color: #133256  !important;"><a href="#"><span>FIFTH YEAR CS</span></a>
	    	 	<ul style="display:none;">
        <li><a href="fifth.htm">CLASSROOM A</a></li>
        <li><a href="fifth.htm">CLASSROOM B</a></li>
        <li><a href="fifth.htm">CLASSROOM C</a></li>
        <li><a href="fifth.htm">CLASSROOM D</a></li>
      </ul>
    </li>
     <li class='sub_menu' style="background-color: #133256;"><a href="#"><span>FIFTH YEAR CT</span></a>
	    	 	<ul style="display:none;">
	    	 		<li><a href="fifthct.htm"><span>CLASSROOM </span></a></li>
	         
	    	 	</ul>
	    	 </li>
    	 </ul>
      </li>
    <li class="bg_lb"  ><a href="#"style="font-size:large; " ><b><i class="icon icon-home" style="color: white"  ></i> <span style="color: white" " style=font-weight: bold;  >BUYING BOOKS</span></b>
    	<span class="label label-important"></span></a>
    </li>

    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>FIRST YEAR BOOKS</span> 
    	<span class="label label-important"></span></a>
    	 <ul>
        <li><a href="firstcsbook.htm"><i class="icon-shopping-cart"></i>COMPUTER SCIENCE BOOKS</a></li>
       
      </ul></li>
    	 <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>SECOND YEAR BOOKS</span> 
    	 	<span class="label label-important"></span></a>
    	 	 <ul>
       <li><a href="secondcsbook.htm"><i class="icon-shopping-cart"></i>COMPUTER SCIENCE BOOKS</a></li>
        <li><a href="secondctbook.htm"><i class="icon-shopping-cart"></i>COMPUTER TECHNOLOGY BOOKS</a></li>
      </ul></li>
    	 	 <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>THIRD YEAR BOOKS</span> 
    	 	 	<span class="label label-important"></span></a>
    	 	 	 <ul>
       <li><a href="thirdcsbook.htm"><i class="icon-shopping-cart"></i>COMPUTER SCIENCE BOOKS</a></li>
        <li><a href="thirdctbook.htm"><i class="icon-shopping-cart"></i>COMPUTER TECHNOLOGY BOOKS</a></li>
      </ul></li>
    	 	 	 <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>FOURTH YEAR BOOKS</span> 
    	 	 	 	<span class="label label-important"></span></a>
    	 	 	 	 <ul>
        <li><a href="fourthcsbook.htm"><i class="icon-shopping-cart"></i>COMPUTER SCIENCE BOOKS</a></li>
        <li><a href="fourthctbook.htm"><i class="icon-shopping-cart"></i>COMPUTER TECHNOLOGY BOOKS</a></li>
      </ul></li>
    	 	 	 	 <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>FIFTH YEAR BOOKS</span> 
     <span class="label label-important"></span></a>
      <ul>
        <li><a href="fifthcsbook.htm"><i class="icon-shopping-cart"></i>COMPUTER SCIENCE BOOKS</a></li>
        <li><a href="fifthctbook.htm"><i class="icon-shopping-cart"></i>COMPUTER TECHNOLOGY BOOKS</a></li>
      </ul>
    </li>

<sec:authorize access="hasRole('ROLE_Admin')" >
<li class="bg_lb"  ><a href="#"style="font-size:large; " ><b><i class="icon icon-home" style="color: white"  ></i> <span style="color: white" " style=font-weight: bold;  >ADMIN PART</span></b>
    	<span class="label label-important"></span></a>
    </li>
    	<li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>MANAGEMENT PARTS</span> 
    	<span class="label label-important">3</span></a>
    	 <ul>
        <li><a href="studentmanagement.htm"><i class="icon-user"></i>STUDENTS MANAGEMENT</a></li>
        <li><a href="teachermanagement.htm"><i class="icon-user"></i>TEACHERS MANAGEMENT</a></li>
        <li><a href="bookmanagement.htm"><i class="icon-user"></i>BOOKS MANAGEMENT</a></li>
      </ul>
   </li>
   </ul>
   </sec:authorize>
</div>

</body>
</html>
