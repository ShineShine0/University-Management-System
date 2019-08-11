<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="col-lg-12">
			<div class="row" style="border: 1px solid #00bcd4a3; margin-left: 1px; margin-right: 1px;margin-top:5px;">
				<form:form  class="form-horizontal" 
					action="${pageContext.request.contextPath}/admin/search_attendance.htm"
					role="form" method="post" modelAttribute="attendanceDTO">
					<div class="form-group">			
					<div class="col-md-6" style="margin-top: 1px;">										
					<div class="col-md-6" style="margin-top: 1px;">Date:</div>
					<div class="col-md-6" style="margin-top: 10px;">					
								<form:input path="attDateString" placeholder="Date...." required="true" class="form-control" type="date"/>									
					</div>
							
						<div class="col-md-6" style="margin-top: 1px;">
					Class Level:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							
								<form:select path="classLevelId"  class="form-control">
									<form:option value="0">---Class Level---</form:option>
									<c:forEach items="${classLevelList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
								
						
					</div>
					<div class="col-md-6" style="margin-top: 1px;">
					Section:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							
								<form:select path="sectionId" class="form-control" id="sectionId">
									<form:option value="0">---Section---</form:option>
									<c:forEach items="${sectionList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						
					</div>
						<div class="col-md-6" style="margin-top: 1px;">
					Major:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							
								<form:select path="majorId" class="form-control" id="majorId">
									<form:option value="0">---Major---</form:option>
									<c:forEach items="${majorList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
						
					</div>
						
							<div class="col-md-6" style="margin-top: 1px;">
					Subject:
					</div>
					<div class="col-md-6" style="margin-top: 10px;">
							
								<form:select path="subjectId"  class="form-control" id="subjectId">
									<form:option value="0">---Subject--</form:option>
									<c:forEach items="${subjectList}" var="item">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>
					
					</div>
					
					<div class="col-md-6" style="margin-top: 1px;">				
					<div class="col-md-6" style="margin-top: 10px; margin-bottom: 10px;">
						<input type="submit" class="btn btn-sm" value="Search"
								/>
					</div>
					</div>
					</div>
					</div>
					</form:form>
					</div>
					


			</div>
</body>
</html>