<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<link href="<c:url value='/resources/assets/css/aims.css'/>"
	rel="stylesheet">
<style>
.radio-pink [type="radio"]:checked+label:after {
	border-color: #e91e63;
	background-color: #e91e63;
}
/*Gap*/
.radio-pink-gap [type="radio"].with-gap:checked+label:before {
	border-color: #e91e63;
}

.radio-pink-gap [type="radio"]:checked+label:after {
	border-color: #e91e63;
	background-color: #e91e63;
}
.social-card-header{
    position: relative;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-align: center;
    align-items: center;
    -ms-flex-pack: center;
    justify-content: center;
    height: 96px;
}
.social-card-header i {
    font-size: 32px;
    color:#FFF;
}
.bg-facebook {
    background-color:#3b5998;
}
.text-facebook {
    color:#3b5998;
}
.bg-google-plus{
    background-color:#dd4b39;
}
.text-google-plus {
    color:#dd4b39;
}
.bg-twitter {
    background-color:#1da1f2;
}
.text-twitter {
    color:#1da1f2;
}
.bg-pinterest {
    background-color:#bd081c;
}
.text-pinterest {
    color:#bd081c;
}
.share:hover {
        text-decoration: none;
    opacity: 0.8;
}
</style>
<link href="<c:url value='/resources/assets/css/w3.css'/>"
	rel="stylesheet">

<!-- start banner Area -->
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
       <div class=" text-white bg-primary flex-md-row mb-4 shadow-sm h-md-250">
         <div class="col-lg-12">
			      <div class="table-responsive">
			        <table class="table table-hover">
			          <thead>
			            <tr>
			              <th>#</th>
			              <th>Date</th>
			              <th>Description</th>
			           			            </tr>
			          </thead>
			          <tbody>
			           <!--   for using loop -->
			           <c:forEach items="${activityList}" var="item" varStatus="row">
							<tr>
								<td>${row.count}</td>
								<td class="hidden-480">${item.date}</td>
								<td class="hidden-480">${item.description}</td>
								</tr>
								</c:forEach>
			            <!--  for using loop -->
			            
			          </tbody>
			          <tfoot>
			           
			          </tfoot>
			        </table>
			      </div><!--end of .table-responsive-->
			     
			    </div>   
      </div>
	</div>
	</div>
	</div>
</section>