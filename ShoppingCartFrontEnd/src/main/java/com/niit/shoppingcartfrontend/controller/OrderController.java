package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.model.Order;

@Controller
public class OrderController {

	@Autowired
	OrderDAO orderdao;
	
	@RequestMapping("/orderConfirmation")
	public ModelAndView manageCategories(Model model, HttpSession session){		
		
		model.addAttribute("displayOrderConfirmationPage", true);
		String loggedInUsername = "";
		
		/* Sets the userid with the currently logged in user's name */
		Authentication auth = 
				SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			UserDetails userDetails = (UserDetails)auth.getPrincipal();
			loggedInUsername = userDetails.getUsername();
			
		}
		/* End of setting the userid with the currently logged in user's name */	
		
		List<Order> orders = orderdao.getOrdersByUser(loggedInUsername);
		
		System.out.println("Orders="+orders);
		model.addAttribute("orders", orders);
		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/getOrdersByUserId")
	public ModelAndView displayOrders(Model model, HttpSession session){		
		
		model.addAttribute("displayOrderConfirmationPage", true);
		String loggedInUsername = "";
		
		/* Sets the userid with the currently logged in user's name */
		Authentication auth = 
				SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			UserDetails userDetails = (UserDetails)auth.getPrincipal();
			loggedInUsername = userDetails.getUsername();
			
		}
		/* End of setting the userid with the currently logged in user's name */	
		
		List<Order> orders = orderdao.getOrdersByUser(loggedInUsername);
		
		System.out.println("Orders="+orders);
		model.addAttribute("orders", orders);
		
		return new ModelAndView("index");
	}
}
