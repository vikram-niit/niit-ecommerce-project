package com.niit.shoppingcartfrontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class HomeController {

	@Autowired
	CategoryDAO categorydao;
	
	@Autowired
	SupplierDAO supplierdao;
	
	@Autowired
	Category category;
	
	@Autowired
	Supplier supplier;
	
	@RequestMapping("/")
	public String home(Model model, HttpSession session){
		
		System.out.println("session:"+ session.getValueNames());
		for(String x:session.getValueNames())
			System.out.println(x);
		session.setAttribute("categories", categorydao.getCategories());
		session.setAttribute("displayProductMenu", true);
		session.setAttribute("category", category);
		session.setAttribute("categories", categorydao.getCategories());
		
		/*model.addAttribute("displayProductMenu", true);
		model.addAttribute("category", category);
		model.addAttribute("categories", categorydao.getCategories());*/
		
		model.addAttribute("displayHomePage", true);
		//model.addAttribute("loggedin", "true");
		session.setAttribute("loggedin", true);
		//model.addAttribute("isAdmin", true);
		session.setAttribute("isAdmin", true);
		//model.addAttribute("displayManageCategoriesPage", true);
		
		
				Authentication auth = 
				SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			UserDetails userDetails = (UserDetails)auth.getPrincipal();
			System.out.println("userdetails="+userDetails);
			
			session.setAttribute("userDetails", userDetails);
		}
		
		
		return "index";
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("start of /logout method");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);	
		}
		
		System.out.println("start of /logout method");
		
		return "redirect:/login?logout";
	}
	
	@RequestMapping("/step1")
	public String webflow(Model model, HttpSession session){
		
		System.out.println("session:"+ session.getValueNames());
		for(String x:session.getValueNames())
			System.out.println(x);
		session.setAttribute("categories", categorydao.getCategories());
		session.setAttribute("displayProductMenu", true);
		session.setAttribute("category", category);
		session.setAttribute("categories", categorydao.getCategories());
		
		/*model.addAttribute("displayProductMenu", true);
		model.addAttribute("category", category);
		model.addAttribute("categories", categorydao.getCategories());*/
		
		model.addAttribute("displayHomePage", true);
		model.addAttribute("loggedin", "true");
		
		
		return "step1";
	}
	
	
}
