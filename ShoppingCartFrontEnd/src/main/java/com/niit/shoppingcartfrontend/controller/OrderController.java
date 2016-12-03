package com.niit.shoppingcartfrontend.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class OrderController {


	@RequestMapping("/orderConfirmation")
	public ModelAndView manageCategories(Model model, HttpSession session){		
		
		model.addAttribute("displayOrderConfirmationPage", true);
		
		return new ModelAndView("index");
	}
}
