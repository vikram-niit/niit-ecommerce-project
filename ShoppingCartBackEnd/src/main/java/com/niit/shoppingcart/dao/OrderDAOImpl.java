package com.niit.shoppingcart.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Order;

@Transactional
@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	HibernateTemplate template;
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveOrder(Order order) {
		template.save(order);		
	}

	public List<Order> getOrdersByUser(String userid) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "FROM Order O WHERE O.userid = :userid";
		Query query = session.createQuery(hql);
		query.setParameter("userid",userid);
		List<Order> orders = query.list();
		
		return orders;
			
		
	}

	public List<Order> getAllOrders() {
		List<Order> list = null;
		try {
			list = template.loadAll(Order.class);
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return list;
	}

	public void updateOrder(Order order) {
		try {
			template.update(order);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

	public Order getOrderById(String id) {
		Order order = null;
		try {
			order = template.get(Order.class, id);		
			
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return order;	
	}
	
	
}
