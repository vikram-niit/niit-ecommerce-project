package com.niit.shoppingcartfrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		session.setAttribute("categories", categorydao.getCategories());
		session.setAttribute("displayProductMenu", true);
		session.setAttribute("category", category);
		session.setAttribute("categories", categorydao.getCategories());
		
		/*model.addAttribute("displayProductMenu", true);
		model.addAttribute("category", category);
		model.addAttribute("categories", categorydao.getCategories());*/
		
		model.addAttribute("displayHomePage", true);
		model.addAttribute("loggedin", "true");
		
		
		return "admin/categories";
	}
	
}
