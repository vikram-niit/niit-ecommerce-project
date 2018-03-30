<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head> --%>
<body>
		<h2 id="registrationPageHeading">Edit Category</h2>
		<c:url value="/admin/updateOrder" var="saveURL"/>
               <form:form method="post" action="${saveURL}"
               class="form-horizontal">
               
               <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Order id:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="pwd" placeholder="Enter id"
      	path="orderid" value="${order.orderid }" readonly="true"/>
    </div>
  </div>         
   
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="userid">userid:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="userid" placeholder="Enter userid"
      	path="userid" value="${order.userid }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="total">total:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="total" placeholder="Enter total"
      	path="total" value="${order.total }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="paymentMethod">paymentMethod:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="paymentMethod" placeholder="Enter paymentMethod"
      	path="paymentMethod" value="${order.paymentMethod }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="billingAddress">billingAddress:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="billingAddress" placeholder="Enter billingAddress"
      	path="billingAddress" value="${order.billingAddress }"/>
    </div>
  </div>
  
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="shippingAddress">shippingAddress:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="shippingAddress" placeholder="Enter shippingAddress"
      	path="shippingAddress" value="${order.shippingAddress }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="status">status:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="pwd" placeholder="Enter description"
      	path="status" value="${order.status }"/>
    </div>
  </div>
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Update</button>
    </div>
  </div>
		</form:form>
</body>
<!-- </html> -->