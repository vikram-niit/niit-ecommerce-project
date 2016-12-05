<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
				
		<!-- Create Supplier -->
		<c:if test="${displayCreateSupplierForm }">
     <jsp:include page="./createSupplier.jsp"></jsp:include>
     </c:if>
     <!-- End of Create Supplier -->
		
		<!-- Edit Supplier -->
		<c:if test="${displayEditSupplierForm }">
     <jsp:include page="./editSupplier.jsp"></jsp:include>
     </c:if>
     <!-- End of Edit Supplier -->
     
     
     
		
		<!-- Read operation(displaying the selected supplier) -->
			<c:if test="${displaySupplierDetails }">
     		<table class="table">
     			<tr>
     			<td><strong>Supplier Id:</strong></td>
     			<td>${supplier.id }</td>
     			
     			
     			<td><strong>Supplier Name:</strong></td>
     			<td>${supplier.supplierName }</td>	
  
     			</tr>
     		</table> 	
     </c:if>
		<!-- End of Read operation(displaying the selected supplier) -->
		
		<c:if test="${not empty displayErrorMessage }">
     <div class="alert alert-danger">
 <strong><c:out value="${displayErrorMessage }"/></strong>
</div>
     </c:if>
		
		<!--  Supplier list -->
		<table class="table table-bordered">
		<thead>
		            <tr class="info">
		                <th>Supplier Name</th>		                
		                <th>&nbsp</th>
		                <th>&nbsp</th>    
		                <th>&nbsp</th>
		                <th>&nbsp </th>                    
		            </tr>
		        </thead>
		<c:forEach items="${suppliers }" var="supplier">
				
				<tr>
				<td>
					<strong><c:out value="${supplier.supplierName }"/></strong>
				</td>
				<td>
					<a  href='<c:url value="/admin/addSupplier"></c:url>'>
				create
				</a>
				</td>
				<td>
					<a 
				href='<c:url value="/admin/readSupplier/${supplier.id}"></c:url>'>
				read			</a>
				</td>
				<td>
					<a 
			    href='<c:url value="/admin/updateSupplier/${supplier.id}"></c:url>'>
				update
				</a>
				</td>
				<td>
					<a 
				href='<c:url value="/admin/deleteSupplier/${supplier.id}"></c:url>'>
				delete 
				</a>
				</td>
				
				</tr>
		</c:forEach>
			
		</table>
		<!-- End of Supplier list -->
		
</body>
</html>