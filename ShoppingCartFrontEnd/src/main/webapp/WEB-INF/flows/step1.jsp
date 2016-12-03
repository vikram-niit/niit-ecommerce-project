<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bootstrap Core CSS (location of links modified -->
<link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type=""/>
<!-- Bootstrap Core JavaScript(links modified -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" /> " ></script>
    
<style>
#div1{
margin-top:100px;
margin-right:100px;
margin-left:100px;
margin-bottom:50px;
background:#ecf0f1;

}

#div2{
border-radius:5px;
}

#label{
text-align:center;
}
</style>
    
<div id="embeddedFlow">

<div id="div1">
<div id="div2">
	<!-- <p class="notice">This is step 1 of the embedded flow</p> -->
	<div class="header-content" id="label">Enter Billing Address</div>
	<c:url value="/flows" var="flowURL"/>
             
	<form:form id="step1"  action="${flowExecutionUrl}" method="POST" modelAttribute="shippingAddress">
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
		<!-- <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
		<button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button> -->
		
		<div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Address line1:</label>
    <div class="col-sm-10"> 
      <%-- <form:input type="password" class="form-control" id="pwd" 
      placeholder="Enter password" path="password"/> --%>
       <form:input type="text" class="form-control" id="pwd" 
      placeholder="Enter street name" path="addressline1"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Street:</label>
    <div class="col-sm-10"> 
      <%-- <form:input type="password" class="form-control" id="pwd" 
      placeholder="Enter password" path="password"/> --%>
       <form:input type="password" class="form-control" id="pwd" 
      placeholder="Enter street name" path="street"/>
    </div>
  </div>
		
		    <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Country</label>
    <div class="col-sm-10"> 
      <%-- <form:input class="form-control" id="pwd" placeholder="Enter name"
      	path="username"/> --%>
      	<form:input class="form-control" id="pwd" placeholder="Enter country name"
      	path="country"/>
    </div>
  </div>
  
  	    <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">state:</label>
    <div class="col-sm-10"> 
      <%-- <form:input class="form-control" id="pwd" placeholder="Enter name"
      	path="username"/> --%>
      	<form:input class="form-control" id="pwd" placeholder="Enter state name"
      	path="state"/>
    </div>
  </div>
  
  	    <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">city:</label>
    <div class="col-sm-10"> 
      <%-- <form:input class="form-control" id="pwd" placeholder="Enter name"
      	path="username"/> --%>
      	<form:input class="form-control" id="pwd" placeholder="Enter city name"
      	path="city"/>
    </div>
  </div>
  
    <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">zipcode :</label>
    <div class="col-sm-10"> 
      <%-- <form:input class="form-control" id="pwd" placeholder="Enter name"
      	path="username"/> --%>
      	<form:input class="form-control" id="pwd" placeholder="Enter zip code"
      	path="zipcode"/>
    </div>
  </div>
  
  
  		<div class="form-group">
  		<div class="col-sm-2 col-sm-10">
		<input id="cancel" type="submit" name="_eventId_cancel" value="cancel" class="btn btn-default"/>
		<input id="next" type="submit" name="_eventId_next" value="next" class="btn btn-default"/> &gt;&gt;
		</div>
		</div>
		<!-- <script type="text/javascript">
			Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'next',event:'onclick',formId:'step1',params:{fragments:"body"}}));
			Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'cancel',event:'onclick',formId:'step1',params:{fragments:"body"}}));
		</script> -->
	</form:form>
	</div>
	</div>
</div>