<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
</style>
<title>Student View Page</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/submenucss/menu.css'/>" />
</head>
<body>
<%-- <sec:authorize access="hasRole('ROLE_Admin')" > --%>
    <!-- Right Panel -->

    <div id="right-panel" class="right-panel">

        <!-- Header-->
        <header id="admin-header" class="header">

            <div class="header-menu">

                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks" style="margin-top: 11px;"></i></a>
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

        </header><!-- /header -->
        <!-- Header-->

        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Home</h1>
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
				action="${pageContext.request.contextPath}/teacher/updateLessonPlan.htm" commandName="documentDto" role="form" method="POST" enctype="multipart/form-data">
					<div class="form-group">

					<div class="col-md-6" style="margin-top: 10px;">
					 File:
					 <form:hidden path="dataPath"/>
					 <form:hidden path="id"/>
					</div>
						<div class="col-md-6" style="margin-top: 10px;">
						<a target="_blank" href="${documentDto.dataPath}"
	  				download="" class="btn btn-primary">File</a>
						<form:input type="file" onchange="readURL2(this);" path="textfile" /> 
						</div>
					<div class="col-md-6" style="margin-top: 10px;">
					 Image:
					 <form:hidden path="imagePath"/>
					</div>
						<div class="col-md-6" style="margin-top: 10px;">
						<img src="${documentDto.imagePath}" class="img-fluid z-depth-1"
      					alt="Responsive image">
								<form:input type="file" onchange="readURL1(this);"
									path="imgfile" />
						</div>
						<div class="col-md-6" style="margin-top: 10px;">Date:</div>
						<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="date" placeholder="Date..." required="true"
								class="form-control" type="date" />
						</div>
						<div class="col-md-6" style="margin-top: 10px;">Year:</div>
						<div class="col-md-6" style="margin-top: 10px;">
								<input type="hidden" id="class" value="${documentDto.classLevelId}"/>
								<form:select path="classLevelId" id="classLevelId" class="form-control" required="true">
									<option data-display="">--Choose Year--</option>
									<c:forEach items="${classLevelList}" var="item">
										<option value="${item.id}">${item.name}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						
						<div class="col-md-6" style="margin-top: 10px;">Subject:</div>
						<div class="col-md-6" style="margin-top: 10px;">
							<input type="hidden" id="subject" value="${documentDto.subjectId}"/>
								<form:select path="subjectId" id="subjectId" class="form-control" required="true">
									<option data-display="">---Choose Subject---</option>
									<c:forEach items="${subjectList}" var="item">
										<option value="${item.id}">${item.name}</option>
									</c:forEach> 
								</form:select>
							
						</div>
						<div class="col-md-6" style="margin-top: 10px;">Room:</div>
						<div class="col-md-6" style="margin-top: 10px;">
							<input type="hidden" id="section" value="${documentDto.sectionId}"/>
								<form:select path="sectionId" id="sectionId" class="form-control" required="true">
									<option data-display="">---Choose Room---</option>
									 <c:forEach items="${sectionList}" var="item">
										<option value="${item.id}">${item.name}</option>
						</c:forEach> 
								</form:select>
							
						</div>
						<div class="col-md-6" style="margin-top: 10px;">Title:</div>
						<div class="col-md-6" style="margin-top: 10px;">
						<form:input path="name" class="form-control" required="true"/>
						</div>
							
<div class="form-group">
  <label for="comment">Destription:</label>
  <form:textarea path="title" id="editor" cols="20" rows="10" required="true"/>
</div>

<div class="form-check">
    <input type="checkbox" class="form-check-input" id="term-and-condition">
    <label class="form-check-label" for="term-and-condition">Check me out</label>
  </div>
						<div class="col-md-6"
							style="margin-top: 10px; margin-bottom: 10px;">
							<input type="submit" class="btn btn-success" value="Send" disabled="disabled" id="add-lesson"
								style="color: white; background-color: #00bcd487; width: 100px; border-radius: 5px;" />
						</div>
  						</form:form>
					</div>
			</div>
			<!-- for table -->
			
						<!-- for table -->
			
		</div>
	
       <!-- .content -->
    <!-- /#right-panel -->

    <!-- Right Panel -->
 
<%-- </sec:authorize> --%>
</body>
<script src="https://cdn.ckeditor.com/4.8.0/full-all/ckeditor.js"></script>
<script type="text/javascript">
$(function (){
	$("#classLevelId").val($("#class").val());
	$("#sectionId").val($("#section").val());
	$("#subjectId").val($("#subject").val());
});
function readURL1(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah1')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };
        reader.readAsDataURL(input.files[0]);
    }
}
function readURL2(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah2')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };

        reader.readAsDataURL(input.files[0]);
    }
}
$(function(){
	$("#classLevelId").on("change" ,function(){
		var contextUrl = $("#pageContext").val();
		var param =$("#classLevelId").val();
		$("#subjectId > *").remove();
		$.ajax({
			
	          contentType : 'application/json; charset=utf-8',
	          type: "GET",
	          url: contextUrl+"teacher/ajax/get-subject-list",
	          dataType : 'json',
	          data : "classLevelId="+param,
	          success : function(data){	
	        	  var html = '<option value="">--Select Subject--</option>';
					var len = data.length;
		        		  for ( var i = 0; i < len; i++) {
								html += '<option value="' + data[i].id + '">'
										+ data[i].name
										+ '</option>';
							} 
						$('#subjectId').html(html);
					if (typeof(callback) == "function") {
						callback();
					}      	                       
	          },
	          error: function (){
	        	  var html = '<option value="">--Select Section--</option>';
	        	  $('#subjectId').html(html);
	          },
	          complete: function()
	          {
	        	  
	          }  
		});
	});
});
		$(function(){
			$("#classLevelId").on("change" ,function(){
				var contextUrl = $("#pageContext").val();
				$("#sectionId > *").remove();
				var param =$("#classLevelId").val();
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
 });
			
		
		
		$(function (){
			$('#term-and-condition').click(function (){
				if($('#term-and-condition').is(':checked')){
					$('#add-lesson').prop("disabled", false);
				}else{
					$('#add-lesson').prop("disabled", true);
				}
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
		});
		
			
</script>
</html>