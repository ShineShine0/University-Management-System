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
 function transferStudent()
 {
	 var contextUrl=$("#pageContext").val();
	 var userId=$( "#user-id option:selected" ).text();
	 var doctorName=$( "#doctor-name option:selected" ).text();
	 if(userId=="---choose patient's Id---"){
		 userId="";
		}
	 if(doctorName=="---choose doctor---"){
		 doctorName="";
		}
	 if(userId=="" || doctorName=="")
		 {
		 alert("something went wrong");
		 }
	 else{
		 $.ajax({

				contentType : 'application/json; charset=utf-8',
				type : "GET",
				url : contextUrl + "/admin/ajax/transfer-patient/" + userId+"/"+doctorName,
				dataType : 'json',
				success : function(data) {
					if(data){
						document.location.href="transfer.htm";
					}
					else{
						alert("cannot update!!!");
					}
				},
				complete : function() {
				}

			});
	 }
 }