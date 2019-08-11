
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
						<h1>Edit ClassLevel</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					
				</div>
			</div>
		</div>
		
		<div class="container">
 
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
  <div class="span3"></div>
    <div class="span6">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form:form action="${pageContext.request.contextPath}/admin/updateClassLevel.htm" method="post" class="form-horizontal" commandName="classlevel">
          

             <form:hidden path="id"/>
            <div class="control-group">
              <label class="control-label">ClassLevel :</label>
              <div class="controls">
                <form:input type="text" class="form-control col-sm-3" path="name"/>
                <form:errors path="name" class="text-danger"/>
              </div>
            </div>
           
          <br/>
            <div class="form-actions">
             <div class="controls">
              <button type="submit" class="btn btn-info col-sm-2">Save</button>
              </div>
            </div>
          </form:form>
        </div>
      </div>
      
      
    </div>
    
  </div>
  
</div>

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