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
		<c:url value="/admin/updateCategory" var="saveURL"/>
               <form:form method="post" action="${saveURL}"
               class="form-horizontal">
               
               <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Category id:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="pwd" placeholder="Enter id"
      	path="id" value="${category.id }" readonly="true"/>
    </div>
  </div>
               
    <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Category name:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="pwd" placeholder="Enter name"
      	path="name"/>
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
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Update</button>
    </div>
  </div>
		</form:form>
</body>
<!-- </html> -->