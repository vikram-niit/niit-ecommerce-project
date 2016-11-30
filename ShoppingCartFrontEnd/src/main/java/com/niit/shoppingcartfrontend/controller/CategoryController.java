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
public class CategoryController {

	@Autowired
	CategoryDAO categorydao;
	
	@Autowired
	Category category;
	
	@RequestMapping("/admin/manageCategories")
	public ModelAndView manageCategories(Model model, HttpSession session){		
		
		model.addAttribute("displayManageCategoriesPage", true);
		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/admin/addCategory")
	public ModelAndView addCategory(Model model, HttpSession session){		
		
		model.addAttribute("displayManageCategoriesPage", true);
		model.addAttribute("displayCreateCategoryForm", true);
		
		return new ModelAndView("index", "command", new Category());
	}
	
	@RequestMapping("/admin/readCategory/{id}")
	public String readCategory(@PathVariable int id, Model model, HttpSession session){
				
		model.addAttribute("displayManageCategoriesPage", true);
		
		session.setAttribute("categories", categorydao.getCategories());
		model.addAttribute("category", categorydao.getCategoryById(id));
		model.addAttribute("displayCategoryDetails", true);
		
		return "index";
	}
	
	@RequestMapping("/admin/updateCategory/{id}")
	public ModelAndView editCategory(@PathVariable int id, Model model, HttpSession session){
		
		model.addAttribute("displayManageCategoriesPage", true);
		
		category.setId(id);
		
		
		session.setAttribute("categories", categorydao.getCategories());
		
		model.addAttribute("displayEditCategoryForm", true);
		return new ModelAndView("index", "command", categorydao.getCategoryById(id));
		
		
	}
	
	@RequestMapping("/admin/updateCategory")
	public ModelAndView updateCategory(@ModelAttribute("category") Category category, Model model, HttpSession session){		
		
		model.addAttribute("displayManageCategoriesPage", true);
		
		categorydao.updateCategory(category);
		model.addAttribute("displayCreateCategoryForm", false);
		session.setAttribute("categories", categorydao.getCategories());
		return new ModelAndView("index", "command", category);
	}
	
	@RequestMapping("/admin/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id, Model model, HttpSession session){
		
		model.addAttribute("displayManageCategoriesPage", true);
		
		
		category.setId(id);
		try{
			categorydao.deleteCategory(category);
		}catch(Exception ex){
			System.out.println("Exception occured");
			model.addAttribute("displayErrorMessage", "Exception: cannot delete the specified item");
			return "index";
		}
		
		
		
		session.setAttribute("categories", categorydao.getCategories());
		
		return "index";
	}
	
	@RequestMapping("/admin/saveCategory")
	public ModelAndView saveCategory(@ModelAttribute("category") Category category, Model model, HttpSession session){		
		Integer id = category.getId();
		
		model.addAttribute("displayManageCategoriesPage", true);
		
		if(categorydao.getCategoryById(id)!=null)
		{
			model.addAttribute("categoryAlreadyExists", true);
			model.addAttribute("displayCreateCategoryForm", true);
			model.addAttribute("displayErrorMessage", "Category with specified id already exists");
		}
		else
		{
		categorydao.saveCategory(category);
		model.addAttribute("displayCreateCategoryForm", false);
		session.setAttribute("categories", categorydao.getCategories());
		}
		return new ModelAndView("index", "command", category);
	}
}
