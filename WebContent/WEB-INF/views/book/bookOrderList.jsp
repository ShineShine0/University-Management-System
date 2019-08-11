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
<section class="banner-area relative" id="home" style="margin-top:0px;">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row" style="padding-top: 100px;">
		<div class="col-sm-12" style="padding-right:20px">
		<div class="row"
				style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px;margin-top:5px;">
			<table id="example" class="display" style="width: 100%;">
        <thead style="background-color: #009688b8;">
            <tr>
            	<th>#</th>
                <th>Invoice Number</th>
                <th>Total Price</th>
                <th></th>
            </tr>
            
        </thead>
        <tbody>
          <c:forEach items="${bookOrderList}" var="order" varStatus="row">
							<tr>
								<td>${row.count}</td>
								<td class="hidden-480">${order.invoiceNo}</td>
								<td class="hidden-480">${order.totalPrice}</td>
								<td><button class="btn btn-md" style="color:red" onclick="showModal(this,${order.id})">Details</button></td>
							</tr>
						</c:forEach> 
        </tbody>
        <tfoot>
            <tr>
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
  </div>
  </section>
  
  	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog modal-notify modal-warning" role="document">
    <!--Content-->
    <div class="modal-content">
        <!--Header-->
        <div class="modal-header" style="background-color:#eee;">
            <p class="heading lead" style="color:white;">Order Detail</p>
   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true" class="white-text">&times;</span>
            </button>
        </div>
<div class="modal-body">
<table class="table">
	<thead>
	<tr>
		<th>Item</th>
		<th>Qty</th>
		<th>Price</th>
		<th>Available</th>
		<th>Message</th>
	</tr>
	</thead>
	<tbody  id="orderDetail">
	
	</tbody>
</table>
</div>
        <!--Footer-->
        <div class="modal-footer justify-content-center" style="background-color:#f4433617;">
        <div class="hidden" id="hiddenId"></div>
           <!--  <div  class="btn btn-success waves-effect wid" style="border-color: #009688;margin-right: 10px;" onclick="deleteNews(this);">OK</div>
            <div class="btn btn-danger waves-effect wid" data-dismiss="modal">Cancel</div> -->
        </div>
    </div>
    <!--/.Content-->
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
	} );
	function showModal(btn,id)
	{
		//  $("#orderDetail").find("tr:gt(0)").remove();
		  var str="";	
		$.ajax({
			contentType : 'application/json; charset=utf-8',
			type : "GET",
			url : contextUrl+"/book/getOrderItemList?orderId="+id,
			dataType : 'json',
			success : function(data){
			
				var table = document.getElementById("orderDetail");
				table.innerHTML="";
				  var rowCnt = table.rows.length;
				
				$.each(data, function( key, value ) {
					/* var row = table.insertRow(rowCnt);
					  var cell1 = row.insertCell(0);
					  var cell2 = row.insertCell(1);
					  var cell3 = row.insertCell(2);
					  cell1.innerHTML=value.name;
					  cell2.innerHTML=value.qty;
					  cell3.innerHTML=value.price;
					  */
					  str+="<tr><td>"+value.name+"</td><td>"+value.qty+"</td><td>"+value.price+"</td><td>"+value.status+"</td><td>"+value.message+"</td></tr>";
							  
							  
				});
				
			},
			complete :function(){
			
				$("#orderDetail").append(str);
				$(btn).attr("data-toggle","modal");
				$(btn).attr("data-target","#myModal");
				//$("#myModal").modal();
			}
		});
		
		
		 
	
	}
    </script>
</body>
</html>