package com.niit.shoppingcartfrontend.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.execution.repository.NoSuchFlowExecutionException;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

public class CheckoutFlowHandler extends AbstractFlowHandler {
	public String handleExecutionOutcome(FlowExecutionOutcome outcome,
										HttpServletRequest request, HttpServletResponse response) {
		System.out.println("In handleExecutionOutcome method");
		System.out.println("AttributeMap="+outcome.getOutput());
		System.out.println("AttributeMap="+outcome.getOutput().get("attribute2").toString());
		System.out.println("order="+outcome.getOutput().get("success"));
		System.out.println("EndstateId="+outcome.getId());
		if (outcome.getId().equals("bookingConfirmed")) {
			return "/booking/show?bookingId=" + outcome.getOutput().get("bookingId");
		} else {
			return "/orderConfirmation";
		}
	}
	
    @Override
    public String handleException(FlowException e, HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("In handleExecution method");
	if (e instanceof NoSuchFlowExecutionException) {
	    return "/manageCategories";
	} else {
	    throw e;
	}
    }
}