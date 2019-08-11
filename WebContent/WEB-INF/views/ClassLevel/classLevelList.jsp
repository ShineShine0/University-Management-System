<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieve Year</title>
</head>
<body>
<div id="content">

<div id="content-header">
<input type="hidden" value="${pageContext.request.contextPath}" id="pageContext">
 <div id="breadcrumb" style="color:gray"> 
 <a href="welcome.htm" title="Go to Home" class="tip-bottom" style="color:white" style="fontsize:large"><b><i class="icon-home"></i> Home</b></a> 
 <a href="firstyear.htm" class="tip-bottom" style="color:white" style="fontsize:large"><b>FIRST YEAR</b></a> 
 <a href="#" class="tip-bottom" style="color:white" style="fontsize:large"><b>LEARNING</b></a> 

</div>
</div>


 
<div class="container-fluid">
  
<div class="row-fluid">
  
<div class="span12">

<div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Year</th>
                  <th>Actions</th>
                  
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${retrieveclasslevel}" var="item">
                <tr class="gradeX">
                  <td>${item.id}</td>
                  <td>${item.name}
                  <td> <a href="<c:url value='/updateClassLevel.htm/${item.id}' />" class="btn btn-info">Edit</a><a href="#" onclick="return confirmDelete('${item.id}');" class="btn btn-info">Delete</a></td>
                     
                </tr>
                </c:forEach>
              
              </tbody>
            </table>
          </div>
</div>


<!--  End Span -->
 </div>
 
 </div>
 </div>
 </div>
 <script>
 
function confirmDelete(id){
var context = $("#pageContext").val();
$.confirm({
    title: 'Confirm!',
    content: 'Simple confirm!',
    buttons: {
        confirm: function () {
           
            window.location=context+'deleteyear.htm/'+ id;
        },
        cancel: function () {
            $.alert('Canceled!');
        },
        somethingElse: {
            text: 'Something else',
            btnClass: 'btn-blue',
            keys: ['enter', 'shift'],
            action: function(){
                $.alert('Something else?');
            }
        }
    }
});

}

 </script>
</body>
</html>