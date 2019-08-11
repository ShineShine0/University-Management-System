<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html">

<html>
<head>

<style type="text/css">
td.highlight {
	font-weight: bold;
	color: blue;
}

.wid {
	border-radius: 10px;
	width: 80px;
	height: 30px;
}
#example_wrapper{
width:100%;
}
#example{
width:100%;
}
</style>
</head>
<body>
	<div id="right-panel" class="right-panel" style="width: 100%;">

		<!-- Header-->
		<header id="admin-header" class="header">
			<div class="header-menu">
			 <div class="header-menu">

                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks" style="margin-top: 11px;"></i></a>
                   
                </div>
            </div>
			</div>
		</header>
		<!-- /header -->
		<div class="breadcrumbs">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>AttendanceList By Month</h1>
					</div>
				</div>
			</div>
		</div>

		<div class="col-lg-12">
			<div class="row" style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px;margin-top:5px;">
				<form:form  class="form-horizontal" 
					action="${pageContext.request.contextPath}/admin/search_attendanceListByMonth.htm"
					role="form" method="post" commandName="attendanceDTO">
					<div class="col-sm-12">
					<label class="col-sm-4">Class Level</label>
					<label class="col-sm-4">Section</label>
					<label class="col-sm-4">Major</label>
					</div>
					<div class="col-sm-12">
						
						<div class="col-sm-4">
						<form:select path="classLevelId"  class="form-control">
									<form:option value="0">---Class Level---</form:option>
									<c:forEach items="${classLevelList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						</div>
						<div class="col-sm-4">
						<form:select path="sectionId" class="form-control" id="sectionId">
									<form:option value="0">---Section---</form:option>
									<c:forEach items="${sectionList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						</div>
						<div class="col-sm-4">
							<form:select path="majorId" class="form-control" id="majorId">
									<form:option value="0">---Major---</form:option>
									<c:forEach items="${majorList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						</div>
						
					</div>
					<div class="col-sm-12">
					
					<label class="col-sm-4">Month</label>
					<label class="col-sm-8"></label>
					
					</div>
					<div class="col-sm-12">
					<div class="col-sm-4">
							<form:select path="month" class="form-control" >
									<form:option value="0">---Select Month---</form:option>
									<c:forEach items="${monthList}" var="item">
										<form:option value="${item.month}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						</div>
						<div class="col-sm-8">
						<br>
						<input type="submit" class="btn btn-sm" value="Search" class="col-sm-2"
								style="color: white; background-color: #00bcd487; width: 100px; border-radius: 5px;" />
						<br>
						</div>
						
					</div>
					
					</form:form>
					</div>
					


			</div>
			<div class="col-lg-12">
			
			<div class="row" style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px;margin-top:5px;">
<table  class="table table-primary" style="width: 100%;"  border="1" cellspacing="4" cellpadding="2">
        <thead style="background-color: #a34bd0b8;">
            <tr>
            	<th>#</th>
            	<th>Roll_No </th>
                <th>Name </th>
                <c:forEach items="${dayList }" var="day">
                <th>
                ${day }
                </th>
                </c:forEach>
                <th>Total Attendance</th>
               
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${attStudentList}" var="item" varStatus="row">
							<tr>
								<td>${row.count}
								</td>
								<td class="hidden-480">${item.rollNo}</td>
								<td class="hidden-480">${item.name}</td>
								<c:forEach items="${item.attCountList}" var="atCount" >
								<c:choose>
								<c:when test="${atCount eq 0 }">
								<td style="background:gray;">
								</td>
								</c:when>
								<c:otherwise>
								<td>
								${atCount }
								</td>
								</c:otherwise>
								</c:choose>
								
								</c:forEach>
								<td class="hidden-480">
								
							${item.totalCount }
								</td>
								
							</tr>
						</c:forEach> 
        </tbody>
       
    </table>
			</div>

			</div>
		</div>
		

	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog modal-notify modal-warning" role="document">
    <!--Content-->
    <div class="modal-content">
        <!--Header-->
        <div class="modal-header" style="background-color:#dc3545;">
            <p class="heading lead" style="color:white;">Are you sure??</p>

            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true" class="white-text">&times;</span>
            </button>
        </div>

        <!--Footer-->
        <div class="modal-footer justify-content-center" style="background-color:#f4433617;">
        <div class="hidden" id="hiddenId"></div>
            <div  class="btn btn-success waves-effect wid" style="border-color: #009688;margin-right: 10px;" onclick="deleteNews(this);">OK</div>
            <div class="btn btn-danger waves-effect wid" data-dismiss="modal">Cancel</div>
        </div>
    </div>
    <!--/.Content-->
</div>
</div>


		
	<script type="text/javascript">
	$(document).ready(function() {		
	    $('#example').DataTable( {
	        dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
	    } );
	} );
	function readURL(input) {
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();

	        reader.onload = function (e) {
	            $('#blah')
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
			$("#sectionId > *").remove();
			$.ajax({
				
		          contentType : 'application/json; charset=utf-8',
		          type: "GET",
		          url: contextUrl+"admin/ajax/get-section-list-for-attendance",
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
			$(function(){
				$("#majorId").on("change" ,function(){
					var contextUrl = $("#pageContext").val();
					//$("#sectionId > *").remove();
					var param1 =$("#classLevelId").val();
					var param2 =$("#majorId").val();
					 $('#subjectId >*').remove();
					$.ajax({
						
				          contentType : 'application/json; charset=utf-8',
				          type: "GET",
				          url: contextUrl+"admin/ajax/get-subject-list-for-attendance",
				          dataType : 'json',
				          data : {classLevelId:param1,
			        	  		majorId:param2},
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
				        	  var html = '<option value="">--Select Subject--</option>';
				        	  $('#subjectId').html(html);
				          },
				          complete: function()
				          {
				        	  
				          }  
					});
		});
	 });
	
	
	function showDeleteModal(btn,id)
	{
		$(btn).attr("data-toggle","modal");
		$(btn).attr("data-target","#deleteModal");
		document.getElementById("hiddenId").value=id;

	}
	function deleteNews(btn){
		var contextUrl=$("#pageContext").val();
		var id=document.getElementById("hiddenId").value;
		$(btn).attr("data-dismiss","modal");
		
	}
	
	$.ajax({
		contentType : 'application/json; charset=utf-8',
		type : "GET",
		url : contextUrl+"/member/ajax/delete-student/"+id,
		dataType : 'json',
		success : function(data){
			if(data+""=== "true"){
				document.location.href='studentmanagements.htm';
			}else{
				alert("Cannot Delete");
			}
			
		},
		complete :function(){
			
		}
});
</script>

</body>

</html>