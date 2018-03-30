package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.model.Order;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Order;

@Controller
public class OrderController {

	@Autowired
	ServletContext servletContext;
	
	@Autowired
	OrderDAO orderdao;
	
	@Autowired
	Order order;
	
	
	@RequestMapping("/admin/manageOrders")
	public ModelAndView manageOrders(Model model, HttpSession session){		
		
		model.addAttribute("displayManageOrdersPage", true);
		
		return new ModelAndView("index");
	}
	
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
	
	@RequestMapping("/admin/updateOrder/{id}")
	public ModelAndView editOrder(@PathVariable String id, Model model, HttpSession session){
		
		model.addAttribute("displayManageOrdersPage", true);
		
		order.setOrderid(id);
		
		
		session.setAttribute("orders", orderdao.getAllOrders());
		
		model.addAttribute("displayEditOrderForm", true);
		return new ModelAndView("index", "command", orderdao.getOrderById(id));		
	}
	
	@RequestMapping("/admin/updateOrder")
	public ModelAndView updateorder(@ModelAttribute("order") Order order, Model model, HttpSession session){		
		
		model.addAttribute("displayManageOrdersPage", true);
		
		orderdao.updateOrder(order);
		model.addAttribute("displayCreateOrderForm", false);
		session.setAttribute("orders", orderdao.getAllOrders());
		servletContext.setAttribute("orders", orderdao.getAllOrders());
		return new ModelAndView("index", "command", order);
	}
}
