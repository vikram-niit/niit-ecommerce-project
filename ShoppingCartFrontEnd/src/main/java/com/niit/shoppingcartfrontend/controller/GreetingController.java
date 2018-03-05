package com.niit.shoppingcartfrontend.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcartfrontend.hello.Greeting;
import com.niit.shoppingcartfrontend.hello.HelloMessage;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage name) throws InterruptedException{
		Thread.sleep(1000);
		return new Greeting("Hello " + name + "!");
	}
	
	@RequestMapping("/index-websocket")
	public String index(Model model){
		
		model.addAttribute("displayWebSocketsPage", true);
		
		return "indexwebsocket";
	}
}
