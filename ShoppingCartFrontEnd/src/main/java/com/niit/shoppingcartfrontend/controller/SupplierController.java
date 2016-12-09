package com.niit.shoppingcartfrontend.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	ServletContext servletContext;
	
	@Autowired
	SupplierDAO supplierdao;
	
	@Autowired
	Supplier supplier;
	
	@RequestMapping("/admin/manageSuppliers")
	public ModelAndView manageSuppliers(Model model, HttpSession session){		
		
		model.addAttribute("displayManageSuppliersPage", true);
		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/admin/addSupplier")
	public ModelAndView addSupplier(Model model, HttpSession session){		
		
		model.addAttribute("displayManageSuppliersPage", true);
		model.addAttribute("displayCreateSupplierForm", true);
		
		return new ModelAndView("index", "command", new Supplier());
	}
	
	@RequestMapping("/admin/readSupplier/{id}")
	public String readSupplier(@PathVariable int id, Model model, HttpSession session){
				
		model.addAttribute("displayManageSuppliersPage", true);
		
		session.setAttribute("suppliers", supplierdao.getSuppliers());
		servletContext.setAttribute("suppliers", supplierdao.getSuppliers());
		model.addAttribute("supplier", supplierdao.getSupplierById(id));
		model.addAttribute("displaySupplierDetails", true);
		
		return "index";
	}
	
	@RequestMapping("/admin/updateSupplier/{id}")
	public ModelAndView editSupplier(@PathVariable int id, Model model, HttpSession session){
		
		model.addAttribute("displayManageSuppliersPage", true);
		
		supplier.setId(id);
		
		
		session.setAttribute("suppliers", supplierdao.getSuppliers());
		servletContext.setAttribute("suppliers", supplierdao.getSuppliers());
		
		model.addAttribute("displayEditSupplierForm", true);
		return new ModelAndView("index", "command", supplierdao.getSupplierById(id));
		
		
	}
	
	@RequestMapping("/admin/updateSupplier")
	public ModelAndView updateSupplier(@ModelAttribute("supplier") Supplier supplier, Model model, HttpSession session){
		
		System.out.println("In /admin/updateSupplier");
		
		model.addAttribute("displayManageSuppliersPage", true);
		
		supplierdao.updateSupplier(supplier);
		model.addAttribute("displayCreateSupplierForm", false);
		session.setAttribute("suppliers", supplierdao.getSuppliers());
		servletContext.setAttribute("suppliers", supplierdao.getSuppliers());
		return new ModelAndView("index", "command", supplier);
	}
	
	@RequestMapping("/admin/deleteSupplier/{id}")
	public String deleteCategory(@PathVariable int id, Model model, HttpSession session){
		
		model.addAttribute("displayManageSuppliersPage", true);
		
		
		supplier.setId(id);
		try{
			supplierdao.deleteSupplier(supplier);
		}catch(Exception ex){
			System.out.println("Exception occured");
			model.addAttribute("displayErrorMessage", "Exception: cannot delete the specified item");
			return "index";
		}
		
		
		
		session.setAttribute("suppliers", supplierdao.getSuppliers());
		servletContext.setAttribute("suppliers", supplierdao.getSuppliers());
		
		return "index";
	}
	
	@RequestMapping("/admin/saveSupplier")
	public ModelAndView saveCategory(@ModelAttribute("supplier") Supplier supplier, Model model, HttpSession session){		
		Integer id = supplier.getId();
		
		model.addAttribute("displayManageSuppliersPage", true);
		
		if(supplierdao.getSupplierById(id)!=null)
		{
			model.addAttribute("supplierAlreadyExists", true);
			model.addAttribute("displayCreateSupplierForm", true);
			model.addAttribute("displayErrorMessage", "Supplier with specified id already exists");
		}
		else
		{
		supplierdao.saveSupplier(supplier);
		model.addAttribute("displayCreateSupplierForm", false);
		session.setAttribute("suppliers", supplierdao.getSuppliers());
		servletContext.setAttribute("suppliers", supplierdao.getSuppliers());
		}
		return new ModelAndView("index", "command", supplier);
	}
}
