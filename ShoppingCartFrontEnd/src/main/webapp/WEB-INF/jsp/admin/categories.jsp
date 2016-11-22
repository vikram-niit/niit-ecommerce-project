<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>

ul#categoryList li{

list-style-type:none;

}
li,li a{
	font-size:30px;
	font-family:Arial, sans-serif, helvetica;
	
	text-decoration:none;
	margin:20px;	
	
}

</style>
</head>
<body>
		<h2>Categories.jsp</h2>	
		<ul id="categoryList" class="nav nav-pills" >
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
		</ul>
		
		<c:if test="${displayCategoryDetails }">
     		<table>
     			<tr>
     			<td>Category Id:</td>
     			<td>${category.id }</td>
     			</tr>
     			<tr>
     			<td>Category Id:</td>
     			<td>${category.name }</td>
     			</tr>
     			<tr>
     			<td>Category Id:</td>
     			<td>${category.description }</td>
     			</tr>
     		</table>
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
</body>
</html>