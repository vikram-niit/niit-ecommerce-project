<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="embeddedFlow">
	<p class="notice">This is step 3 of the embedded flow</p>
	
	 <div class="span-5">
    
        <h3>${order.shippingAddress}</h3>
        <div>${order }</div>
        <address>
            <span>Thyme Square, 13</span>
            <br />
            <span>${order.shippingAddress.street }Icetown</span>, 
            <span >North Pole</span>, 
            <span>0W</span>
            <br />
            <span>Earth</span>
        </address>

    </div>
	<form id="step2" action="${flowExecutionUrl}" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
		<button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
		<button id="finish" type="submit" name="_eventId_finish">Finish &gt;&gt;</button>
		
	</form>
</div>