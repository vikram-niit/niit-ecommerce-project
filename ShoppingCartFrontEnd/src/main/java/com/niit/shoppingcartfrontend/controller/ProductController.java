package com.niit.shoppingcartfrontend.controller;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
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
	
	@Autowired
	CategoryDAO categorydao;
	
	@Autowired
	SupplierDAO supplierdao;
	
	private String path = "";

	private PropertyEditor propertyEditor;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        //binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(Category.class, propertyEditor);
        System.out.println("binder.getRequiredFields()"+binder.getRequiredFields());
        System.out.println("binder.getObjectName()"+binder.getObjectName());
        System.out.println("binder="+binder);
        System.out.println("binder.toString()="+binder.toString());
    }

	
	@RequestMapping("/admin/manageProducts")
	public ModelAndView manageProducts(Model model, HttpSession session){		
		
		model.addAttribute("displayManageProductsPage", true);
		session.setAttribute("categories", categorydao.getCategories());
		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/admin/addProduct")
	public ModelAndView addProduct(Model model, HttpSession session){		
		
		model.addAttribute("displayManageProductsPage", true);
		model.addAttribute("displayCreateProductForm", true);
		//model.addAttribute("category", new Category());
		
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
	
	@RequestMapping("/admin/readProduct/{id}")
	public String readProduct(@PathVariable int id, Model model, HttpSession session){
				
		model.addAttribute("displayManageProductsPage", true);
		
		session.setAttribute("products", productdao.getProducts());
		model.addAttribute("product", productdao.getProductById(id));
		model.addAttribute("displayProductDetails", true);
		
		return "index";
	}
	
	@RequestMapping("/admin/updateProduct/{id}")
	public ModelAndView editProduct(@PathVariable int id, Model model, HttpSession session){
		
		model.addAttribute("displayManageProductsPage", true);
		
		product.setId(id);
		
		
		session.setAttribute("products", productdao.getProducts());
		
		model.addAttribute("displayEditProductForm", true);
		return new ModelAndView("index", "command", productdao.getProductById(id));
		
		
	}
	
	@RequestMapping("/admin/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute("product") Product product			
			,@RequestParam("image") MultipartFile image			
			, Model model
			, HttpSession session	  
			){		
		
		System.out.println("product="+product);
		
		Category category = categorydao.getCategoryByName(product.getCategory().getName());
		Supplier supplier = supplierdao.getSupplierByName(product.getSupplier().getSupplierName());
		product.setCategory(category);
		product.setSupplier(supplier);
		
		/* Image upload*/
		System.out.println("session.getservletcontext().getrealpath="+session.getServletContext().getRealPath("/"));		
		path = session.getServletContext().getRealPath("/");
		path = path.concat("/WEB-INF/resources/uploadedImages");
		FileUtil.upload(path, image, product.getId()+".jpg");
		/*End of image upload*/
		
		model.addAttribute("displayManageProductsPage", true);
		
		productdao.updateProduct(product);
		model.addAttribute("displayEditProductForm", false);
		session.setAttribute("products", productdao.getProducts());
		return new ModelAndView("index", "command", product);
	}
	
	@RequestMapping("/admin/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpSession session){
		
		model.addAttribute("displayManageProductsPage", true);
		
		
		product.setId(id);
		Product p = productdao.getProductById(id);
		try{
			productdao.deleteProduct(p);
		}catch(Exception ex){
			System.out.println("Exception occured");
			model.addAttribute("displayErrorMessage", "Exception: cannot delete the specified item");
			return "index";
		}
		
		
		
		session.setAttribute("products", productdao.getProducts());
		
		return "index";
	}
	
	@RequestMapping("/admin/saveProduct")
	public ModelAndView saveProduct(
			@ModelAttribute("product") Product product
			,@RequestParam("image") MultipartFile image
			//,BindingResult bindingresult
			, Model model, HttpSession session
			
		   /*,@RequestParam("category") Category category*/
			//,@RequestParam ModelMap map
			//@RequestBody String body
			){		
		
		//System.out.println("map="+map);
		System.out.println("product="+product);
		
		Category category = categorydao.getCategoryByName(product.getCategory().getName());
		Supplier supplier = supplierdao.getSupplierByName(product.getSupplier().getSupplierName());
		product.setCategory(category);
		product.setSupplier(supplier);
		//productdao.saveProduct(product);		
		
		//System.out.println("RequestBody="+body);
		
		//System.out.println("file="+image);
		
		/* Image upload*/
		System.out.println("session.getservletcontext().getrealpath="+session.getServletContext().getRealPath("/"));		
		path = session.getServletContext().getRealPath("/");
		path = path.concat("/WEB-INF/resources/uploadedImages");
		FileUtil.upload(path, image, product.getId()+".jpg");
		/*End of image upload*/
		
/*		 default category and suppliers set*/
		/*category.setId(1);
		product.setCategory(category);
		supplier.setId(1);
		product.setSupplier(supplier);*/
	/*	End of set defaults*/
		
		Integer id = product.getId();
		
		model.addAttribute("displayManageProductsPage", true);
		
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
	public String Products(Model model, HttpSession session){
	
	model.addAttribute("displayProductsPage", true);
	List<Product> list = productdao.getProducts();
	System.out.println(list+" list-size="+list.size());
	
	model.addAttribute("products", list);
	//session.setAttribute("products", list);
	
	return "index";
}
	
	@RequestMapping("/getProductsByCategory/{id}")
	public String getProductsByCategory(@PathVariable Integer id, Model model, HttpSession session){
		
		List<Product> productsByCategory = productdao.getProductsByCategory(id);
		model.addAttribute("productsByCategory", productsByCategory);
		model.addAttribute("categoryId", id);
		
		model.addAttribute("displayProductsPage", true);
		
		return "index";
	}
}
