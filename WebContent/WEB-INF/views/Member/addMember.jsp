<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
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
						<h1>Admin & Teacher Registration</h1>
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
					action="${pageContext.request.contextPath}/admin/addMember.htm"
					role="form" method="post">
					<div class="form-group">
					
					<div class="col-md-6" style="margin-top: 10px;">
					Image:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<img id="blah" src="#" alt="no more than 10MB" /><br />
								<form:input type="file" onchange="readURL(this);"
									path="imgfile" required="true"/>
					</div>
					
					
					<div class="col-md-6" style="margin-top: 10px;">
					Name:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<form:input path="name" placeholder="Name..." required="true" class="form-control"
								onchange="showAlert(this.id);" type="text" />
					</div>
					
					
					<div class="col-md-6" style="margin-top: 10px;">
					NRC:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<form:input path="nrc" placeholder="NRC..." required="true" class="form-control" type="text" />
					</div>
					
					
						
					<div class="col-md-6" style="margin-top: 10px;">
					Address:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<form:input path="address" placeholder="Address..." required="true" class="form-control" type="text" />
					</div>
					
					<div class="col-md-6" style="margin-top: 10px;">
					Date Of Birth:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<form:input path="dob" placeholder="DateOfBirth..." required="true" class="form-control" type="Date" />
					</div>
						
					<div class="col-md-6" style="margin-top: 10px;">
					Mobile Number:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<form:input path="mobileNumber" placeholder="MobileNmber..." required="true" class="form-control" type="text" />
					</div>
				
					
					
					<div class="col-md-6" style="margin-top: 10px;">
					Email:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<form:input path="email" placeholder="Email..." required="true" class="form-control" type="text" />
					</div>
					
						
					<div class="col-md-6" style="margin-top: 10px;">
					Password:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<form:input path="password" placeholder="Password..." required="true" class="form-control" type="password" />
					</div>
					
					
				
					<div class="col-md-6" style="margin-top: 1px;">
					Position:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<div class="form-control">
								<form:select path="position">
									<option data-display="">---User Role---</option>
									<option value="admin">Admin</option>
									<option value="teacher">Teacher</option>
									
								</form:select>
						</div>
					</div>
					
					<div class="col-md-6" style="margin-top: 1px;">
					Gender:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<form:input path="gender" placeholder="gender..." required="true" class="form-control" type="text" />
					</div>
				
				
					<div class="col-md-6" style="margin-top: 1px;">
					Nationality:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
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
					Department:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
							<div class="form-control">
								<form:select path="departmentId">
									<option data-display="">---User Department---</option>
									<c:forEach items="${departmentList}" var="item">
										<option value="${item.id}">${item.name}</option>
									</c:forEach>
								</form:select>
						</div>
					</div>
					
					
				<div class="col-md-6" style="margin-top: 1px;">
					User Role:
					</div>
					<div class="col-md-3" style="margin-top: 10px;">
					<div class="form-control">
								<form:select path="adminRoleId">
									<option data-display="">---UserRole---</option>
									<c:forEach items="${userRole}" var="item">
										<option value="${item.adminRoleId}">${item.adminRoleName}</option>
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
	
		
		
		<div class="row"
				style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px;margin-top:5px;">
			<table id="example" class="display" style="width: 100%;">
        <thead style="background-color: #009688b8;">
            <tr>
            	<th>#</th>
                <th>Name </th>
                <th>NRC</th>
                <th>Address</th>
                <th>DateOfBirth</th>
                <th>Mobile Number</th>
                <th>Email</th>
                 <th>Password</th>
                  <th>Position</th>
                   <th>Gender</th>
                   <th>Nationality</th>
                   <th>Department</th>
                   <th>Option</th>
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${adminList}" var="item" varStatus="row">
							<tr>
								<td>${row.count}</td>
								<td class="hidden-480">${item.name}</td>
								<td class="hidden-480">${item.nrc}</td>
								<td class="hidden-480">${item.address}</td>
								<td class="hidden-480">${item.dob}</td>
								<td class="hidden-480">${item.mobileNumber}</td>
								<td class="hidden-480">${item.email}</td>
								<td class="hidden-480">${item.password}</td>
								<td class="hidden-480">${item.position}</td>
								<td class="hidden-480">${item.gender}</td>
								<td class="hidden-480">${item.nationality}</td>
								<td class="hidden-480">${item.departmentName}</td>								
								<td>
									<button class="btn-outline-danger waves-effect" onclick="showDeleteModal(this,'${item.id}');">
										<i class="fa fa-trash-o"></i>
									</button>
									<a href ="<c:url value='/admin/editMember.htm/${item.id}'/>" >
									<button class="btn-outline-primary waves-effect" onclick="">
										<i class="fa fa-edit"></i>
									</button>
									</a>
								</td>
							</tr>
						</c:forEach> 
        </tbody>
        <tfoot>
            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
               <th></th>
               <th></th>
               <th></th>
               <th></th>
               <th></th>
               <th></th>
               <th></th>
               <th></th>
                <th></th>
            </tr>
        </tfoot>
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