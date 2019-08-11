<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<%@ include file="/WEB-INF/views/common/include.jsp"%>
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
</style>
</head>
<body>
	<div id="right-panel" class="right-panel" style="width: 100%;">

		<!-- Header-->
		<header id="admin-header" class="header">
			<div class="header-menu">
			
                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks" style="margin-top: 11px;"></i></a>
                </div>
			</div>
		</header>
		<!-- /header -->
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
							<li class="active">Add Course</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<div class="col-lg-12">
			<div class="row" style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px;margin-top:5px;">
				<form:form commandName="studentDTO" class="form-horizontal" enctype="multipart/form-data"
					action="${pageContext.request.contextPath}/Student/updatestudent.htm"
					role="form" method="POST">
					<div class="form-group">
					
					<div class="col-md-6" style="margin-top: 10px;">
					Image:
					<form:hidden path="imagepath" />
					<form:hidden path="id" />
					<form:hidden path="userId" value="${studentDTO.userId}"/>
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<img id="blah" src="${studentDTO.imagepath }" width="100px" alt="no more than 10MB" /><br />
								<form:input type="file" onchange="readURL(this);"
									path="imgfile"/>
					</div>
					
					
					<div class="col-md-6" style="margin-top: 10px;">
					Name:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="name" placeholder="Name..." required="true" class="form-control"
								onchange="showAlert(this.id);" type="text" />
					</div>
					
					<div class="col-md-6" style="margin-top: 10px;">
					RollNO:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="rollNo" placeholder="Rollno..." required="true" class="form-control"
								onchange="showAlert(this.id);" type="text" />
					</div>
					
					<div class="col-md-6" style="margin-top: 10px;">
					NRC:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="nrc" placeholder="NRC..." required="true" class="form-control" type="text" />
					</div>
					
					
					<div class="col-md-6" style="margin-top: 10px;">
					Date Of Birth:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="dob" placeholder="DateOfBirth..." required="true" class="form-control" type="Date" />
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
					RunningYear:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="runningYear" placeholder="RunningYear..." required="true" class="form-control" type="text" />
					</div>	
					<div class="col-md-6" style="margin-top: 1px;">
					Gender:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="gender" placeholder="gender..." required="true" class="form-control" type="text" />
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
					Address:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="address" placeholder="Address..." required="true" class="form-control" type="text" />
					</div>
					
					
					<div class="col-md-6" style="margin-top: 10px;">
					Phone:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="phone" placeholder="Phone..." required="true" class="form-control" type="text" />
					</div>
				
					<div class="col-md-6" style="margin-top: 10px;">
					Email:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="email" placeholder="Email..." required="true" class="form-control" type="text" />
					</div>
					
						
					<div class="col-md-6" style="margin-top: 10px;">
					Password:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="password" placeholder="Password..." required="true" class="form-control" type="password" />
					</div>
					<div class="col-md-6" style="margin-top: 1px;">
					Nationality:
					<input type="hidden" id="nationality-id" value="${studentDTO.nationality}"/>
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
					<div class="form-control">
								<form:select path="nationality">
									<option data-display="">---Nationalitiy---</option>
									<c:forEach items="${nationality}" var="item">
										<option value="${item.name}">${item.name}</option>
									</c:forEach>
								</form:select>
						</div>
					</div>
					
					<div class="col-md-6" style="margin-top: 1px;">
					Religion:
					<input type="hidden" id="religion-id" value="${studentDTO.religion}"/>
					
  					</div>
					<div class="col-md-6" style="margin-top: 10px;">
					<div class="form-control">
								<form:select path="religion">
									<option data-display="">---Religion---</option>
									<c:forEach items="${religion}" var="item">
										<option value="${item.name}">${item.name}</option>
									</c:forEach>
								</form:select>
						</div>
					</div>
					
					<div class="col-md-6" style="margin-top: 1px;">
					Citizen:
					<input type="hidden" id="citizen-id" value="${studentDTO.citizen}"/>
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
					<div class="form-control">
								<form:select path="citizen">
									<option data-display="">---Citizen---</option>
									<c:forEach items="${citizen}" var="item">
										<option value="${item.name}">${item.name}</option>
									</c:forEach>
								</form:select>
						</div>
					</div>
						<div class="col-md-6" style="margin-top: 1px;">
					ClassLevel:
					
 					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<div class="form-control">
								<form:select path="classLevelId">
									<option data-display="">---Class Level---</option>
									<c:forEach items="${classLevelList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						</div>
					</div>
						<div class="col-md-6" style="margin-top: 1px;">
					Major:
                     </div>
					<div class="col-md-6" style="margin-top: 10px;">
							<div class="form-control">
								<form:select path="majorId">
									<option data-display="">---Major---</option>
									<c:forEach items="${majorList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						</div>
					</div>
						<div class="col-md-6" style="margin-top: 1px;">
					Section:
					
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<div class="form-control">
								<form:select path="sectionId">
									<option data-display="">---Section---</option>
									<c:forEach items="${sectionList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						</div>
					</div>
					
					<%-- <div class="col-md-6" style="margin-top: 1px;">
					User Role:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
					<div class="form-control">
								<form:select path="adminRoleId">
									<option data-display="">---UserRole---</option>
									<c:forEach items="${adminRoleList}" var="item">
										<form:option value="${item.adminRoleId}">${item.adminRoleName}</form:option>
									</c:forEach>
								</form:select>
						</div>
					</div> --%>
				
					
				
					<div class="col-md-6" style="margin-top: 10px; margin-bottom: 10px;">
						<input type="submit" class="btn btn-sm" value="Add"
								style="color: white; background-color: #00bcd487; width: 100px; border-radius: 5px;" />
					</div>
					</div>


				</form:form>
			</div>
	
		
		
	
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog modal-notify modal-warning" role="document">
    <!--Content-->
    <div class="modal-content">
        <!--Header-->
        <div class="modal-headexr" style="background-color:#dc3545;">
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
		var nationlity = $("#nationality-id").val();
		if(nationlity != null){
			$("#nationality").val(nationlity);
		}
		var religion = $("#religion-id").val();
		if(religion != null){
			$("#religion").val(religion);
		}
		var citizen = $("#citizen-id").val();
		if(citizen != null){
			$("#citizen").val(citizen);
		}
	 	/*  var classlevel = $("#classLevel-id").val();
		if(classlevel != null){
		
			$("#classlevel").val(classlevel);
		}  */ 
		/* var major = $("#major-id").val();
		if(major != null){
			$("#major").val(major);
		} */
		/* var section = $("#section-id").val();
		if(section != null){
			$("#section").val(section);
		} */
		
		
    $('#example').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
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
})
	});
</script>

</body>

</html>