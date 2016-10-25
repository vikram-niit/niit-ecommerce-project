package com.niit.shoppingCartFrontEnd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;


@Controller
public class UserController {

	@RequestMapping("/home")
	public String home(){
		return "index";
	}
	@RequestMapping("/LoginForm")
	public ModelAndView login(Model model){
		
		
		model.addAttribute("displayLoginPage", true);
		ModelAndView mv = new ModelAndView("index",
				"loginModel", model);
		
		return mv;
	}
	
}