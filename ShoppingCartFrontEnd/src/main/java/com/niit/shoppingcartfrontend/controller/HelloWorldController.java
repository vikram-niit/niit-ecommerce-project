package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;;


@Controller
public class HelloWorldController {

	@Autowired
	private CategoryDAO dao;
	
	@RequestMapping("/hello")
	public String Hello(){
		
		
		
		List<Category> categories = dao.getCategories();
		
		System.out.println(categories);
		return "hello";
	}
	
	@RequestMapping("/about")
	public String about(Model model){
		
		model.addAttribute("displayAboutPage", true);
		return "index";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model){
		
		model.addAttribute("displayContactPage", true);
		return "index";
	}

}
