<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<div id="div1">
				<div id="div2">
				<p class="notice">This is step 1 of the order flow</p>
				<div class="header-content" id="label">Selected Products</div>
				
				<c:forEach items="${order.productList }" var="product">
					<c:out value="${product.name }"></c:out>										
				</c:forEach>
				
				<c:url value="/flows" var="flowURL"/>
			             
				<form:form id="step1"  action="${flowExecutionUrl}" method="POST" >
					
			  
			  		<div class="form-group">
			  		<div class="col-sm-2 col-sm-10">
					<input id="cancel" type="submit" name="_eventId_cancel" value="cancel" class="btn btn-default"/>
						<button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
					<input id="next" type="submit" name="_eventId_next" value="next" class="btn btn-default"/> &gt;&gt;
					</div>
					</div>
					
				</form:form>
			</div>
	</div>
</body>
</html>