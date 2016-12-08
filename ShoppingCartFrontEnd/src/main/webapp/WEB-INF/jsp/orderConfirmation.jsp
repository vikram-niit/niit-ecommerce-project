<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<style>

img{
height: 50px;
width: 50px;
}

p#orderDetailsHeader{
text-align:center;
margin-top:20px;
}

h2{
text-align:center;
font-size:20px !important;
display:block !important;
}
</style>
<%-- <div>orders ${orders }</div> --%>
			<h2 class="label label-success">Your order has been confirmed. Your order will be shipped in 2 to 3 business days.</h2>
		
		<p id="orderDetailsHeader">Order details</p>
				<!-- List products -->
		<table class="table table-bordered">
		<thead>
            <tr class="info">
            	<th>Order id</th>
                <th>Billing Address</th>
                <th>Shipping Address</th>
                <th>Payment Method</th>                
                <th>Selected Products</th>
                <th>Total</th>                                       
            </tr>
        </thead>
		
		<c:forEach items="${orders }" var="order">
				<tr>
				<td>
					<c:out value="${order.orderid}"/>
				</td>
				<td>
					<c:out value="${order.billingAddress}"/>
				</td>
				<td>
					<c:out value="${order.shippingAddress }"/>
				</td>
				<td>
					<c:out value="${order.paymentMethod }"/>
				</td>				
				<td>
					<c:forEach items="${order.productList }" var="product">
						<span><img id="productImage" alt="/resources/img/electronicDevices/2.jpg" src='<c:url 
     			value="/resources/uploadedImages/${product.id}.jpg"></c:url>'/>
     			${product.name }<br/>     			
     			$${product.price }<br/><br/>
     			</span>
					</c:forEach>
				<br/>
				</td>
				<td>
					$${order.total }				
				</td>
				
				</tr>
		</c:forEach>
			
		</table>
		<!-- End of List products -->


