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
 <div class="col-md-6">
                  <h4 class="card-title">Some website what should be learnt</h4>
                  <div class="alert alert-info">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <i class="material-icons">close</i>
                    </button>
                    <span>
                      <h3><b> W3schools  </b></h3>
                      <p>W3Schools is an educational website for learning web technologies online. Content includes tutorials and references relating to HTML, CSS, JavaScript, JSON, PHP, Python, AngularJS, SQL, Bootstrap, Node.js, jQuery, XQuery, AJAX, XML, and Java.for more website</p>
                      for more visit>>><a class="btn btn-outline-dark btn-sm" role="button" href="https://www.w3schools.com/">www.w3schools.com</a>
                   </span>
                  </div>
                  <div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <i class="material-icons">close</i>
                    </button>
                    <span>
                      <h3><b>JavaTpoint</b></h3>
                      <p>JavaTpoint offers Online Training and Winter Training on Java, Blockchain, Machine Learning, Meanstack, Artifical Intelligence, Kotlin, Cloud Computing, Angular, React, IOT, DevOps, RPA, Virtual Realty, Embedded Systems, Robotics, PHP, .Net, Big Data and Hadoop, Spark, Data Analytics, R Programming, SAP, Android, Python, Oracle, Web Designing, Spring, Hibernate, Software Testing, Seleninum, Linux, C++ and many more technologies.</p>
                       For more visit>>><a class="btn btn-outline-dark btn-sm" role="button" href="https://www.javatpoint.com/">www.javatpoint.com</a>
                      </span>
                  </div>
                  <div class="alert alert-warning">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <i class="material-icons">close</i>
                    </button>
                    <span>
                     <h3><b>Java2Blog</b></h3>
                      <p>A blog on core java,data structures,algorithms and also on various frameworks like struts 2,spring,spring MVC,webservices, java design patterns.</p>
                       For more visit>>><a class="btn btn-outline-dark btn-sm" role="button" href="https://www.javat2blog.com/">www.javat2blog.com</a>
                      
                  </div>
                  <div class="alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <i class="material-icons">close</i>
                    </button>
                    <span>
                      <h3><b>TutorialsPoint</b></h3>
                      <p>Org.Json, AWS QuickSight, JSON.Simple, Jackson Annotations, Passay, Boon, MuleSoft, Nagios, Matplotlib, Java NIO, PyTorch, SLF4J, Parallax Scrolling, Java </p>
                       For more visit>>><a class="btn btn-outline-dark btn-sm" role="button" href="https://www.tutorialspoint.com/">www.tutorialspoint.com</a>
                      
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


<script src="<c:url value='/resources/assets/formJS/test.js'/>"></script>