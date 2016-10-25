package com.niit.shoppingCartFrontEnd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;


@Controller
public class UserController {

	@RequestMapping("/home")
	public String home(Model model){
		model.addAttribute("displayHomePage", true);
		
		return "index";
	}
	@RequestMapping("/LoginForm")
	public String login(Model model){
	
		model.addAttribute("displayLoginPage", true);
		
		return "index";
	}
	
	@RequestMapping("/RegistrationForm")
	public String register(Model model){

		model.addAttribute("displayRegistrationForm", true);
		
		return "index";
	}
}
