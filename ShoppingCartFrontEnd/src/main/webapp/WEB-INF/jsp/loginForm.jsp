<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>

h2#registrationPageHeading{
margin-bottom:100px;
}
</style>
</head>
<body>
	 <div class="header-content" id="home">
            <div class="header-content-inner">
            <h2 id="registrationPageHeading">Login Page</h2>
               <form:form method="post" action="login" 
               class="form-horizontal">
               
    <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Name:</label>
    <div class="col-sm-10"> 
      <form:input class="form-control" id="pwd" placeholder="Enter name"
      	path="username"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-10"> 
      <form:input type="password" class="form-control" id="pwd" 
      placeholder="Enter password" path="password"/>
    </div>
  </div>
  
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label><input type="checkbox"> Remember me</label>
      </div>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Login</button>
    </div>
  </div>
</form:form>
            </div>
        </div>
</body>
</html>