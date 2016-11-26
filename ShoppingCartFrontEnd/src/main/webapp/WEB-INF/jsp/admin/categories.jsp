<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

<style>

ul#categoryList li{

list-style-type:none;

}
/* li,li a{
	font-size:30px;
	font-family:Arial, sans-serif, helvetica;
	
	text-decoration:none;
	margin:20px;	
	
} */

table, td, th{
font-size:20px;
}

td a{

text-decoration:none;
color:blue;
font-style:italic;
}
table{
border: 1px solid black;
width:100%;
}
td{

padding:15px;
border-bottom:1px solid #ddd;
font-size:15px;

}
tr:hover {background-color: #f5f5f5}
tr:nth-child(even) {background-color: #f2f2f2}
h2{
text-align:center;
}

#displayCategory{
margin:20px;
}

</style>
</head>
<body>
		<h2>Manage Categories</h2>
		<%-- <h1>Welcome ${user }</h1> --%>
		
		<%-- <ul id="categoryList" class="nav nav-pills" >
			<c:forEach items="${categories }" var="category">
				<li class="dropdown">
				<!-- <a class="dropdown-toggle" data-toggle="dropdown" href="#"> -->
				<c:out value="${category.name }"/>
				<!--  --></a>
				<a class="dropdown-toggle" data-toggle="dropdown" href='<c:url value="/admin/addCategory"></c:url>'>
				create
				</a>				
				<a class="dropdown-toggle" data-toggle="dropdown" 
				href='<c:url value="/admin/readCategory/${category.id}"></c:url>'>
				read			</a>
				<a class="dropdown-toggle" data-toggle="dropdown"
			    href='<c:url value="/admin/updateCategory/${category.id}"></c:url>'>
				update
				</a>
				<a class="dropdown-toggle" data-toggle="dropdown" 
				href='<c:url value="/admin/deleteCategory/${category.id}"></c:url>'>
				delete 
				</a>
				
				
				</li>
			</c:forEach>
		</ul> --%>
		
		<table>
		<c:forEach items="${categories }" var="category">
				<tr>
				<td>
					<strong><c:out value="${category.name }"/></strong>
				</td>
				<td>
					<a class="btn btn-info" href='<c:url value="/admin/addCategory"></c:url>'>
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
		
		<c:if test="${displayCategoryDetails }">
<%--      		<table class="table">
     			<tr>
     			<td>Category Id:</td>
     			<td>${category.id }</td>
     			</tr>
     			<tr>
     			<td>Category Name:</td>
     			<td>${category.name }</td>
     			</tr>
     			<tr>
     			<td>Category Description:</td>
     			<td>${category.description }</td>
     			</tr>
     		</table> --%>
     		
     		<div id="displayCategory">
     		<h2>Category ${category.id }</h2>
  <div class="list-group">
    <a href="#" class="list-group-item active">
      <h4 class="list-group-item-heading">Category Id</h4>
      <p class="list-group-item-text">${category.id }</p>
    </a>
    <a href="#" class="list-group-item">
      <h4 class="list-group-item-heading">Category Name:</h4>
      <p class="list-group-item-text">${category.name }</p>
    </a>
    <a href="#" class="list-group-item">
      <h4 class="list-group-item-heading">Category Description:</h4>
      <p class="list-group-item-text">${category.description }</p>
    </a>
  </div>
  </div>
     </c:if>
		
		<c:if test="${displayCreateCategoryForm }">
     <jsp:include page="./createCategory.jsp"></jsp:include>
     </c:if>
     
     <c:if test="${displayEditCategoryForm }">
     <jsp:include page="./editCategory.jsp"></jsp:include>
     </c:if>
		
		<%-- <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
    </ul>
  </div>
  
  <c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/><p>
</c:forEach> --%>

<!-- <table>
  <tr>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Savings</th>
  </tr>
  <tr>
    <td>Peter</td>
    <td>Griffin</td>
    <td>$100</td>
  </tr>
  <tr>
    <td>Lois</td>
    <td>Griffin</td>
    <td>$150</td>
  </tr>
  <tr>
    <td>Joe</td>
    <td>Swanson</td>
    <td>$300</td>
  </tr>
  <tr>
    <td>Cleveland</td>
    <td>Brown</td>
    <td>$250</td>
  </tr>
</table> -->


</body>
</html>