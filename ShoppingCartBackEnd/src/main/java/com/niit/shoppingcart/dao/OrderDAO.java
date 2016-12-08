package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Order;

public interface OrderDAO {

	public void saveOrder(Order order);
	public List<Order> getOrdersByUser(String username);
}
