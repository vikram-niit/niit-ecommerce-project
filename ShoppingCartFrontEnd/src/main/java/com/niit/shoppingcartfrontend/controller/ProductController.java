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
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcartfrontend.util.FileUtil;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productdao;
	
	@Autowired
	Product product;

	@Autowired
	Category category;
	
	@Autowired
	Supplier supplier;
	
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
		model.addAttribute("category", new Category());
		
		return new ModelAndView("index", "command", new Product());
	}
	
	@RequestMapping("/admin/productList")
	public String products(Model model){
		
		List<Product> list = productdao.getProducts();
		System.out.println(list+" list-size="+list.size());
		
		model.addAttribute("products", list);
		product = productdao.getProductById(1001);
		model.addAttribute("product", product);
		
		System.out.println("Product="+product);
		return "admin/products";
	}
	
	@RequestMapping("/admin/saveProduct")
	public ModelAndView saveCategory(@ModelAttribute("product") Product product, Model model, HttpSession session,
			@RequestParam("image") MultipartFile image){		
		
		System.out.println("product="+product);
		System.out.println("file="+image);
		
		/* Image upload*/
		System.out.println("session.getservletcontext().getrealpath="+session.getServletContext().getRealPath("/"));
		path = session.getServletContext().getRealPath("/");
		path = path.concat("/WEB-INF/resources/uploadedImages");
		FileUtil.upload(path, image, product.getId()+".jpg");
		/*End of image upload*/
		
		/* default category and suppliers set*/
		category.setId(1);
		product.setCategory(category);
		supplier.setId(1);
		product.setSupplier(supplier);
		/*End of set defaults*/
		
		Integer id = product.getId();
		
		model.addAttribute("displayManageCategoriesPage", true);
		
		if(productdao.getProductById(id)!=null)
		{
			model.addAttribute("productAlreadyExists", true);
			model.addAttribute("displayCreateProductForm", true);
			model.addAttribute("displayErrorMessage", "Product with specified id already exists");
		}
		else
		{
		productdao.saveProduct(product);
		model.addAttribute("displayCreateProductForm", false);
		session.setAttribute("products", productdao.getProducts());
		}
		return new ModelAndView("index", "command", product);
	}
	
	@RequestMapping("/Products")
	public String Products(Model model){
	
	model.addAttribute("displayProductsPage", true);
	List<Product> list = productdao.getProducts();
	System.out.println(list+" list-size="+list.size());
	
	model.addAttribute("products", list);
	
	return "index";
}
}
