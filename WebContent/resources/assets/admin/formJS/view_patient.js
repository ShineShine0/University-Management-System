/**
 * 
 */
$(document).ready(function() {
	    $('#example').DataTable( {
	        dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
	    } );
	} );
 function showDeleteModal(btn,id)
 {

 	$(btn).attr("data-toggle", "modal");
 	$(btn).attr("data-target", "#deleteModal");
 	document.getElementById("hiddenId").value=id;
 	
 }

 function deleteNews(btn){
 	var contextUrl = $("#pageContext").val();
 	var id=document.getElementById("hiddenId").value;
 	$(btn).attr("data-dismiss", "modal");
 	//document.location.href='ajax/delete-news';

 	
 	$.ajax({

 		contentType : 'application/json; charset=utf-8',
 		type : "GET",
 		url : contextUrl+ "/admin/ajax/view-patient/"+id,
 		dataType : 'json',
 		success : function(data) {

 			if (data + "" === "true") {
 				
 				document.location.href='view-patient.htm';

 			} else {
 				alert("Cannot Delete");
 			}

 		},
 		complete : function() {
 		}

 	});
 }