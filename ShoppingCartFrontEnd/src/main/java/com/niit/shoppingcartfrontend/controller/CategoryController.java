package com.niit.shoppingcartfrontend.controller;

import javax.servlet.http.HttpSession;

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
public class CategoryController {

	@Autowired
	CategoryDAO categorydao;
	
	@Autowired
	Category category;
	
	@RequestMapping("/admin/addCategory")
	public ModelAndView addCategory(Model model, HttpSession session){		
		
		model.addAttribute("displayCreateCategoryForm", true);
		return new ModelAndView("admin/categories", "command", new Category());
	}
	
	@RequestMapping("/admin/readCategory/{id}")
	public String readCategory(@PathVariable int id, Model model, HttpSession session){
				
		session.setAttribute("categories", categorydao.getCategories());
		model.addAttribute("category", categorydao.getCategoryById(id));
		model.addAttribute("displayCategoryDetails", true);
		
		return "admin/categories";
	}
	
	@RequestMapping("/admin/updateCategory/{id}")
	public ModelAndView editCategory(@PathVariable int id, Model model, HttpSession session){
		
		category.setId(id);
		
		
		session.setAttribute("categories", categorydao.getCategories());
		
		model.addAttribute("displayEditCategoryForm", true);
		return new ModelAndView("admin/categories", "command", new Category());
		
		
	}
	
	@RequestMapping("/admin/updateCategory")
	public ModelAndView updateCategory(@ModelAttribute("category") Category category, Model model, HttpSession session){		
		
		categorydao.updateCategory(category);
		model.addAttribute("displayCreateCategoryForm", false);
		session.setAttribute("categories", categorydao.getCategories());
		return new ModelAndView("admin/categories", "command", category);
	}
	
	@RequestMapping("/admin/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id, Model model, HttpSession session){
		
		category.setId(id);
		categorydao.deleteCategory(category);
		
		session.setAttribute("categories", categorydao.getCategories());
		
		return "admin/categories";
	}
	
	@RequestMapping("/admin/saveCategory")
	public ModelAndView saveCategory(@ModelAttribute("category") Category category, Model model, HttpSession session){		
		
		categorydao.saveCategory(category);
		model.addAttribute("displayCreateCategoryForm", false);
		session.setAttribute("categories", categorydao.getCategories());
		return new ModelAndView("admin/categories", "command", category);
	}
}
