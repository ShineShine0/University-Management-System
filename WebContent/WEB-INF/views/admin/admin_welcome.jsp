<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
 
map = new HashMap<Object,Object>(); map.put("label", "First Year"); map.put("y", 75); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Second Year"); map.put("y", 50); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Third Year"); map.put("y", 50); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Fourth Year"); map.put("y", 45); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Fift Year"); map.put("y", 52); list.add(map);

 
String dataPoints = gsonObj.toJson(list);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="X-UA-Compatible" content== "IE=edge "/>
<meta name="google" value="notranslate" />
<style type="text/css">
.card{
border-left: .25rem solid #9c27b0!important;
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
                   
                </div>
            </div>

        </header>

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
                            <li class="active"></li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
  
        <div class="content mt-3">
	
            <div class="col-sm-12">
                <div class="alert  alert-success alert-dismissible fade show" role="alert" style="background-color: #7512e07d;">
                  <span class="badge badge-pill badge-success">Success</span> You successfully read this important alert message.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </div>
          

			
	<div class="row" style="float:left;">
         
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Numbers Of Teachers</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${teacher}</div>
                    </div>
                    <div class="col-auto">
                       <i class="fa fa-user" style="font-size:40px;color:blue"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Numbers Of Subjects</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${subject}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fa fa-book" style="font-size:40px;color:blue"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Numbers Of Students</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${student}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fa fa-user" style="font-size:40px;color:blue"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            
<div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1"> All System Users</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${userCount}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fa fa-user" style="font-size:40px;color:blue"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            
        
        </div>
         
        
     <div id="chartContainer" style="height: 370px; width: 100%;"></div>
     <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
        
 


        
       
    
     </div>
  </div>
</body>
<script type="text/javascript">
window.onload = function() { 
	 
	var chart = new CanvasJS.Chart("chartContainer", {
		animationEnabled: true,
		title:{
			text: "Atttendance get by Semester - 2019"
		},
		legend: {
			verticalAlign: "center",
			horizontalAlign: "right"
		},
		data: [{
			type: "pie",
			showInLegend: true,
			indexLabel: "{y}%",
			indexLabelPlacement: "inside",
			legendText: "{label}: {y}%",
			toolTipContent: "<b>{label}</b>: {y}%",
			dataPoints : <%out.print(dataPoints);%>
		}]
	});
	chart.render();
	 
	}
</script>
</html>