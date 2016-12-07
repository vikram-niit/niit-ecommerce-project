package com.niit.shoppingcartfrontend.webflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.Order;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.ShippingAddress;


@Repository(value="orderService")
public class OrderWebFlow implements Serializable{

	/*@Autowired
	private Order order;*/
	
	@Autowired
	ProductDAO productdao;
	
	@Autowired
	OrderDAO orderdao;
	
	@Autowired
	Order order;
	
	private ArrayList<Product> list = new ArrayList<Product>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Order initFlow(){
		//return new Order();
		return order;
	}
	
	public String addShippingAddress(Order order, ShippingAddress shippingAddress){
		System.out.println("Start of addShippingAddress");
		System.out.println("order="+order+"shippingAddress="+shippingAddress);
		order.setShippingAddress(shippingAddress.toString());
		
		System.out.println("End of addShippingAddress");
		
		
		return "success";
	}
	
	public String addBillingAddress(Order order, BillingAddress billingAddress){
		System.out.println("Start of addBillingAddress");
		System.out.println("order="+order+"billingAddress="+billingAddress);
		order.setBillingAddress(billingAddress.toString());
		
		System.out.println("End of addBillingAddress");
		
		
		return "success";
	}
	
	public String addPaymentMethod(Order order, String paymentMethod){
		System.out.println("Start of addPaymentMethod");
		System.out.println("order="+order+"paymentMethod="+paymentMethod);
		order.setPaymentMethod(paymentMethod);
		
		System.out.println("End of addPaymentMethod");
		
		
		return "success";
	}
	
	public Order addProductToCart(Product product){
		System.out.println("Start of addProductToCart method");
		System.out.println("Flow scope product="+product);
		/*System.out.println("productdao="+productdao);
		Product p = productdao.getProductById(8);
		System.out.println("product8="+p);*/
		
		list.add(product);
		order.setProductList(list);
		
		Integer total = 0, price;
		for (Product p : list) {
			System.out.println("price="+p.getPrice());	
			
			if(p.getPrice().equals("") || p.getPrice() == null){
				price = 0;
			}				
			else{
				price = Integer.parseInt(p.getPrice());
			}			
			
			total += price;			
		}
		
		
		order.setTotal(total);
		
		System.out.println("order="+order);
		System.out.println("End of addProductToCart method");
		/*Order o = new Order();
		ShippingAddress s = new ShippingAddress();
		s.setAddressline1("xxx");
		o.setShippingAddress(s);
		o.setProductList(list);*/
		
		
		
		return order;
	}
	
	public String saveOrder(Order order){
		String orderid = UUID.randomUUID().toString();
		Order order2 = new Order();
		
		order2.setOrderid(orderid);
		order2.setBillingAddress(order.getBillingAddress());
		order2.setPaymentMethod(order.getPaymentMethod());
		order2.setShippingAddress(order.getShippingAddress());
		order2.setTotal(order.getTotal());
		order2.setProductList(order.getProductList());
		order2.setUserid(order.getUserid());
		//orderdao.saveOrder(order2);
		
		return "success";
	}
}
