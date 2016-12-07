<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bootstrap Core CSS (location of links modified -->
<style>
h3{
text-align:center;
}

img{
width:300px;
height:400px;
}
</style>
<link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type=""/>
<!-- Bootstrap Core JavaScript(links modified -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" /> " ></script>
<div id="embeddedFlow">
		<h3>Order Details</h3>
	
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
	
	 <div class="span-5">
    
    
    	
        <h4>Shipping Address</h4>
        <address>
            <span>Thyme Square, 13</span>
            <br />
            <span>${order.shippingAddress }Icetown</span>, 
            <span >North Pole</span>, 
            <span>0W</span>
            <br />
            <span>Earth</span>
        </address>


		<h4>Billing Address</h4>
        <address>
            <span>Thyme Square, 13</span>
            <br />
            <span>${order.billingAddress }Icetown</span>, 
            <span >North Pole</span>, 
            <span>0W</span>
            <br />
            <span>Earth</span>
        </address>
        
        <h4>Payment Method</h4>
        <address>           
            <span>${order.paymentMethod }</span>
        </address>
        
        <h4>Total</h4>
        <address>           
            <span>Total: $</span><span>${order.total }</span>
        </address>
		
    </div>
    <div class="submit">
	<form id="step2" action="${flowExecutionUrl}" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button id="cancel" class="btn btn-danger" type="submit" name="_eventId_cancel">Cancel</button>
		<button id="previous" class="btn btn-danger" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
		<button id="confirm" class="btn btn-danger" type="submit" name="_eventId_finish">Confirm Order &gt;&gt;</button>
		
	</form>
	</div>
</div>