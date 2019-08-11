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
      <div class="col-md-4">
         <div class="card text-white bg-primary flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
               <h6 class="mb-0">
                  <a class="text-white" href="#">Lecture Plan</a>
               </h6>
               <div class="mb-1 text-white-50 small">Nov 12</div>
               <a class="btn btn-outline-light btn-sm" role="button" href="<c:url value='/teacher/viewLessonPlan.htm'/>">Continue reading</a>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" alt="Thumbnail [200x250]" src="<c:url value='/resources/Images/settingPhoto/ww.jpg'/>" style="width: 200px; height: 150px;">
         </div>
      </div>
      <div class="col-md-4">
         <div class="card text-white bg-success flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
               <h6 class="mb-0">
                  <a class="text-white" href="#">Class Activities</a>
               </h6>
               <div class="mb-1 text-white-50 small">Nov 11</div>
               <a class="btn btn-outline-light btn-sm" href="<c:url value='/teacher/activityList.htm'/>">Continue reading</a>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" alt="Thumbnail [200x250]" src="<c:url value='/resources/Images/settingPhoto/aa.jpg' />" style="width: 200px; height: 150px;">
         </div>
      </div>
       <div class="col-md-4">
         <div class="card text-white bg-primary flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
               <h6 class="mb-0">
                  <a class="text-white" href="#">Attendance Records</a>
               </h6>
               <div class="mb-1 text-white-50 small">Nov 12</div>
               <a class="btn btn-outline-light btn-sm" role="button" href="<c:url value='/admin/attendanceList.htm'/>">Continue reading</a>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" alt="Thumbnail [200x250]" src="<c:url value='/resources/Images/settingPhoto/att.jpg' />" style="width: 200px; height: 150px;">
         </div>
      </div>
      <div class="col-md-4">
         <div class="card text-white bg-primary flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
               <h6 class="mb-0">
                  Time Tables
               </h6>
               <div class="mb-1 text-white-50 small">Nov 12</div>
               <a class="btn btn-outline-light btn-sm" role="button" href="<c:url value='/timetable/showTimetable.htm'/>">-->>></a>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" alt="Thumbnail [200x250]" src="<c:url value='/resources/Images/settingPhoto/hh.jpg' />" style="width: 200px; height: 150px;">
         </div>
      </div>
      <div class="col-md-4">
         <div class="card text-white bg-success flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
               <h6 class="mb-0">
              Learn Websites
               </h6>
               <div class="mb-1 text-white-50 small">Nov 11</div>
               <a class="btn btn-outline-light btn-sm" href="<c:url value='/timetable/showWebsite.htm'/>">Continue reading</a>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" alt="Thumbnail [200x250]" src="<c:url value='/resources/Images/settingPhoto/pp.jpg' />" style="width: 200px; height: 150px;">
         </div>
      </div>
       <div class="col-md-4">
         <div class="card text-white bg-primary flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
               <h6 class="mb-0">
                  <a class="text-white" href="#">Book Ordering</a>
               </h6>
               <div class="mb-1 text-white-50 small">Nov 12</div>
               <div class="btn btn-outline-light btn-sm" role="button" ><a href='<c:url value="/book/bookOrder.htm"/>'>Continue reading</a>
            </div>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" alt="Thumbnail [200x250]" src="<c:url value='/resources/Images/settingPhoto/bb.jpg' />" style="width: 200px; height: 150px;">
         </div>
      </div>
   </div>
	</div>
	
</section>




<!-- start for signup -->

<div class="modal fade" id="modalRegisterForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center" style="background-color: #00BCD4;">
                <h4 class="modal-title w-100 font-weight-bold">Sign up</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body mx-3">
                <div class="md-form mb-5">
                    <i class="fa fa-user prefix grey-text"></i>
                    <input type="text" id="orangeForm-name" class="form-control validate">
                    <label data-error="wrong" data-success="right" for="orangeForm-name">Your name</label>
                </div>
                <div class="md-form mb-5">
                    <i class="fa fa-envelope prefix grey-text"></i>
                    <input type="email" id="orangeForm-email" class="form-control validate">
                    <label data-error="wrong" data-success="right" for="orangeForm-email">Your email</label>
                </div>

                <div class="md-form mb-4">
                    <i class="fa fa-lock prefix grey-text"></i>
                    <input type="password" id="orangeForm-pass" class="form-control validate">
                    <label data-error="wrong" data-success="right" for="orangeForm-pass">Your password</label>
                </div>

            </div>
            <div class="modal-footer d-flex justify-content-center" style="background-color: #00bcd433;">
                <button class="btn" style="background-color: #2196F3;">Sign up</button>
            </div>
        </div>
    </div>
</div>


