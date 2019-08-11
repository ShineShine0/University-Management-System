<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="X-UA-Compatible" content== "IE=edge "/>
<meta name="google" value="notranslate" />




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

#msg {
	color: red;
}

#example_wrapper {
	width: 100%;
}

#exampleRoom_wrapper {
	width: 100%;
}

#subject_wrapper {
	width: 100%;
}
#subjectTable_wrapper{
width: 100%;
}
</style>


</head>
<body>



	<div id="right-panel" class="right-panel" style="width: 100%;">



		<!-- Header-->
		<header id="admin-header" class="header">

		<div class="header-menu">

			<div class="col-sm-7">
				<a id="menuToggle" class="menutoggle pull-left"><i
					class="fa fa fa-tasks" style="margin-top: 11px;"></i></a>

			</div>
		</div>

		</header>
		<!-- /header -->
		<div class="breadcrumbs">
			<div class="container">
				<ul class="nav nav-tabs">

					<li class="nav-item"><a data-toggle="tab" href="#home"
						class="nav-link active"><b>Year</b></b></a></li>
					<li class="nav-item"><a data-toggle="tab" class="nav-link"
						href="#menu1"><b>Room</b></a></li>
					<li class="nav-item"><a data-toggle="tab" class="nav-link"
						href="#menu2"><b>Subject</b></a></li>

				</ul>
			</div>
		</div>
		<div class="tab-content">


			<div id="home" class="tab-pane fade active show">
				<div class="content mt-3">
					<div class="col-lg-12">
						<div class="row"
							style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px; margin-top: 5px;">

							<form:form role="form"
								action="${pageContext.request.contextPath}/admin/saveyear.htm"
								method="post" class="form-horizontal" style="width: 100%;padding:20px;"
								commandName="classlevel">
								<div class="form-group">
									<div class="col-md-2" style="margin-top: 10px;">Teacher :</div>
									<div class="col-md-3" style="margin-top: 10px;">

										<form:select path="adminId" class="form-control" id="adminId">
											<form:options items="${adminList}" itemValue="id"
												itemLabel="name" />
										</form:select>

									</div>
									<div class="col-md-2" style="margin-top: 10px;">Year :</div>
									<div class="col-md-3" style="margin-top: 10px;">
										<form:hidden path="id" id="cl-id" />
										<form:input type="text" class="form-control" path="name"
											id="cl-name" />
									</div>
									<div class="col-md-2" style="margin-top: 10px;">
										<button type="submit" class="btn btn-info">Save</button>
									</div>
								</div>
							</form:form>

						</div>
					</div>

					<div class="col-lg-12" style="padding-top:20px;">
					<div class="row"
						style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px; margin-top: 5px;">
						<input type="hidden" value="${pageContext.request.contextPath}"
							id="pageContext">
						<table id="example" class="display" style="width: 100%;">
							<thead style="background-color: #009688b8;">
								<tr>
									<th>Id</th>
									<th>Year</th>
									<th>Teacher</th>
									<th>Actions</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${classLevelList}" var="item">
									<tr class="gradeX">
										<td>${item.id}</td>
										<td>${item.name}</td>
										<td>${item.admin.name}</td>
										<td><a
											href="<c:url value='/admin/editClassLevel.htm/${item.id}'/>"
											class="btn btn-info">Edit</a> <a href="#"
											onclick="showDeleteModal(this,'${item.id}','class');"
											class="btn btn-info">Delete</a></td>

									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					</div>
				</div>
			</div>




			<div id="menu1" class="tab-pane fade">
				<div class="content mt-3">
					<div class="col-lg-12">
						<div class="row"
							style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px; margin-top: 5px;">

							<form:form role="form"
								action="${pageContext.request.contextPath}/admin/saveSection.htm"
								method="post" class="form-horizontal"
								style="width: 100%;padding:20px;" commandName="section">
								<div class="form-group">
									<div class="col-md-1" style="margin-top: 10px;">Year</div>
									<div class="col-md-3" style="margin-top: 10px;">
										<form:select path="classLevelId" class="form-control"
											id="classLevelId" onchange="filterTeacher(this.value)">
											<form:options items="${classLevelList}" itemValue="id"
												itemLabel="name" />
										</form:select>
									</div>
									<div class="col-md-1" style="margin-top: 10px;">Teacher</div>
									<div class="col-md-3" style="margin-top: 10px;">

										<form:select path="adminId" class="form-control" id="adminId">
											<form:options items="${adminList}" itemValue="id"
												itemLabel="name" />
										</form:select>

									</div>
									<div class="col-md-1" style="margin-top: 10px;">Room</div>
									<div class="col-md-3" style="margin-top: 10px;">
										<form:hidden path="id" id="cl_id" />
										<form:input type="text" class="form-control" path="name"
											id="id" />

									</div>

									<div class="col-md-2" style="margin-top: 10px;">
										<button type="submit" class="btn btn-info">Save</button>
									</div>
								</div>
							</form:form>

						</div>



					</div>

					<div class="col-lg-12" style="padding-top: 20px;">
						<div class="row"
							style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px; margin-top: 5px;">
							<table id="exampleRoom" class="display" style="width:100%;">
								<thead style="background-color: #009688b8;">
									<tr>
										<th>Id</th>
										<th>Room</th>
										<th>Teacher</th>
										<th>Year</th>
										<th>Actions</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${sectionList}" var="item">
										<tr class="gradeX">
											<td>${item.id}</td>
											<td>${item.name}</td>

											<td>${item.admin.name}</td>
											<td>${item.classLevel.name}</td>
											<td><a
												href="<c:url value='/admin/editSection.htm/${item.id}'/>"
												class="btn btn-info">Edit</a> <a href="#"
												onclick="showDeleteModal(this,'${item.id}','class');"
												class="btn btn-info">Delete</a></td>

										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

			<div id="menu2" class="tab-pane fade">
				<div class="content mt-3">
					<div class="col-lg-12">
						<div class="row"
							style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px; margin-top: 5px;">

							<form:form role="form"
								action="${pageContext.request.contextPath}/admin/savesubject.htm"
								method="post" class="form-horizontal" style="width: 100%;"
								commandName="subject">
								<div class="form-group">
									<div class="row">
										<div class="col-md-1" style="margin-top: 10px;">Year :</div>
										<div class="col-md-3" style="margin-top: 10px;">

											<form:select path="classLevelId" class="form-control"
												id="cl-id" onchange="filterTeacher(this.value)">
												<form:options items="${classLevelList}" itemValue="id"
													itemLabel="name" />
											</form:select>
										</div>
										<div class="col-md-1" style="margin-top: 10px;">Major :</div>
										<div class="col-md-3" style="margin-top: 10px;">

											<form:checkboxes items="${majorList}" path="majorIdList"
												itemValue="id" itemLabel="name" />

										</div>
										<div class="col-md-1" style="margin-top: 10px;">Teacher
											:</div>
										<div class="col-md-3" style="margin-top: 10px;">

											<form:select path="adminId" class="form-control" id="adminId">
												<form:options items="${adminList}" itemValue="id"
													itemLabel="name" />
											</form:select>

										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-1" style="margin-top: 10px;">Subject :</div>
									<div class="col-md-3" style="margin-top: 10px;">
										<form:hidden path="id" id="cl-id" />
										<form:input type="text" class="form-control" path="name"
											id="cl-name" />
									</div>

									<div class="col-md-2" style="margin-top: 10px;">
										<button type="submit" class="btn btn-info">Save</button>
									</div>
								</div>
							</form:form>

						</div>
					</div>

					<br>
					<br>
					<div class="col-lg-12" style="padding-top: 20px;">
						<div class="row"
							style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px; margin-top: 5px;">
							<input type="hidden" value="${pageContext.request.contextPath}"
								id="pageContext">
							<table id="subjectTable" class="display" style="width:100%;">
								<thead style="background-color: #009688b8;">
									<tr>
										<th>No</th>
										<th>Year</th>
										<th>Major</th>
										<th>Teacher</th>
										<th>Subject</th>
										<th>Actions</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${subjectList}" var="item" varStatus="row">
										<tr class="gradeX">
											<td>${row.count}</td>
											<td>${item.classLevelName}</td>
											<td>${item.majorName}</td>
											<td>${item.teacherName}</td>
											<td>${item.name}</td>

											<td><a href="<c:url value='/admin/editclasslevel.htm/${item.id}'/>"
												class="btn btn-info">Edit</a> <a href="#"
												onclick="showDeleteModal(this,'${item.id}','subject');"
												class="btn btn-info">Delete</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-notify modal-warning" role="document">
			<!--Content-->
			<div class="modal-content">
				<!--Header-->
				<div class="modal-header" style="background-color: #dc3545;">
					<p class="heading lead" style="color: white;">Are you sure??</p>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" class="white-text">&times;</span>
					</button>
				</div>

				<!--Footer-->
				<div class="modal-footer justify-content-center"
					style="background-color: #f4433617;">
					<div class="hidden" id="hiddenId"></div>
					<div class="hidden" id="temp-data"></div>
					<div class="hidden" id="temp-row"></div>
					<div class="btn btn-success waves-effect wid"
						style="border-color: #009688; margin-right: 10px;"
						onclick="deleteCategory(this);">OK</div>
					<div class="btn btn-danger waves-effect wid" data-dismiss="modal">Cancel</div>
				</div>
			</div>
			<!--/.Content-->
		</div>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
	    $('#example').DataTable( {
	        dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
	    } );
	
	    $('#exampleRoom').DataTable( {
	        dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
	    } );
	    
	    $('#subjectTable').DataTable( {
	        dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
	    } );
	});
	function showDeleteModal(btn,id,temp)
	{
		$(btn).attr("data-toggle","modal");
		$(btn).attr("data-target","#deleteModal");
		document.getElementById("hiddenId").value=id;
		document.getElementById("temp-data").value=temp;
		document.getElementById("temp-row").value=btn;

	}
	function deleteCategory(btn){
		var contextUrl=$("#pageContext").val();
		var id=document.getElementById("hiddenId").value;
		var temp=document.getElementById("temp-data").value;
		var temprow=document.getElementById("temp-row").value;
		$(btn).attr("data-dismiss","modal");
		if(temp == "class"){
			$.ajax({
				contentType : 'application/json; charset=utf-8',
				type : "GET",
				url : contextUrl+"admin/ajax/delete-classLevel/"+id,
				dataType : 'json',
				success : function(data){
					if(data+""=== "true"){
						$(temprow).closest('tr').remove();
					}else{
						alert("Cannot Delete");
					}
					
				},
				complete :function(){
					
				}
				}); 
		}
		else if(temp == "section"){
			$.ajax({
				contentType : 'application/json; charset=utf-8',
				type : "GET",
				url : contextUrl+"admin/ajax/delete-section/"+id,
				dataType : 'json',
				success : function(data){
					if(data+""=== "true"){
						$(temprow).closest('tr').remove();
					}else{
						alert("Cannot Delete");
					}
					
				},
				complete :function(){
					
				}
				});
			
		}
		else{
			$.ajax({
				contentType : 'application/json; charset=utf-8',
				type : "GET",
				url : contextUrl+"admin/ajax/delete-subject/"+id,
				dataType : 'json',
				success : function(data){
					if(data+""=== "true"){
						$(temprow).closest('tr').remove();
					}else{
						alert("Cannot Delete");
					}
					
				},
				complete :function(){
					
				}
				});
			
		}
	 
	}

	</script>
</html>