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
		<h2 id="registrationPageHeading">Edit Product</h2>
		<c:url value="/admin/updateProduct" var="saveURL"/>
               <form:form method="post" action="${saveURL}"
               class="form-horizontal" enctype="multipart/form-data">
               
               <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Product id:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="pwd" placeholder="Enter id"
      	path="id" readonly="true"/>
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Category</label>
    <div class="col-sm-10"> 
     <%--  <form:select path="category.name" class="form-control" id="pwd" placeholder="Enter id"
      	items="${categories}" > --%>
      	 <form:select path="category.name" class="form-control" id="pwd" placeholder="Enter id" >
      	<%-- <form:option value="${null}" label="Select" /> 
      	<form:options items="${categories }">
      		
      	</form:options> --%>
      	
      	<form:option value="-" label="--Please Select"/>
            <form:options items="${categories}" itemValue="name" itemLabel="name"/>
      	</form:select>
    </div>
  </div>
               
        
              <%--  <input name="category" value="${category }"/> --%>
              <%--  <select name="category">
               <c:forEach items="${categories }" var="category">
               		<option value="${category }">${category.name }</option>
               		</c:forEach>
               </select> --%>
        
        <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Supplier</label>
    <div class="col-sm-10"> 
     
      	 <form:select path="supplier.supplierName" class="form-control" id="pwd" placeholder="Enter id" >      	
      	
      	<form:option value="-" label="--Please Select"/>
            <form:options items="${suppliers}" itemValue="supplierName" itemLabel="supplierName"/>
      	</form:select>
    </div>
  </div>
               
    <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Product name:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="pwd" placeholder="Enter name"
      	path="name"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">price:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="pwd" placeholder="Enter price"
      	path="price"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">brand:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="pwd" placeholder="Enter brand"
      	path="brand"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Description:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="pwd" placeholder="Enter description"
      	path="description"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Image:</label>
    <div class="col-sm-10"> 
      <%-- <form:input type="file" class="form-control" id="pwd" placeholder="Upload file"
      	path="image"/> --%>
      	<input type="file" class="form-control" id="pwd" placeholder="Upload file"
      	name="image"/>
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