package com.niit.shoppingcart.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserTestCase {

	@Autowired
	UserDAO dao;
	
	@Autowired 
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		dao = (UserDAO) context.getBean("UserDAO");
	}
	
	@Test
	public void getUser() {
		Assert.assertNotNull("Get User", dao.getUserById(1006));
	}
	
	
	/*@Test
	public void createUser(){
		
		int id = 1006;
		User e = new User();
		e.setId(id);
		e.setName("user 20");
		//e.setSalary(60000);
		
		dao.saveUser(e);
		
		Assert.assertNotNull("Get User", dao.getUserById(id));	
	}*/
	
	
	/*@Test
	public void deleteUser(){
		
		int id=1000;
		
		// delete the User
		User temp = dao.getUserById(id);
	//	Assert.assertNotNull("check User exists", temp);
		
		if(temp != null){
			dao.deleteUser(temp);	
			Assert.assertNull("delete User", dao.getUserById(id));
		}		
	}*/
	
	
	
	@Test
	public void updateUser(){
		int id=1006;
		
		// update the User
		User temp = dao.getUserById(id);
		//Assert.assertNotNull("check User exists", temp);
		if(temp != null){
			temp.setName("updatedname2"+id);
			dao.updateUser(temp);
					
			Assert.assertEquals(temp, dao.getUserById(id));
		}
	}


	/*@Test
	public void getUserList() {
		Assert.assertNotNull("Get User", dao.getUsers());
		
		//Assert.assertEquals(10, dao.getUsers().size());
	}
*/
}
