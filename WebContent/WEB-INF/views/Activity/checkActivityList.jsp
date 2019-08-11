
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	#right-panel{
	width:100%;
	}
</style>
<title>Student View Page</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/submenucss/menu.css'/>" />
</head>
<body>


    <div id="right-panel" class="right-panel">

        <!-- Header-->
        <header id="admin-header" class="header">

            <div class="header-menu">

                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks" style="margin-top: 11px;"></i></a>
                    
                </div>

            </div>

        </header>
        <!-- Header-->

        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Check Activity List</h1>
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
        
        <div class="row"
				style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px;margin-top:5px;">
		<table id="example" class="display" style="width: 100%;">
        <thead style="background-color: #a34bd0b8;">
            <tr>
            	<th>#</th>
                <th>Date</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${activityList}" var="item" varStatus="row">
							<tr>
								<td>${row.count}</td>
								<td class="hidden-480">${item.date}</td>
								<td class="hidden-480">${item.description}</td>
								<td>
									<button class="btn-outline-danger waves-effect" onclick="showDeleteModal(this,'${item.id}');">
										<i class="fa fa-trash-o"></i>
									</button>
									<button class="btn-outline-primary waves-effect" onclick="">
										<i class="fa fa-edit"></i>
									</button>
									
									
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
                </tr>
        </tfoot>
    </table>
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
		
		
		
		
		
			
</script>
</html>