<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
img{
height:400px;
width:300px;
}

h3{
text-align:center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<div id="div1">
				<div id="div2">
				
				<div class="header-content" id="label"><h3>Selected Products</h3></div>
				
				<!-- Start of Product List -->
				<c:forEach items="${order.productList }" var="product">
															
				
				
				<table class="table">
     			<tr>     			
     			<td><img id="productImage" alt="Image not available" src='<c:url 
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
		</c:forEach>
		<!-- End of selected Products list -->		
		
				<c:url value="/flows" var="flowURL"/>
			             
				<form:form id="step1"  action="${flowExecutionUrl}" method="POST" >
					
			  
			  	<br/>
  		<span>&nbsp</span>
  		<div class="submit">  		
		<input id="cancel" type="submit" name="_eventId_cancel" value="cancel" class="btn btn-danger"/>
			<button id="previous" class="btn btn-danger" type="submit" name="_eventId_previous">&lt;&lt; Continue Shopping</button>
		<input id="next" type="submit" name="_eventId_next" value="Checkout &gt;&gt;" class="btn btn-danger"> 
		</div>
		
					
					
				</form:form>
			</div>
	</div>
</body>
</html>