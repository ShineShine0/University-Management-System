<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content== "IE=edge "/>
<!-- <meta name="google" value="notranslate" />
		<link rel="shortcut icon" href="/UCS_MONYWA/resources/assets/img/logocu.png" type="icon/image"> -->

   <link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/normalize.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/bootstrap.min.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/font-awesome.min.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/themify-icons.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/flag-icon.min.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/cs-skin-elastic.cs'/>">
   <link rel="stylesheet" href="<c:url value='/resources/assets/admin/scss/style.css'/>">
   <%-- <link rel="stylesheet" href="<c:url value='/resources/assets/admin/scss/style.scss'/>"> --%>
   <link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/lib/vector-map/jqvmap.min.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/assets/admin/css/bootstrap-select.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/assets/css/main.css'/>">
   <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
   <link rel="stylesheet"
	href="<c:url value='/resources/assets/admin/css/jquery.dataTables.css'/>">
<link rel="stylesheet"
	href="<c:url value='/resources/assets/admin/css/buttons.dataTables.min.css'/>">
	<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/dataTable/responsive.dataTables.css'/>">
	<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/dataTable/dataTables.bootstrap.css'/>">
<%-- <link rel="stylesheet" href="<c:url value='/resources/template/css/jquery-confirm.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/template/css/jquery-confirm.min.css'/>" /> --%>
   <script>
        ( function ( $ ) {
            "use strict";

            jQuery( '#vmap' ).vectorMap( {
                map: 'world_en',
                backgroundColor: null,
                color: '#ffffff',
                hoverOpacity: 0.7,
                selectedColor: '#1de9b6',
                enableZoom: true,
                showTooltip: true,
                values: sample_data,
                scaleColors: [ '#1de9b6', '#03a9f5' ],
                normalizeFunction: 'polynomial'
            } );
        } )( jQuery );
    </script>
 
<!--   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
 -->  
 <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script> -->
<script src="<c:url value='/resources/assets/admin/js/vendor/jquery-2.1.4.min.js'/>"></script>
<script src="<c:url value='/resources/assets/admin/js/plugins.js'/>"></script>
<script src="<c:url value='/resources/assets/admin/js/main.js'/>"></script>
<%-- <script src="<c:url value='/resources/assets/admin/js/lib/chart-js/Chart.bundle.js'/>"></script> --%>
<script src="<c:url value='/resources/assets/admin/js/dashboard.js'/>"></script>
<script src="<c:url value='/resources/assets/admin/js/widgets.js'/>"></script>
<script src="<c:url value='/resources/assets/admin/js/lib/vector-map/jquery.vmap.js'/>"></script>
<script src="<c:url value='/resources/assets/admin/js/lib/vector-map/jquery.vmap.min.js'/>"></script>
<script src="<c:url value='/resources/assets/admin/js/lib/vector-map/jquery.vmap.sampledata.js'/>"></script>
<script src="<c:url value='/resources/assets/admin/js/lib/vector-map/country/jquery.vmap.world.js'/>"></script>
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>    
 -->
 <%-- <script src="<c:url value='/resources/assets/admin/formJS/create_course.js'/>"></script>
		<script src="<c:url value='/resources/assets/admin/formJS/data_table.js'/>"></script> --%>

	<script
		src="<c:url value='/resources/assets/admin/js/jquery-3.3.1.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/jquery.dataTables.min.js'/>"></script>
	<script
		src="<c:url value='/resources/assets/admin/js/dataTables.select.min.js'/>"></script>
<%-- 	<script
		src="<c:url value='/resources/assets/admin/formJS/userView.js'/>"></script> --%>

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
 <title>Admin</title>
</head>


 		<div class="main-container ace-save-state" id="main-container">
 			<input type="hidden" id="pageContext" value="<c:url value='/'/>" />
 			
 			<tiles:insertAttribute name="left"></tiles:insertAttribute>
 			<%-- <tiles:insertAttribute name="header" /> --%>
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" />
			
		</div>


</html>