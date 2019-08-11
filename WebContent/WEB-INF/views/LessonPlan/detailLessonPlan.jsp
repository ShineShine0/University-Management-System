<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

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
  .border {
    display: inline-block;
    width: 500px;
    height: 300px;
    margin: 10px;
  }
 
</style>


<!-- start banner Area -->
<section class="banner-area relative" id="home" style="margin-top:0px;">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row" style="padding-top: 100px;">
					
	
  <%-- <div class="col-xl-4 col-md-4 mb-3">
    <img src="${document.imagePath}" class="img-fluid z-depth-1"
      alt="Responsive image">

  </div> --%>
  <%-- <div class="col-xl-4 col-md-4 mb-3">
  	 <i class="" style="font-size:16px">Title:${document.name}</i>
  	  <br/><br/>
  	  <i class="" style="font-size:16px">Date:${document.date}</i>
  	  <br/><br/>
  	  <p>
  	  ${document.title}
  	  </p>
  	  
  </div> --%>
  
  <!-- Card -->
<div class="card card-cascade wider reverse">
  <!-- Card content -->
  <div class="card-body card-body-cascade text-center">
<img src="${document.imagePath}" class="img-fluid z-depth-1"
      alt="Responsive image">
    <!-- Title -->
    <h4 class="card-title"><strong>Title: ${document.name}</strong></h4>
    <!-- Subtitle -->
    <h6 class="font-weight-bold indigo-text py-2">Date: ${document.date}</h6>
    <!-- Text -->
    <p class="card-text">
    ${document.title}
    </p>
 <a target="_blank" href="${document.dataPath}"
	  download="" class="btn btn-primary">File Download</a>
 
  </div>

</div>
<!-- Card -->
	</div>
	</div>
	
</section>
