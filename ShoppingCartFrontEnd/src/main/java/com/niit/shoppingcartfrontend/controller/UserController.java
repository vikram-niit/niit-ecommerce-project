package com.niit.shoppingcartfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;



@Controller
public class UserController {

	@Autowired
	private UserDAO userdao;
	
	@RequestMapping("/user/home")
	public String home(Model model){
		model.addAttribute("displayHomePage", true);
		
		return "index";
	}
	@RequestMapping("/login")
	public ModelAndView login(Model model){
	
		model.addAttribute("displayLoginPage", true);
		
		return new ModelAndView("index", "command", new User());
	}
	
	@RequestMapping("/log")
	public ModelAndView login2(Model model){
	
		model.addAttribute("displayLoginPage", true);
		
		return new ModelAndView("index", "command", new User());
	}
	
	
	
	@RequestMapping("/RegistrationForm")
	public ModelAndView register(Model model){

		model.addAttribute("displayRegistrationForm", true);
		
		return new ModelAndView("index", "command", new User());
	}
	
	@RequestMapping("/Products")
		public String Products(Model model){
		
		model.addAttribute("displayProductsPage", true);
		return "index";
	}
	
	@RequestMapping(value="/ProductList", produces="application/json")
	public String ProductList(Model model){
		return "json string";
	}
	
	@RequestMapping("/register")
	public String register2(@ModelAttribute("user") User user){
	
		System.out.println(user);
		
		user.setId(3);
		userdao.saveUser(user);
		

		
		/*AnnotationConfigWebApplicationContext context = new 
				AnnotationConfigWebApplicationContext();
	    
		
	    context.refresh();
	    UserDao dao = (UserDao) context.getBean("UserDao");
	       
	   
	
	   dao.saveUser(user );
	      
	   	 
	   List<User>  list2 = dao.getUsers();  
	  for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
			User User = (User) iterator.next();
			System.out.println(User);
		}*/
	
	//model.addAttribute("displayProductsPage", true);
	return "index";
}
	
	/*@RequestMapping("/login")
	public String login2(@RequestParam("email") String email){
	
		System.out.println("email="+email);
	//model.addAttribute("displayProductsPage", true);
	return "index";
}*/
	
	@RequestMapping("/admin/home")
	public String adminHome(Model model){
		//model.addAttribute("displayHomePage", true);
		model.addAttribute("isAdmin", true);
		model.addAttribute("loggedin", "true");
		return "index";
	}
}
