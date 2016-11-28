package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcartfrontend.util.FileUtil;

@Controller
public class ProductController {

	@Autowired
	ProductDAO dao;
	
	@Autowired
	Product product;

	private String path = "";
	
	@RequestMapping("/admin/manageProducts")
	public ModelAndView manageCategories(Model model, HttpSession session){		
		
		model.addAttribute("displayManageProductsPage", true);
		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/admin/addProduct")
	public ModelAndView addCategory(Model model, HttpSession session){		
		
		model.addAttribute("displayManageProductsPage", true);
		model.addAttribute("displayCreateProductForm", true);
		
		return new ModelAndView("index", "command", new Product());
	}
	
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
	
	@RequestMapping("/admin/saveProduct")
	public ModelAndView saveCategory(Model model, HttpSession session,
			@RequestParam("image") MultipartFile image){		
		
		System.out.println("product="+product);
		System.out.println("file="+image);
		
		FileUtil.upload(path, image, product.getId()+".jpg");
		/*Integer id = category.getId();
		
		model.addAttribute("displayManageCategoriesPage", true);
		
		if(categorydao.getCategoryById(id)!=null)
		{
			model.addAttribute("userAlreadyExists", true);
			model.addAttribute("displayCreateCategoryForm", true);
			model.addAttribute("displayErrorMessage", "Category with specified id already exists");
		}
		else
		{
		categorydao.saveCategory(category);
		model.addAttribute("displayCreateCategoryForm", false);
		session.setAttribute("categories", categorydao.getCategories());
		}*/
		return new ModelAndView("index", "command", product);
	}
}
