<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/submenucss/menu.css'/>" />
<style>
#example_wrapper{
width:100%;
}
</style>
<link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/jquery.dataTables.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/buttons.dataTables.min.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/assets/css/dataTable/responsive.dataTables.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/assets/css/dataTable/dataTables.bootstrap.css'/>">
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

</head>
<body>
	<%-- <sec:authorize access="hasRole('ROLE_Admin')" > --%>
	<!-- Right Panel -->
	<div id="right-panel" class="right-panel">
		<!-- Header-->
		<header id="admin-header" class="header">
			<div class="header-menu">
				<div class="col-sm-7">
					<a id="menuToggle" class="menutoggle pull-left"><i
						class="fa fa fa-tasks" style="margin-top: 11px;"></i></a>
					<!-- <div class="header-left">
                        <button class="search-trigger"><i class="fa fa-search"></i></button>
                        <div class="form-inline">
                            <form class="search-form">
                                <input class="form-control mr-sm-2" type="text" placeholder="Search ..." aria-label="Search">
                                <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                            </form>
                        </div>

                        <div class="dropdown for-notification">
                          <button class="btn btn-secondary dropdown-toggle" type="button" id="notification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-bell"></i>
                            <span class="count bg-danger">5</span>
                          </button>
             
                        </div>

                        <div class="dropdown for-message">
                          <button class="btn btn-secondary dropdown-toggle" type="button"
                                id="message"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="ti-email"></i>
                            <span class="count bg-primary">9</span>
                          </button>
                          
                        </div>
                    </div> -->
				</div>

				<!-- <div class="col-sm-5">
                    <div class="user-area dropdown float-right">
                        
                        <div class="fa fa-user">
                        Thar Nge
                        </div>
                   </div>
                </div> -->
			</div>

		</header>
		<!-- /header -->
		<!-- Header-->

		<div class="breadcrumbs">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>Activity Events</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li class="active"></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-lg-12">
			<div class="row"
			
				style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px; margin-top: 5px;">
				<input type="hidden" id="pageContext" value="<c:url value='/'/>" />
				<form:form class="form-horizontal"
					action="${pageContext.request.contextPath}/teacher/addActivity.htm"
					commandName="activityDTO" role="form" method="POST">
					<div class="form-group">

						<div class="col-md-6" style="margin-top: 10px;">Teacher:</div>
						<div class="col-md-6" style="margin-top: 10px;">
							<form:input  path="teacherName" disabled="true" value="${teacherName}"/>
							<form:hidden path="teacherId" value="${teacherId}"/>
							<form:hidden path="teacherId" value="${teacherName}"/>
						</div>

					<%-- 	<div class="col-md-6" style="margin-top: 10px;">from:</div>
						<div class="col-md-6" style="margin-top: 10px;">
							<form:input  path="teacherMail" disabled="true" value="${teacherMail}" />
						</div> --%>
						
						<div class="col-md-6" style="margin-top: 10px;">Date:</div>
						<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="date" placeholder="Date..." required="true"
								class="form-control" type="date" />
						</div>
						<div class="col-md-6" style="margin-top: 10px;">Year:</div>
						<div class="col-md-6" style="margin-top: 10px;">

							<form:select path="classLevelId" id="classLevelId"
								class="form-control">
								<option data-display="">--Choose Year--</option>
								<c:forEach items="${classLevelList}" var="item">
									<form:option value="${item.id}">${item.name}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>

					<div class="col-md-6" style="margin-top: 10px;">Room:</div>
					<div class="col-md-6" style="margin-top: 10px;">

						<form:select path="sectionId" id="sectionId" class="form-control">
							<option data-display="">---Choose Room---</option>
							<c:forEach items="${sectionList}" var="item">
								<form:option value="${item.id}">${item.name}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-md-6" style="margin-top: 10px;">Description:</div>
						<div class="col-md-6" style="margin-top: 10px;">
							<form:textarea path="title" id="editor" cols="20" rows="10" required="true"/>
						</div>
						<div class="col-md-12" style="margin-top: 10px;">
							<div class="container">
							  <div class="row">
							    <div class="col-12">
							      <table class="table table-bordered">
							        <thead>
							          <tr>
							            <th scope="col">Select to send</th>
							            <th scope="col">Student Name</th>
							            <th scope="col">Student Mail</th>
							            <th scope="col">Student Roll</th>
							          </tr>
							        </thead>
							        <tbody id="studentTable">
							        </tbody>
							      </table>
							    </div>
							  </div>
							</div>
				</div>
					<div class="col-md-6"
						style="margin-top: 10px; margin-bottom: 10px;">
						<input type="submit" class="btn btn-success" value="Send"
							style="color: white; background-color: #00bcd487; width: 100px; border-radius: 5px;" />
					</div>
				</form:form>
			</div>
			</div>
			
			
			
			
    </div>
    <script src="https://cdn.ckeditor.com/4.8.0/full-all/ckeditor.js"></script>
<script>
		$(document).ready(function() {		
		    $('#example').DataTable( {
		        dom: 'Bfrtip',
		        buttons: [
		            'copy', 'csv', 'excel', 'pdf', 'print'
		        ]
		    } );
		});
		$(function(){
			 $("#classLevelId").on("change" ,function(){
				var contextUrl = $("#pageContext").val();
				$("#sectionId > *").remove();
				var param =$("#classLevelId").val();
				$("#studentTable >*").remove();
				$.ajax({
					
			          contentType : 'application/json; charset=utf-8',
			          type: "GET",
			          url: contextUrl+"teacher/ajax/get-section-list",
			       
			          dataType : 'json',
			          data : "classLevelId="+param,
			          success : function(data){
			        	  var html = '<option value="">--Select Section--</option>';
			        	  var len = data.length;
			        		  for ( var i = 0; i < len; i++) {
									html += '<option value="' + data[i].id + '">'
					                        + data[i].name
											+ '</option>';
								} 
							$('#sectionId').html(html);
							if (typeof(callback) == "function") {
								callback();
							}      	                       
			          },
			          error: function (){
			        	  var html = '<option value="">--Select Section--</option>';
			        	  $('#sectionId').html(html);
			          },
			          complete: function()
			          {   	  
			          }  
				});
	}); 
			 
			 
			 $("#sectionId").on("change" ,function(){
					var contextUrl = $("#pageContext").val();
					var param1 =$("#classLevelId").val();
					var param2 =$("#sectionId").val();
					$.ajax({
						
				          contentType : 'application/json; charset=utf-8',
				          type: "GET",
				          url: contextUrl+"teacher/ajax/get-student-list",
				          dataType : 'json',
				          data : {classLevelId:param1,
				        	  		sectionId:param2},
				          success : function(data){
				        	  var html = '';
				        	  var body = $("#studentTable");
				        	  for ( var i = 0; i < data.length; i++) {
									html += '<tr><td>'
						                 +'<div class="custom-control custom-checkbox">'
						                 +'<input type="checkbox" name="mailUserList['+i+'].status" />'
						                 +'</div></td>'
						                 +'<td>'+data[i].name
						                 +'<input type="hidden" name="mailUserList['+i+'].name" value="'+data[i].name+'"/></td>'
						                 +'<td>'+data[i].email
						                 +'<input type="hidden" name="mailUserList['+i+'].email" value="'+data[i].email+'"/></td>'
						                 +'<td>'+data[i].rollNo
						                 +'<input type="hidden" name="mailUserList['+i+'].rollNo" value="'+data[i].rollNo+'" /></td>'
						                 +'</tr>';
								}
				        	  body.html(html);
				        	  
								if (typeof(callback) == "function") {
									callback();
								}      	                       
				          },
				          error: function (){
				        	$("#studentTable >*").remove();
				          },
				          complete: function()
				          {   	  
				          }  
					});
		}); 
		});
		
		CKEDITOR.replace('editor', {
			  skin: 'moono',
			  enterMode: CKEDITOR.ENTER_BR,
			  shiftEnterMode:CKEDITOR.ENTER_P,
			  toolbar: [{ name: 'basicstyles', groups: [ 'basicstyles' ], items: [ 'Bold', 'Italic', 'Underline', "-", 'TextColor', 'BGColor' ] },
			             { name: 'styles', items: [ 'Format', 'Font', 'FontSize' ] },
			             { name: 'scripts', items: [ 'Subscript', 'Superscript' ] },
			             { name: 'justify', groups: [ 'blocks', 'align' ], items: [ 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ] },
			             { name: 'paragraph', groups: [ 'list', 'indent' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent'] },
			             { name: 'links', items: [ 'Link', 'Unlink' ] },
			             { name: 'spell', items: [ 'jQuerySpellChecker' ] }
			             ],
			});
		
		

</script>
<script
		src="<c:url value='/resources/assets/admin/js/jquery.dataTables.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/dataTables.select.min.js'/>"></script>
		<script
		src="<c:url value='/resources/assets/admin/js/dataTables.buttons.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/buttons.flash.min.js'/>"></script>
	<script src="<c:url value='/resources/assets/admin/js/jszip.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/pdfmake.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/buttons.html5.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/buttons.print.min.js'/>"></script>
			<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
</html>