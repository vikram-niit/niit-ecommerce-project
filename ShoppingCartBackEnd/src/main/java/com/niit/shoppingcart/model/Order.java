package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShippingAddress shippingAddress;
	private BillingAddress billingAddress;
	private String paymentMethod;
	
	

	private List<Product> productList;
	
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Order [shippingAddress=" + shippingAddress + ", billingAddress=" + billingAddress + ", paymentMethod="
				+ paymentMethod + ", productList=" + productList + "]";
	}
 
}
