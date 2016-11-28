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
		<h2>Manage Products</h2>
		<!-- Create Product -->
		<c:if test="${displayCreateProductForm }">
     <jsp:include page="./createProduct.jsp"></jsp:include>
     </c:if>
		
		<!-- List products -->
		<table>
		<c:forEach items="${categories }" var="category">
				<tr>
				<td>
					<strong><c:out value="${category.name }"/></strong>
				</td>
				<td>
					<a class="btn btn-info" href='<c:url value="/admin/addProduct"></c:url>'>
				create
				</a>
				</td>
				<td>
					<a class="btn btn-info"
				href='<c:url value="/admin/readCategory/${category.id}"></c:url>'>
				read			</a>
				</td>
				<td>
					<a class="btn btn-info"
			    href='<c:url value="/admin/updateCategory/${category.id}"></c:url>'>
				update
				</a>
				</td>
				<td>
					<a class="btn btn-info"
				href='<c:url value="/admin/deleteCategory/${category.id}"></c:url>'>
				delete 
				</a>
				</td>
				
				</tr>
		</c:forEach>
			
		</table>
</body>
</html>