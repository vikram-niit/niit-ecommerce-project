<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="embeddedFlow">
	<p class="notice">This is step 1 of the embedded flow</p>
	<c:url value="/flows" var="flowURL"/>
             
	<form id="step1"  action="${flowExecutionUrl}" method="POST">
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
		<!-- <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
		<button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button> -->
		
		<input id="cancel" type="submit" name="_eventId_cancel"/>Cancel
		<input id="next" type="submit" name="_eventId_next"/>Next &gt;&gt;
		
		<!-- <script type="text/javascript">
			Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'next',event:'onclick',formId:'step1',params:{fragments:"body"}}));
			Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'cancel',event:'onclick',formId:'step1',params:{fragments:"body"}}));
		</script> -->
	</form>
</div>