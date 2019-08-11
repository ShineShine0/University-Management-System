<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
 #myBtn {
  display: none;
  position: fixed;
  bottom: 20px;
  right: 30px;
  z-index: 99;
  font-size: 15px;
  border: none;
  outline: none;
  
  color: white;
  cursor: pointer;
  padding: 15px;
  border-radius: 30px; 
}
</style>>
</head>
<body>
<header id="header" id="home">
	<div class="header-top">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-sm-6 col-8 header-top-left no-padding">
					<ul>
						<!-- <li><a href=""><i class="fa fa-facebook"></i></a></li>
						<li><a href=""><i class="fa fa-twitter"></i></a></li>
						<li><a href=""><i class="fa fa-dribbble"></i></a></li>
						<li><a href=""><i class="fa fa-behance"></i></a></li> -->
					</ul>
				</div>
				<div class="col-lg-6 col-sm-6 col-4 header-top-right no-padding">
					<a href="tel:+955976840177"><span class="lnr lnr-phone-handset"></span>
						<span class="text">user Phone</span></a>
						
						<span class="text" style="color:white;">${userName}</span>
						<span></span><img class="img-profile rounded-circle" src="<c:url value='/resources/userimages/${user.photo}'/>"></span>
				</div>
			</div>
		</div>
	</div>



	<div class="container main-menu">
		<div class="row align-items-center justify-content-between d-flex">
			<div id="logo">
			<i class="fa fa-school" style="font-size:30px;color:black"></i>
			<i class="fa fa-university" aria-hidden="true"  style="font-size:35px;color:black">
			AssistantTeacher
			</i>
				<%-- <a href=""><img
					src="<c:url value='/resources/assets/img/.pn' />" /></a> --%>
			</div>
			<nav id="nav-menu-container">
				<ul class="nav-menu">
					<li><a href="">Home</a></li>
					<sec:authorize access="hasAnyRole('ROLE_Admin,ROLE_Teacher')" >
						<li class="menu-has-children"><a href=>Admin</a>
						<ul>
							<li><a href="<c:url value='/admin_welcome.htm'/>" target="_blank">Management Field</a></li>
							
						</ul>
						</li>
					</sec:authorize> 

<li><a href="<c:url value='/logout.htm'/>">Logout</a></li>

				</ul>
			</nav>
			<!-- #nav-menu-container -->
		</div>
	</div>
</header>
</body></html>