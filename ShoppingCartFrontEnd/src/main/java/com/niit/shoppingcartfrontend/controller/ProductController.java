package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDAO dao;
	
	@Autowired
	Product product;
	
	@RequestMapping("/admin/productList")
	public String products(Model model){
		
		List<Product> list = dao.getProducts();
		System.out.println(list+" list-size="+list.size());
		
		model.addAttribute("products", list);
		product = dao.getProductById(1001);
		model.addAttribute("product", product);
		
		System.out.println("Product="+product);
		return "admin/products";
	}
	
}
