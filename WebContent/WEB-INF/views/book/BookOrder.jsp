<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<link href="<c:url value='/resources/assets/css/aims.css'/>"
	rel="stylesheet">	
<style>
.radio-pink [type="radio"]:checked+label:after {
	border-color: #e91e63;
	background-color: #e91e63;
}
/*Gap*/
.radio-pink-gap [type="radio"].with-gap:checked+label:before {
	border-color: #e91e63;
}

.radio-pink-gap [type="radio"]:checked+label:after {
	border-color: #e91e63;
	background-color: #e91e63;
}
.social-card-header{
    position: relative;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-align: center;
    align-items: center;
    -ms-flex-pack: center;
    justify-content: center;
    height: 96px;
}
.social-card-header i {
    font-size: 32px;
    color:#FFF;
}
.bg-facebook {
    background-color:#3b5998;
}
.text-facebook {
    color:#3b5998;
}
.bg-google-plus{
    background-color:#dd4b39;
}
.text-google-plus {
    color:#dd4b39;
}
.bg-twitter {
    background-color:#1da1f2;
}
.text-twitter {
    color:#1da1f2;
}
.bg-pinterest {
    background-color:#bd081c;
}
.text-pinterest {
    color:#bd081c;
}
.share:hover {
        text-decoration: none;
    opacity: 0.8;
}

/* (for Add to cart) */

i,
span,
p,
h2 {
  font-family: "Lato", sans-serif;
}
section {
  max-width: 1180px;
  margin: 0 auto;
}
h1 {
  font-family: "Lato", sans-serif;
  font-weight: 100;
  text-align: center;
  letter-spacing: 0.5rem;
  text-transform: uppercase;
  margin: 4rem 0 0 0;
}
.list {
  background: #fff;
  display: flex;
  flex-wrap: wrap;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  
}
.list > div {
  width: 200px;
  float: left;
  height: 300px;
  background: #fff;
  margin: 1%;
  position: relative;
}
.product > div {
  text-align: center;
  position: absolute;
  -webkit-transition: all 0.5s;
  -o-transition: all 0.5s;
  transition: all 0.5s;
  bottom: 0;
  height: 0;
  overflow: hidden;
  width: 100%;
  margin: 0 auto;
}
.product:hover > div {
  position: absolute;
  height: 300px;
  background: rgba(255, 255, 255, 0.5);
}
.product > img {
  margin: 0 auto;
  display: block;
  -webkit-transition: all 0.5s;
  -o-transition: all 0.5s;
  transition: all 0.5s;
}
.product:hover > img {
  -webkit-filter: blur(3px);
  filter: blur(3px);
}
.product > div > h2 {
  border-bottom: 1px solid #818181;
  padding: 0 0 1rem;
}
.descr {
  font-size: 0.8rem;
  padding: 2rem;
  line-height: 1.2rem;
}
.product > div > a > p {
  text-transform: uppercase;
  letter-spacing: 2px;
  font-size: 1rem;
  line-height: 2rem;
  background: #000;
  color: #fff;
  position: absolute;
  width: 100%;
  bottom: 0;
  margin: 0 auto !important;
  -webkit-transition: all 0.2s;
  -o-transition: all 0.2s;
  transition: all 0.2s;
}
.product > div > a > p:hover {
  background: linear-gradient(
    to right,
    #ff6a00,
    #ee0979
  );
  bottom: 5px;
  letter-spacing: 4px;
}
 /* for add to card */
 
 table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
  background-color:white;
}

 th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: gray;
}


</style>
<link href="<c:url value='/resources/assets/css/w3.css'/>"
	rel="stylesheet">
	
	
	
<!-- start banner Area -->
<section class="banner-area relative" id="home" style="margin-top:0px;">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row" style="padding-top: 100px;">
		<div class="col-sm-8" style="padding-right:20px">
		<form:form commandName="classDto" action="${pageContext.request.contextPath}/book/searchClassLevelList.htm" method="post">
					<div class="row" style="margin: 2px 2px 10px 2px;border: 1px solid #4285f4;">
					<div class="col-md-6" style="margin-top: 10px;margin-bottom:10px;" >
					<form:select class="browser-default custom-select" path="classLevelId" >
					 <option data-display="">---Filter by year---</option>
					 <c:forEach items="${classLevelList}" var="item">
						<option value="${item.id}">${item.name}</option>
					</c:forEach>
					</form:select>
					<center><button class="btn btn-md" type="submit" style="color:black;" > search</button></center>
			</div>
			</div>
		 </form:form>
		<div class="row" >
			<c:forEach items="${bookList}" var="item">
				<div class="col-sm-3" style="padding-right:20px;margin-bottom:20px;">
			  		<div class="list">
						<div class="product">
							<img src="${item.imagepath}" height="100%" width="100%"/>
						<div><h5 style="border-bottom: 1px dotted #000;">${item.name }</h5>
				          <p style="font-size:35px">${item.price}</p>
				          <p class="descr">${item.author }</b><br>
				          	${item.edition}<br>
				          	${item.qty}<br>
				          	${item.isbn}
				          
				          </p>
						<br>
						<a onclick="addToCart(${item.id},'${item.name}',${item.price})">
							<p>Add to cart</p>
						</a>
						</div>
						</div>
					</div>
		   		</div>
		   </c:forEach>
		   </div>
		   </div>
		   <div class="col-sm-4" style="padding-right:20px">
		   <form:form style="border:3px dotted blue;" commandName="BookDTO" action="${pageContext.request.contextPath}/book/bookOrder.htm" method="post">
		   	<P style="text-align: center;">Order List </P>
		   			<table id="orderDetail" border=1>
		   			
		   				<tr>
		   					<th>No</th>
		   					<th>Item</th>
		   					<th>Quantity</th>
		   					<th>Price</th>
		   					<th></th>
		   				</tr>
		   				<tbody>
		   				
		   				</tbody>
		   				<tfoot>
		   					<tr>
		   						<td></td>
		   						<td></td>
		   						<td>Total</td>
		   						<td><input name="totalPrice" type="text" style='max-width:65px' id="totalPrice" readonly="readonly"></td>
		   						<td></td>
		   					</tr>
		   				</tfoot>
		   				
		   			</table>
		   			
		   		<div style="text-align: center">
		   			<button class="btn btn-md" type="submit" style="color:black;">Order Now </button>
		   			<a href="<c:url value='/book/bookOrderList.htm'/>" class="btn btn-md" style="color:black;"> View Order </a>
		   		</div>
		   		</form:form>
		   </div>
   		</div>
	</div>

	
</section>

<script type="text/javascript">
var totalBookPrice=0;
function showModal(){
	alert(0);
}
function addToCart(id,name,price){
	
	count = $("#count");
	count.html("4");
	myCreateFunction(name,price,id);
}
function myCreateFunction(name,price,id) {
	  var table = document.getElementById("orderDetail");
	  var rowCnt = table.rows.length;
	 
	  var row = table.insertRow(rowCnt-1);
	  var cell1 = row.insertCell(0);
	  var cell2 = row.insertCell(1);
	  var cell3 = row.insertCell(2);
	  var cell4 = row.insertCell(3);
	  var cell5 = row.insertCell(4);
	  var arrayIndex = rowCnt-2;
	  cell1.innerHTML = rowCnt-1;
	  cell2.innerHTML = name+"<input type='hidden' name='order["+arrayIndex+"].bookId' value='"+id+"'>";
	  cell3.innerHTML = "<input type='number' name='order["+arrayIndex+"].qty' value='1' style='max-width:50px;' onchange='reCalculation(this,"+price+")'>";
	  cell4.innerHTML = "<div>"+price+"</div><input type='hidden' name='order["+arrayIndex+"].price' value='"+price+"'>";;
	  cell5.innerHTML = "<i class='fa fa-trash-o btn-outline-danger' onclick='myDeleteFunction(this)'>"; 
	 
	  totalBookPrice +=price;
	  $('#totalPrice').val(totalBookPrice);
	}

	 function myDeleteFunction(cell) {
		 var price = 0;
	  var trows=$(cell).parents('tr');
	 	trows.remove();
	  var table = document.getElementById("orderDetail");
	  var rowCnt = table.rows.length;
	  for(var i=1;i<rowCnt-1;i++){
		 table.rows[i].cells[0].innerHTML=i;
		 price +=parseInt(table.rows[i].cells[3].children[0].innerHTML);
		 var index = i-1;
		 table.rows[i].cells[1].children[0].name="order["+index+"].bookId";
		 table.rows[i].cells[2].children[0].name="order["+index+"].qty";
		 table.rows[i].cells[3].children[1].name="order["+index+"].price";
		
	  }
	  $('#totalPrice').val(price);
	  totalBookPrice = price;
	 }
	 function reCalculation(qty,price){
		var total = 0;
		 var rows=$(qty).closest('tr');
		
		 var  $tds =rows.find("td");
			//alert( rows.length);
		
		 var value =  price * qty.value;
		 $tds[3].children[1].value=value;
		 $tds[3].children[0].innerHTML =value;
		 
		 var table = document.getElementById("orderDetail");
		  var rowCnt = table.rows.length;
		  for(var i=1;i<rowCnt-1;i++){
			  total +=parseInt(table.rows[i].cells[3].children[0].innerHTML);
		  }
		  $('#totalPrice').val(total);
		  totalBookPrice = total;
	 }
</script>
