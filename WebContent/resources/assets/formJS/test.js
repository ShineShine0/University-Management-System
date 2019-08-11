/**
 * 
 */
function test(btn) {
	var contextUrl=$("#pageContext").val();
	var name=document.getElementById("name").value;
	//var email=document.getElementById("email").value;
	var roll=document.getElementById("rollNo").value;
	
	var year=$( "#form-year option:selected" ).text();
	if(year=="Choose Year"){
		year="";
	}
	var major="";
	if (document.getElementById('radioCST').checked) {
		   major = document.getElementById('radioCST').value;
		}
	else if (document.getElementById('radioCS').checked) {
		  major = document.getElementById('radioCS').value;
	}else if (document.getElementById('radioCT').checked) {
		  major = document.getElementById('radioCT').value;
	}
	if(name=="" || roll=="" || year=="" || major==""){
		//$(btn).attr("data-dismiss", "modal");
		$(btn).attr("data-toggle", "modal");
		$(btn).attr("data-target", "#deleteModal");
	/*	$(btn).attr("data-dismiss", "modal");
		$(btn).attr("data-toggle", "modal");
		$(btn).attr("data-target", "#myModal");*/
		//alert("Something went wrong please check all field!");
	}
	//alert(name);
	
	else{
	$.ajax({

			contentType : 'application/json; charset=utf-8',
			type : "GET",
			url : contextUrl + "/student/ajax/testStudent",
			dataType : 'json',
			data: {'name':name,
					'roll':roll,
					'major':major,
					'year':year,
			},
			success : function(data) {
				if(data)
					{
					//alert(0);
					//$.post("index.html", );
					/*var form = document.createElement("form");
					form.method = 'post';
					form.action = 'student/createStudent.htm';
					form.submit();*/
					
					//$('<form action="student/createStudent.htm" method="POST"></form>').submit();
					//goURL('student/createStudent.htm','post');
					document.location.href='student/createStudent.htm';
					}
				else{
					$(btn).attr("data-toggle", "modal");
					$(btn).attr("data-target", "#deleteModal");
					
				}
				console.log(data)
			
			},
			complete : function() {
				alert(data);
			}

		});
		
	}
	
}
function testFourm(btn){

	document.location.href='forum/create_forum.htm';
	
}

function checkEmail() {

    var email = document.getElementById('email');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(email.value)) {
    
   email.value="";
  /*  email.focus;*/
    return false;
 }
}
