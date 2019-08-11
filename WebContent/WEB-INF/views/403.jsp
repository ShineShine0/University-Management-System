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

/* (for Add to cart) */

i,
span,
p,
h2 {
  font-family: "Lato", sans-serif;
}
section {
  max-width: 1180px;
  margin: 0 auto;
}
h1 {
  font-family: "Lato", sans-serif;
  font-weight: 100;
  text-align: center;
  letter-spacing: 0.5rem;
  text-transform: uppercase;
  margin: 4rem 0 0 0;
}
.list {
  background: #fff;
  display: flex;
  flex-wrap: wrap;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  
}
.list > div {
  width: 200px;
  float: left;
  height: 300px;
  background: #fff;
  margin: 1%;
  position: relative;
}
.product > div {
  text-align: center;
  position: absolute;
  -webkit-transition: all 0.5s;
  -o-transition: all 0.5s;
  transition: all 0.5s;
  bottom: 0;
  height: 0;
  overflow: hidden;
  width: 100%;
  margin: 0 auto;
}
.product:hover > div {
  position: absolute;
  height: 300px;
  background: rgba(255, 255, 255, 0.5);
}
.product > img {
  margin: 0 auto;
  display: block;
  -webkit-transition: all 0.5s;
  -o-transition: all 0.5s;
  transition: all 0.5s;
}
.product:hover > img {
  -webkit-filter: blur(3px);
  filter: blur(3px);
}
.product > div > h2 {
  border-bottom: 1px solid #818181;
  padding: 0 0 1rem;
}
.descr {
  font-size: 0.8rem;
  padding: 2rem;
  line-height: 1.2rem;
}
.product > div > a > p {
  text-transform: uppercase;
  letter-spacing: 2px;
  font-size: 1rem;
  line-height: 2rem;
  background: #000;
  color: #fff;
  position: absolute;
  width: 100%;
  bottom: 0;
  margin: 0 auto !important;
  -webkit-transition: all 0.2s;
  -o-transition: all 0.2s;
  transition: all 0.2s;
}
.product > div > a > p:hover {
  background: linear-gradient(
    to right,
    #ff6a00,
    #ee0979
  );
  bottom: 5px;
  letter-spacing: 4px;
}
 /* for add to card */
 
 table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
  background-color:white;
}

 th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: gray;
}


</style>
<link href="<c:url value='/resources/assets/css/w3.css'/>"
	rel="stylesheet">
	
	
	
<!-- start banner Area -->
<section class="banner-area relative" id="home" style="margin-top:0px;">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row" style="padding-top: 100px;">
		<div class="col-sm-8" style="padding-right:20px">
		<div class="row"  style="min-height:300px">
		<h1> You Cannot Access This Function</h1>
		</div>
		</div>
		</div>
		</div>
		</section>
		