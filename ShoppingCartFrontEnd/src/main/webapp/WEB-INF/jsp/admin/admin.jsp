<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/admin.css" />" rel="stylesheet" type="text/css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

<style>



</style>
</head>
<body>
		
		<div id="managelist">
		<ul class="nav nav-pills">
		<li> <a class="list-group-item active" href="<c:url value="/admin/manageCategories" />" >Manage Categories</a></li>
		<li><a href="<c:url value="/admin/manageProducts" />">Manage Products</a></li>
		<li><a href="<c:url value="/admin/manageSuppliers" />">Manage Suppliers</a></li>
		</ul>
		</div>
		
		
		<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">Admin dashboard</h3>
	</div>
	<div class="panel-body">
	
	
		<c:if test="${displayManageCategoriesPage == true }">
			<jsp:include page="categories.jsp"/>
		</c:if>
		
		<c:if test="${displayManageProductsPage == true }">
			<jsp:include page="products.jsp"/>
		</c:if>
		
		<c:if test="${displayManageSuppliersPage == true }">
			<jsp:include page="categories.jsp"/>
		</c:if>
	</div>
</div>
		
</body>
</html>