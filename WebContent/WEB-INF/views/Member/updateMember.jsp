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
							<li class="active">Add Member</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<div class="col-lg-12">
			<div class="row" style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px;margin-top:5px;">
				<form:form commandName="adminDTO" class="form-horizontal" enctype="multipart/form-data"
					action="${pageContext.request.contextPath}/admin/updateMember.htm"
					role="form" method="post">
					<div class="form-group">
					
					<div class="col-md-6" style="margin-top: 10px;">
					Image:
					<form:hidden path="imagePath" />
					<form:hidden path="id" />
					<form:hidden path="userId" value="${adminDTO.userId}"/>
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<img id="blah" src="${adminDTO.imagePath }" alt="no more than 10MB" /><br />
								<form:input type="file" onchange="readURL(this);"
									path="imgfile" required="true"/>
					</div>
					
					
					<div class="col-md-6" style="margin-top: 10px;">
					Name:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="name" placeholder="Name..." required="true" class="form-control"
								onchange="showAlert(this.id);" type="text" />
					</div>
					
					
					<div class="col-md-6" style="margin-top: 10px;">
					NRC:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="nrc" placeholder="NRC..." required="true" class="form-control" type="text" />
					</div>
					
					
						
					<div class="col-md-6" style="margin-top: 10px;">
					Address:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="address" placeholder="Address..." required="true" class="form-control" type="Date" />
					</div>
					
					<div class="col-md-6" style="margin-top: 10px;">
					Date Of Birth:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="dob" placeholder="DateOfBirth..." required="true" class="form-control" type="text" />
					</div>
						
					<div class="col-md-6" style="margin-top: 10px;">
					Mobile Number:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="mobileNumber" placeholder="MobileNmber..." required="true" class="form-control" type="text" />
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
					Position:
					<input type="hidden" id="position-id" value="${adminDTO.position}"/>
					
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<div class="form-control">
								<form:select path="position">
									<option data-display="">---Position---</option>
									<option value="admin">Admin</option>
									<option value="teacher">Teacher</option>
									
								</form:select>
						</div>
					</div>
					
					<div class="col-md-6" style="margin-top: 1px;">
					Gender:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="gender" placeholder="gender..." required="true" class="form-control" type="text" />
					</div>
				
				
					<div class="col-md-6" style="margin-top: 1px;">
					Nationality:
					<input type="hidden" id="nationality-id" value="${adminDTO.nationality}"/>
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
					<div class="form-control">
								<form:select path="nationality">
									<form:option value="0">---Nationalitiy---</form:option>
									<c:forEach items="${nationality}" var="item">
										<form:option value="${item.name}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						</div>
					</div>
					
					<div class="col-md-6" style="margin-top: 1px;">
					Department:
				
					
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<div class="form-control">
								<form:select path="departmentId">
									<form:option value="0">---User Department---</form:option>
									<c:forEach items="${departmentList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						</div>
					</div>
					
					
				<div class="col-md-6" style="margin-top: 1px;">
					User Role:
					
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
					<div class="form-control">
								<form:select path="adminRoleId">
									<form:option value="0">---UserRole---</form:option>
									<c:forEach items="${userRole}" var="item">
										<form:option value="${item.adminRoleId}">${item.adminRoleName}</form:option>
									</c:forEach>
								</form:select>
						</div>
					</div>
				
					<div class="col-md-6" style="margin-top: 10px; margin-bottom: 10px;">
						<input type="submit" class="btn btn-sm" value="Add"
								style="color: white; background-color: #00bcd487; width: 100px; border-radius: 5px;" />
					</div>
					</div>


				</form:form>
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
		var nationlity = $("#nationality-id").val();
		if(nationlity != null){
			$("#nationality").val(nationlity);
		}
		
		var position = $("#position-id").val();
		if(position != null){
			$("#position").val(position);
		}
		
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
		alert(id);
			
	$.ajax({
		contentType : 'application/json; charset=utf-8',
		type : "GET",
		url : contextUrl+"admin/ajax/delete-admin/"+id,
		dataType : 'json',
		success : function(data){
			if(data == "true"){
				document.location.href='addmember.htm';
			}else{
				alert("Cannot Delete");
			}
		},
		complete :function(){
			
		}
	});
	}
</script>

</body>

</html>