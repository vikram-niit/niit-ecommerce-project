<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
width:500px;
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
 
 
 
 .productDetails{
 margin-bottom:50px !important;
 }
<!--  End of Search Box styles -->
</style>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>


<div>
<c:choose>
	<c:when test="${not empty productsByCategory }">
		<!-- List products by Category -->

		<ul id="productList">
		<c:forEach items="${productsByCategory }" var="product">
				<li>
				
				<ul>
				<li style="diplay:inline;">
					<img alt="No image available" src='<c:url value="/resources/uploadedImages/${product.id}.jpg"></c:url>'/>
				</li>
					
				
				<li style="display:inline;">
						<div class="span-5 productDetails">
				    
							        <h3>${product.name}</h3>
							        
							        <address>
							            <span>Thyme Square, 13</span>
							            <br />
							            <span>${product.description}Icetown</span>, 
							            <span >North Pole</span>, 
							            <span>0W</span>
							            <br />
							            <span>Earth</span><br/>
							          <span>Price:</span><strong><c:out value="${product.price }"/></strong>
							        </address>
				
				
										
											
										
										<c:url value="/flows" var="flowUrl"/>
										<c:choose>
											<c:when test="${displayAddToCartButton}">
												<form id="step2" action="${flowExecutionUrl}" method="POST">
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
														<button id="cancel" class="btn btn-danger" type="submit" name="_eventId_cancel">Cancel</button>
														<button id="previous" class="btn btn-danger" type="submit" name="_eventId_next"> Add to cart&gt;&gt;</button>														
														<input type="hidden" name="id" value="${product.id }"/>
													
												</form>													
											</c:when>
											<c:otherwise>												
												<div><!-- <a class="btn btn-danger" href="flows">Buy Product</a></div> -->
												<form id="step2" action="${flowUrl }" method="POST">
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
														<input type="hidden" name="id" value="${product.id }"/>
														
														<button id="previous" class="btn btn-danger" type="submit" name="_eventId_next"> Buy Product&gt;&gt;</button>
														
												</form>	
											</c:otherwise>
										</c:choose>
										
				    			</div>
				    			<br/>
				</li>
				</ul>
				
				<li>
		</c:forEach>
			
		</ul>
	
		<!-- End of List productsByCategory -->
	</c:when>
	<c:otherwise>
		<!-- List products -->		
		<ul>
		<c:forEach items="${products }" var="product">
				<li>
				
				<ul>
				<li style="diplay:inline;">
					<img alt="No Image available" src='<c:url value="/resources/uploadedImages/${product.id}.jpg"></c:url>'/>
				</li>
					
				
				<li style="display:inline;">
						<div class="span-5 productDetails">
				    
							        <h3>${product.name}</h3>
							        
							        <address>
							            <span>Thyme Square, 13</span>
							            <br />
							            <span>${product.description}Icetown</span>, 
							            <span >North Pole</span>, 
							            <span>0W</span>
							            <br />
							            <span>Earth</span><br/>
							          <span>Price:</span><strong><c:out value="${product.price }"/></strong>
							        </address>
				
				
										
											
										
										<c:url value="/flows" var="flowUrl"/>
										<c:choose>
											<c:when test="${displayAddToCartButton}">
												<form id="step2" action="${flowExecutionUrl}" method="POST">
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
														<button id="cancel" class="btn btn-danger" type="submit" name="_eventId_cancel">Cancel</button>
														<button id="previous" class="btn btn-danger" type="submit" name="_eventId_next"> Add to cart&gt;&gt;</button>														
														<input type="hidden" name="id" value="${product.id }"/>
													
												</form>													
											</c:when>
											<c:otherwise>												
												<div><!-- <a class="btn btn-danger" href="flows">Buy Product</a></div> -->
												<form id="step2" action="${flowUrl }" method="POST">
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
														<input type="hidden" name="id" value="${product.id }"/>
														
														<button id="previous" class="btn btn-danger" type="submit" name="_eventId_next"> Buy Product&gt;&gt;</button>
														
												</form>	
											</c:otherwise>
										</c:choose>
										
				    			</div>
				    			<br/>
				</li>
				</ul>
				
				<li>
		</c:forEach>
			
		</ul>		
		<!-- End of List products -->
	</c:otherwise>
</c:choose>
</div>

	
	
	
