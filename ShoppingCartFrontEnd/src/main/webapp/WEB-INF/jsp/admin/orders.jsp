<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>


</head>
<body>
		
		<%-- <h1>Welcome ${user }</h1> --%>
		
		<%-- <ul id="OrderList" class="nav nav-pills" >
			<c:forEach items="${categories }" var="Order">
				<li class="dropdown">
				<!-- <a class="dropdown-toggle" data-toggle="dropdown" href="#"> -->
				<c:out value="${Order.name }"/>
				<!--  --></a>
				<a class="dropdown-toggle" data-toggle="dropdown" href='<c:url value="/admin/addOrder"></c:url>'>
				create
				</a>				
				<a class="dropdown-toggle" data-toggle="dropdown" 
				href='<c:url value="/admin/readOrder/${Order.id}"></c:url>'>
				read			</a>
				<a class="dropdown-toggle" data-toggle="dropdown"
			    href='<c:url value="/admin/updateOrder/${Order.id}"></c:url>'>
				update
				</a>
				<a class="dropdown-toggle" data-toggle="dropdown" 
				href='<c:url value="/admin/deleteOrder/${Order.id}"></c:url>'>
				delete 
				</a>
				
				
				</li>
			</c:forEach>
		</ul> --%>
		
		
		
				<c:if test="${displayOrderDetails }">
     		<table class="table">
     			<tr>
     			<td><strong>Order Id:</strong></td>
     			<td>${Order.orderid }</td>
     			
     			
     			<td><strong>Order Name:</strong></td>
     			<td>${Order.status }</td>     			
     			
     			
     			</tr>
     		</table>
     		
     		
     
    
     		
     		<%-- <div id="displayOrder">
     		<h2>Order ${Order.id }</h2>
  <div class="list-group">
    <a href="#" class="list-group-item active">
      <h4 class="list-group-item-heading">Order Id</h4>
      <p class="list-group-item-text">${Order.id }</p>
    </a>
    <a href="#" class="list-group-item">
      <h4 class="list-group-item-heading">Order Name:</h4>
      <p class="list-group-item-text">${Order.name }</p>
    </a>
    <a href="#" class="list-group-item">
      <h4 class="list-group-item-heading">Order Description:</h4>
      <p class="list-group-item-text">${Order.description }</p>
    </a>
  </div>
  </div> --%>
     </c:if>
		
	 <c:if test="${displayEditOrderForm }">
     <jsp:include page="./editOrder.jsp"></jsp:include>
     </c:if>
     
     <c:if test="${not empty displayErrorMessage }">
     <div class="alert alert-danger">
 <strong><c:out value="${displayErrorMessage }"/></strong>
</div>
     </c:if>
		<table class="table table-bordered">
		<thead>
		            <tr class="info">
		                <th>Order Name</th>		                
		                <th>&nbsp</th>
		                <th>&nbsp</th>    
		                <th>&nbsp</th>
		                <th>&nbsp </th>                    
		            </tr>
        		</thead>
		<c:forEach items="${orders }" var="order">
				
				<tr>
     			<td><strong>Order Id:</strong></td>
     			<td>${order.orderid }</td>
     			
     			
     			<td><strong>Order status:</strong></td>
     			<td>${order.status }</td>     			
     			
     			
     			</tr>
				
				<tr>
				
				<td>
					<a  href='<c:url value="/admin/addOrder"></c:url>'>
				create
				</a>
				</td>
				<td>
					<a 
				href='<c:url value="/admin/readOrder/${order.orderid}"></c:url>'>
				read			</a>
				</td>
				<td>
					<a 
			    href='<c:url value="/admin/updateOrder/${order.orderid}"></c:url>'>
				update
				</a>
				</td>
				<td>
					<a 
				href='<c:url value="/admin/deleteOrder/${order.orderid}"></c:url>'>
				delete 
				</a>
				</td>
				
				</tr>
		</c:forEach>
			
		</table>
	
		
		
		
<c:if test="${displayCreateOrderForm }">
     <jsp:include page="./createOrder.jsp"></jsp:include>
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