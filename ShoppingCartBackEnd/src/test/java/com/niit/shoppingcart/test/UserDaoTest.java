package com.niit.shoppingcart.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.UserDao3;

public class UserDaoTest {

public static void main(String[] args){
		
		
		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(AppConfig.class);
	    
		
	   
	    UserDao3 dao = (UserDao3) context.getBean("UserDao");
	       
	   
	   User user = new User();
	   dao.saveUser(user );
	      
	   	 
	   List<User>  list2 = dao.getUsers();  
	  for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
			User User = (User) iterator.next();
			System.out.println(User);
		}
	}
}
