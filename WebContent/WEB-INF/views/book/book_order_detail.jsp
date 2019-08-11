<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<html>
<head>
	 <link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/jquery.dataTables.css'/>">
<link rel="stylesheet"
	href="<c:url value='/resources/assets/admin/css/buttons.dataTables.min.css'/>">
	<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/dataTable/responsive.dataTables.css'/>">
	<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/dataTable/dataTables.bootstrap.css'/>">
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
 <div class="container">   
 <header id="admin-header" class="header">

            <div class="header-menu">

                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks" style="margin-top: 11px;"></i></a>
                   
                </div>
            </div>

        </header><!-- /header -->  
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
							<li class="active"><a href="<c:url value='/book/student_book_orderList.htm' />">Book Order List</a></li>
						</ol>
					</div>
				</div>
			</div>
		</div>     
		<div class="col-sm-12">
				<div class="row" style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px;margin-top:5px;">
						
				<div class="form-group">
				
				<div class="col-sm-12">Student Name: <h4>${orderDetail.studentName }</h4></div>
				</div>
				<div class="form-group">
				
				<div class="col-sm-12">Invoice No: <h4>${orderDetail.invoiceNo }</h4></div>
				</div>
				</div>
		</div>
	
		<div class="col-sm-12">
		<div class="row"
				style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px;margin-top:5px;">
			<table id="example" class="table display" style="width: 100%;">
        <thead style="background-color: #009688b8;">
            <tr>
            	<th>#</th>
            	 <th>Book Name</th>
                <th>Qty</th>
                <th>Price</th>
                <th>Available</th>
                <th>Message</th>
                <th>Reply</th>
            </tr>
            
        </thead>
        <tbody>
          <c:forEach items="${orderDetail.orderItemList}" var="item" varStatus="row">
							<tr>
								<td>${row.count}</td>
								<td class="hidden-480">${item.name}</td>
								<td class="hidden-480">${item.qty}</td>
								<td class="hidden-480">${item.price}</td>
								<td class="hidden-480"><label id="status${item.id}">${item.status}</label></td>
								<td class="hidden-480"><label id="msg${item.id}">${item.message}</label></td>
								<td><button onclick="showModal(this,${item.id})" >Reply</button></td>
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
                
            </tr>
        </tfoot>
    </table>
   </div>
   
  </div>
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog modal-notify modal-warning" role="document">
    <!--Content-->
    <div class="modal-content">
        <!--Header-->
        <div class="modal-header" style="background-color:#eee;">
            <p class="heading lead" style="color:white;">Book Available</p>
   <button type="button" class="close" id="closeModal" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true" class="white-text">&times;</span>
            </button>
        </div>
		<div class="modal-body">
		<div class="container-fluid">
		<div class="row">
			
				<label class="col-sm-3">Available</label>
				<div class="col-sm-9">
					<input type="checkbox" id="status" value="true" class="form-control" />
				</div>
		</div>
		<div class="row">
		<label class="col-sm-3">Message</label>
				<div class="col-sm-9">
					<textarea id="message" rows="5" class="form-control"></textarea>
				</div>
		
		</div>	
			
		</div>
		</div>
        <!--Footer-->
        <div class="modal-footer justify-content-center" style="background-color:#f4433617;">
        <input type="hidden" id="hiddenId" />
           <!--  <div  class="btn btn-success waves-effect wid" style="border-color: #009688;margin-right: 10px;" onclick="deleteNews(this);">OK</div>
            <div class="btn btn-danger waves-effect wid" data-dismiss="modal">Cancel</div> -->
            <input type="button" value="Post" id="postReply" />
        </div>
    </div>
    <!--/.Content-->
</div>
</div>
</div>
  </div>
<script
		src="<c:url value='/resources/assets/admin/js/jquery-3.3.1.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/jquery.dataTables.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/dataTables.select.min.js'/>"></script>


	<script
		src="<c:url value='/resources/assets/admin/js/dataTables.buttons.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/buttons.flash.min.js'/>"></script>
	<script src="<c:url value='/resources/assets/admin/js/jszip.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/pdfmake.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/buttons.html5.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/buttons.print.min.js'/>"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
<script type="text/javascript">
var contextUrl=$("#pageContext").val();
	$(document).ready(function() {
	
	    $('#example').DataTable( {
	        dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
	    } );
	    
	    $("#postReply").click(function(){
	    	var bid=$("#hiddenId").val();
	    	 var formData = {
	    	            "message" : $("#message").val(),
	    	            "id":$("#hiddenId").val(),
	    	            "status":$("#status").is(":checked")
	    	    }
	    	 alert(JSON.stringify(formData)+" "+contextUrl);
	    	$.ajax({
				contentType : 'application/json; charset=utf-8',
				type : "POST",
				url : contextUrl+"/book/postOrderStatus",
				dataType : 'json',
				data:JSON.stringify(formData),
				success : function(data){
					$('#closeModal').trigger('click');
					
				},
				complete :function(){
				$("#msg"+bid).html( $("#message").val());
				$("#status"+bid).html( $("#status").is(":checked"));
					
					//$(btn).attr("data-target","#myModal");
					//$("#myModal").modal();
				}
			});
	    	
	    	
	    });
	} );
	function showModal(btn,id)
	{
		$("#hiddenId").val(id);
		$(btn).attr("data-toggle","modal");
		$(btn).attr("data-target","#myModal");
		
	
	}
    </script>
</body>
</html>