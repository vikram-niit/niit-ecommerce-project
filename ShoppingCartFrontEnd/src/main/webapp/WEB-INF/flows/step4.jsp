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


<div id="div2">
	<!-- <p class="notice">This is step 1 of the embedded flow</p> -->
	<div class="header-content" id="label">Select Payment Method</div>
	<c:url value="/flows" var="flowURL"/>
             
	<form:form id="step1"  action="${flowExecutionUrl}" method="POST" modelAttribute="paymentMethod">
		
  
    <div class="form-group">
    	<label class="control-label col-sm-2" for="pwd">Payment Method</label>
	    <div class="col-sm-10"> 	      
	    <input name="paymentMethod" value="Debit Card"/>
	      <%-- 	<form:radiobutton class="form-control" 	path="paymentMethod"/>
	      		<form:radiobutton class="form-control" 	path="paymentMethod"/>
	      			<form:radiobutton class="form-control" 	path="paymentMethod"/>    --%>		
	      
	    </div>
  	</div>
  
  		<br/>
  		<span>&nbsp</span>
  		<div class="submit">  		
		<input id="cancel" type="submit" name="_eventId_cancel" value="cancel" class="btn btn-danger"/>
			<button id="previous" class="btn btn-danger" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
		<input id="next" type="submit" name="_eventId_next" value="next &gt;&gt;" class="btn btn-danger"> 
		</div>
		
		<!-- <script type="text/javascript">
			Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'next',event:'onclick',formId:'step1',params:{fragments:"body"}}));
			Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'cancel',event:'onclick',formId:'step1',params:{fragments:"body"}}));
		</script> -->
	</form:form>
	</div>
	</div>
