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
	<style type="text/css">
	#right-panel{
	width:100%;
	}
	</style>
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
                        <h1>Check Lesson Plan</h1>
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
	<div class="row">
	<div class="col-md-12">
       <div class=" text-dark bg-success flex-md-row mb-4 shadow-sm h-md-250">
         <div class="col-lg-12">
			      <div class="table-responsive">
			        <table class="table table-hover" id="example">
			          <thead>
			            <tr>
			              <th>#</th>
			              <th>Title</th>
			              <th>Description</th>
			              <th>Year</th>
			              <th>Section</th>
			              <th>Subject</th> 
			              <th>Date</th>
			              <th>Actions</th>
			            </tr>
			          </thead>
			          <tbody>
			           <!--   for using loop -->
			           <c:forEach items="${documentTable}" var="item" varStatus="row">
							<tr>
								<td>${row.count}</td>
								<td class="hidden-480">${item.name}</td>
								<td class="hidden-480">${item.title}</td>
								<td class="hidden-480">${item.classLevelName}</td>
								<td class="hidden-480">${item.sectionName}</td>
								<td class="hidden-480">${item.subjectName}</td>
								<td class="hidden-480">${item.date}</td>
								<td>
									<button class="btn-outline-danger waves-effect" onclick="showDeleteModal(this,'${item.id}');">
										<i class="fa fa-trash-o"></i>
									</button>
									<a href ="<c:url value='/teacher/editDocument.htm/${item.id}'/>" >
									<button class="btn-outline-primary waves-effect" onclick="">
										<i class="fa fa-edit"></i>
									</button>
									</a>
								</td>
								</tr>
								</c:forEach>
			            <!--  for using loop -->
			            
			          </tbody>
			          <tfoot>
			           
			          </tfoot>
			        </table>
			      </div><!--end of .table-responsive-->
			     
			    </div>   
      </div>
	</div>
	</div>
		<!-- .content -->
	</div>
	<!-- /#right-panel -->

	<!-- Right Panel -->

	<%-- </sec:authorize> --%>
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
                <div class="hidden" id="temp-data"></div>
                <div class="hidden" id="temp-row"></div>
        
            <div  class="btn btn-success waves-effect wid" style="border-color: #009688;margin-right: 10px;" onclick="deleteCategory(this);">OK</div>
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
		document.getElementById("temp-row").value=btn;
	}
	function deleteCategory(btn){
		var contextUrl=$("#pageContext").val();
		var id=document.getElementById("hiddenId").value;
		var temprow=document.getElementById("temp-row").value;
		$(btn).attr("data-dismiss","modal");
	
	$.ajax({
		contentType : 'application/json; charset=utf-8',
		type : "GET",
		url : contextUrl+"teacher/ajax/delete-document/"+id,
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
</script>
	
</body>
</html>