
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
						<h1>Password Reset</h1>
					</div>
				</div>
			</div>
		
		</div>

	                <div class="col-lg-12">
					<div class="form-group">
					<h3>Reset Password</h3>
	<div class="col-md-4" style="margin-top: 10px;">
	<input type="hidden" id="pageContext" value="<c:url value='/'/>" />
					Your Email:
					</div>
	<div class="col-md-4" style="margin-top: 10px;">
	<input id="email" type="email" name="email" placeholder="Enter your email..." class="form-control" type="text" />
	<div class="col-md-4" style="margin-top: 10px;">
	<button class="btn-info"type="submit" onclick="resetPass()">reset</button>
	 <br>
    <a href="<c:url value='/registration.html'/>">
    registration
    </a>
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
		
		var serverContext = $("#pageContext").val();
		function resetPass(){
		    var email = $("#email").val();
		    $.post(serverContext + "user/resetPassword",{email: email} ,
		      function(data){
		    	alert("success");
		         
		    })
		    .fail(function(data) {
		       
		        alert("fail");
		    });
		}
		
		
		
		var serverContext = $("#pageContext").val();
		$(document).ready(function () {
		    $('form').submit(function(event) {
		        savePass(event);
		    });
		     
		    $(":password").keyup(function(){
		        if($("#password").val() != $("#matchPassword").val()){
		             $("#globalError").show().html('<p class="error">Password not Match!!<p>'); 
		        }else{
		            $("#globalError").html("").hide();
		        }
		    });
		});
		 
		function savePass(event){
		    event.preventDefault();
		    if($("#password").val() != $("#matchPassword").val()){
		        $("#globalError").show().html('<p class="error">Password not Match!!<p>'); 
		        return;
		    }
		    var formData= $('form').serialize();
		    $.post(serverContext + "user/savePassword",formData ,function(data){
		    	alert("message successfully change");
		        window.location.href = serverContext + "welcome.htm";
		    })
		    .fail(function(data) {
		    	alert("fail password change");
		       
		    });
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