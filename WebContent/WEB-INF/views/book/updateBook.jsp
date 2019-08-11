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
				<form:form commandName="BookDTO" class="form-horizontal" enctype="multipart/form-data"
					action="${pageContext.request.contextPath}/book/bookManagement.htm"
					role="form" method="post">
					<div class="form-group">
					
					<div class="col-md-6" style="margin-top: 10px;">
					Image:
					<form:hidden path="imgfile" />
					<form:hidden path="id" />
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<img id="blah" src="#" alt="no more than 10MB" /><br />
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
					Price:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="price" placeholder="Price..." required="true" class="form-control"
								onchange="showAlert(this.id);" type="text" />
					</div>
					
					<div class="col-md-6" style="margin-top: 10px;">
					Author:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="author" placeholder="Author..." required="true" class="form-control" type="text" />
					</div>
					
					
					<div class="col-md-6" style="margin-top: 10px;">
					ISBN:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="isbn" placeholder="ISBN..." required="true" class="form-control" type="text" />
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
					Edition:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="edition" placeholder="Edition..." required="true" class="form-control" type="text" />
					</div>	
					
					
					
						<div class="col-md-6" style="margin-top: 10px;">
					Quantity:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<form:input path="qty" placeholder="Quantity..." required="true" class="form-control" type="text" />
					</div>
				
						<div class="col-md-6" style="margin-top: 1px;">
					Class Level:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							<div class="form-control">
								<form:select path="classLevelId">
									<option data-display="">---Class Level---</option>
									<c:forEach items="${classLevelList}" var="item">
										<option value="${item.id}">${item.name}</option>
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
									<button class="btn-outline-danger waves-effect" onclick="showDeleteModal(this,'${item.id}');">
										<i class="fa fa-trash-o"></i>
									</button>
									<a href ="<c:url value='/book/editBook.htm/${item.id}'/>" >
									<button class="btn-outline-primary waves-effect" onclick="">
										<i class="fa fa-edit"></i>
									</button>
									</a>
								
       
   
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