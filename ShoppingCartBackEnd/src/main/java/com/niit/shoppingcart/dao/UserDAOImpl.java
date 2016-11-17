package com.niit.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.model.UserRole;

@Transactional
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private HibernateTemplate template;

		
	public void saveUser(User user) {
		try {						
			template.save(user);
			
			UserRole u = new UserRole();
			u.setUser(user);
			u.setAuthority("ROLE_USER");
			template.save(u);
			
			
		} catch (HibernateException e) {
			System.out.println(e);
		}			
	}

	public User getUserById(int id) {
		User user = null;
		try {
			user = template.get(User.class, id);		
			
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return user;		
	}

	public void updateUser(User user) {
		
		try {
			template.update(user);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		
	}

	public void deleteUser(User user) {
		try {
			template.delete(user);
		} catch (HibernateException ex) {
			System.out.println(ex);
		}		
	}

	public List<User> getUsers() {
		
		List<User> list = null;
		try {
			list = template.loadAll(User.class);
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return list;
	}

}
