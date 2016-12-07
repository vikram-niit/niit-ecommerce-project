package com.niit.shoppingcart.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Order;

@Transactional
@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	HibernateTemplate template;
	
	public void saveOrder(Order order) {
		template.save(order);		
	}
}
