<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bootstrap Core CSS (location of links modified -->
<link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type=""/>
<!-- Bootstrap Core JavaScript(links modified -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" /> " ></script>

			
				<div id="div2">
				<p class="notice">This is step 1 of the order flow</p>
				<div class="header-content" id="label">Selected Products</div>
				
				<c:forEach items="${order.productList }" var="product">
					<c:out value="${product.name }"></c:out>										
				</c:forEach>
				
				<c:url value="/flows" var="flowURL"/>
			             
				<form:form id="step1"  action="${flowExecutionUrl}" method="POST" >
					
			  
			  		<div>
					<input id="cancel" type="submit" name="_eventId_cancel" value="cancel" class="btn btn-default"/>
						<button id="previous" class="btn btn-default" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
					<input id="next" type="submit" name="_eventId_next" value="next  &gt;&gt;" class="btn btn-default"/>					
					</div>
					
				</form:form>
			</div>
	
