package com.niit.shoppingcartfrontend.webflow;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.Order;
import com.niit.shoppingcart.model.ShippingAddress;

@Component(value="orderwebflow")
public class OrderWebFlow implements Serializable{

	/*@Autowired
	private Order order;*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Order initFlow(){
		return new Order();
	}
	
	public String addShippingAddress(Order order, ShippingAddress shippingAddress){
		System.out.println("Start of addShippingAddress");
		System.out.println("order="+order+"shippingAddress="+shippingAddress);
		order.setShippingAddress(shippingAddress);
		
		System.out.println("End of addShippingAddress");
		
		
		return "success";
	}
}
