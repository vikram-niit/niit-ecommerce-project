<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

img{
height:300px;
width:250px;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>		
		
		<!-- Display Product details of a specific product -->
		<c:if test="${displayProductDetails }">
     		<table class="table">
     			<tr>     			
     			<td><img id="productImage" alt="/resources/img/electronicDevices/2.jpg" src='<c:url 
     			value="/resources/uploadedImages/${product.id}.jpg"></c:url>'/>
     			</td>
     			<td>
	     					
			     			<strong>Product Id:${product.id }</strong><br/>
			     			
			     			
			     			
			     			
			     			<strong>Product Name:${product.name }</strong><br/>
			     			
			     			
			     			
			     			<strong>Product Description:${product.description }</strong><br/>
			     			
			     			
			     			
			     			
			     			<strong>Product price:${product.price }</strong><br/>	     			
	     					
     			</td>
     			</tr>    			
     			
     		</table>
		</c:if>
		<!-- End of Display Product details of a specific product -->
		
		<!-- Create Product -->
		<c:if test="${displayCreateProductForm }">
     <jsp:include page="./createProduct.jsp"></jsp:include>
     </c:if>
		
		<c:if test="${displayEditProductForm }">
     <jsp:include page="./editProduct.jsp"></jsp:include>
     </c:if>
		
		<!-- List products -->
		<table class="table table-bordered">
		<thead>
            <tr class="info">
                <th>Product Name</th>
                <th>price</th>
                <th>&nbsp</th>
                <th>&nbsp</th>    
                <th>&nbsp</th>
                <th>&nbsp </th>                    
            </tr>
        </thead>
		
		<c:forEach items="${products }" var="product">
				<tr>
				<td>
					<strong><c:out value="${product.name }"/></strong>
				</td>
				<td>
					<strong><c:out value="${product.price }"/></strong>
				</td>
				<td>
					<a href='<c:url value="/admin/addProduct"></c:url>'>
				create
				</a>
				</td>
				<td>
					<a
				href='<c:url value="/admin/readProduct/${product.id}"></c:url>'>
				read			</a>
				</td>
				<td>
					<a
			    href='<c:url value="/admin/updateProduct/${product.id}"></c:url>'>
				update
				</a>
				</td>
				<td>
					<a
				href='<c:url value="/admin/deleteProduct/${product.id}"></c:url>'>
				delete 
				</a>
				</td>
				
				</tr>
		</c:forEach>
			
		</table>
		<!-- End of List products -->
</body>
</html>