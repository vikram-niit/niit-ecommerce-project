package com.niit.shoppingcartfrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@RequestMapping("/home")
	public String home(HttpSession session){
		
		session.setAttribute("categories", categorydao.getCategories());
		
		return "admin/products";
	}
}
