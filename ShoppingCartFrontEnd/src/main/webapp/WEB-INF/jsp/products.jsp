<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Table styles -->
<style>
table, th, td{
 
 border:1px solid black;
font-family: "Trebuchet MS", Arial, Helvetica, sans-serif; } 
 
 th,td{
 border-bottom:1px solid #ddd;
 }
 
 
 table{
 width:100%;
 border:none;
 }
 
 th{
 	height:50px;
 }
 
 
 th, td{
 text-align:left;
 padding:15px;
 
 }
 tr:hover {background-color: #f5f5f5}
 
 th {
    background-color: #4CAF50;
    color: white;
}

caption {
    caption-side: bottom;
    text-align:center;
}

img{
width:100%;
height:400px;
}
<!-- End of Table styles -->

<!--  Search Box styles -->
input[type="text""]:before{
position:relative;

}
 #searchBox{
 padding:20px;
 }
 
 table {border-collapse:separate;border-spacing:0;}
 
<!--  End of Search Box styles -->
</style>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
</head>
<body>


<!-- List products -->
		<table class="table">
		<c:forEach items="${products }" var="product">
				<tr>
				
				<td>
					<img alt="/resources/img/electronicDevices/2.jpg" src='<c:url value="/resources/uploadedImages/${product.id}.jpg"></c:url>'/>
				
					
				</td>
				<td>
						<div class="span-5">
				    
							        <h3>${product.name}</h3>
							        
							        <address>
							            <span>Thyme Square, 13</span>
							            <br />
							            <span>${product.description}Icetown</span>, 
							            <span >North Pole</span>, 
							            <span>0W</span>
							            <br />
							            <span>Earth</span>
							            <span>${product.price }</span>
							        </address>
				
				
										<strong><c:out value="${product.name }"/></strong>
											<span>Price:</span><strong><c:out value="${product.price }"/></strong>
										
										<c:url value="/flows" var="flowUrl"/>
										<c:choose>
											<c:when test="${displayAddToCartButton}">
												<form id="step2" action="${flowExecutionUrl}" method="POST">
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
														<button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
														<button id="previous" type="submit" name="_eventId_next">&lt;&lt; Add to cart</button>
														<button id="finish" type="submit" name="_eventId_finish">Finish &gt;&gt;</button>
														<input type="hidden" name="id" value="${product.id }"/>
												</form>													
											</c:when>
											<c:otherwise>												
												<div><!-- <a class="btn btn-danger" href="flows">Buy Product</a></div> -->
												<form id="step2" action="${flowUrl }" method="POST">
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
														<input type="hidden" name="id" value="${product.id }"/>
														
														<button id="previous" type="submit" name="_eventId_next">&lt;&lt; Buy Product</button>
														
												</form>	
											</c:otherwise>
										</c:choose>
										
				    			</div>
				</td>
				
				</tr>
		</c:forEach>
			
		</table>
		<!-- End of List products -->
	
	
	<a href="flows">Start flow</a>
		<!-- <div ng-app="">Angular JS
			<input type="text" ng-model="name"/>
			<input type="text" ng-model="name"/>
			<input type="text" ng-model="name"/>
			<h2>{{name}}</h2>
		</div> -->
		<div ng-app="myApp" ng-controller="customersCtrl"> 

<!-- <table>
  <tr ng-repeat="x in names">
    <td>{{ x.Name }}</td>
    <td>{{ x.Country }}</td>
  </tr>
</table> -->

<div class="form-group has-feedback" id="searchBox">

<input type="text" ng-model="productSearchString" class="form-control"
placeholder="Search Products">
<span class="form-control-feedback">
<i id="filtersubmit" class="fa fa-search"></i>
</span>
</input>
</div>

<!-- <input type="text" ng-model="orderBy" />
 -->
<label>Order By</label>
<select ng-model="selected" ng-init="options[0]" selected="options[0]">  
  <option value="id" selected>ProductId</option>
  <option value="name" >Name</option>
  <option value="category">Category</option>
  <option value="price">Price</option>
</select>

<!-- <div class="form-group has-feedback">   
    <input type="text" class="form-control">
    <span class="form-control-feedback">
        <i class="fa fa-search"></i>
    </span>
</div>
 -->
<div class="table-responsive">
<table class="table">
<caption>Table 1.1 Products</caption>
<tr>
	<th>Product Id</th>
	<th>Name</th>
	<th>Category</th>
	<th>Price</th>
	<th>Brand</th>
	<th>Description</th>
</tr>
  <tr ng-repeat="x in products | filter:productSearchString | 
  orderBy:selected">
    <td>{{ x.id }}</td>
    <td>{{ x.name }}</td>
    <td>{{ x.category }}</td>
    <td>{{ x.price }}</td>
    <td>{{ x.brand }}</td>
    <td>{{ x.description}}</td>
                
  </tr>
</table>
</div>

</div>

<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    //$http.get("http://www.w3schools.com/angular/customers.php")
    $http.get("/ShoppingCartFrontEnd/productList")
    //.then(function (response) {$scope.names = response.data.records;});
    .then(function (response) {$scope.products = response.data.records;});
    //$scope.products = products;
});

/* var products = [
                {
                	id:1,
                	name:"aaaa",
                	category:"xxx",
                	price:1000,
                	brand:"xx",
                	description:"xxx"
                },
                
                {
                	id:1,
                	name:"xxxx",
                	category:"xxx",
                	price:3000,
                	brand:"xx",
                	description:"xxx"
                },
                
                {
                	id:1,
                	name:"zzzz",
                	category:"xxx",
                	price:2000,
                	brand:"xx",
                	description:"xxx"
                },
                
                {
                	id:1,
                	name:"ffff",
                	category:"xxx",
                	price:2500,
                	brand:"xx",
                	description:"xxx"
                }
                
                
                
                
                ];
 */


</script>

</body>
</html>