package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Order2")
@Component
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	String orderid;
	private String shippingAddress;
	private String billingAddress;
	private String paymentMethod;
	private Integer total;
	private String userid;
	private String status;
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="order_product", joinColumns={@JoinColumn(referencedColumnName="orderid")}
			, inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
	private List<Product> productList;
	
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	
	
	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String Status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Order [shippingAddress=" + shippingAddress + ", billingAddress=" + billingAddress + ", paymentMethod="
				+ paymentMethod + ", total=" + total + ", productList=" + productList + "status=" + status + "]";
	}	 
}
