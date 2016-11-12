package com.niit.shoppingcart.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

public class ProductTestCase {

	@Autowired
	ProductDAO dao;
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	SupplierDAO supplierDao;
	
	@Autowired
	Product p;
	
	@Autowired
	Category c;
	
	@Autowired
	Supplier s;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		/*context.refresh();
		context.scan("com.niit.shoppingcart");*/
		
		dao = (ProductDAO) context.getBean("ProductDAO");
		p = (Product) context.getBean(Product.class);
		categoryDao = (CategoryDAO) context.getBean("CategoryDAO");
		c = (Category)context.getBean(Category.class);
		supplierDao = (SupplierDAO)context.getBean("SupplierDAO");
		s = (Supplier) context.getBean(Supplier.class);
		
		c.setId(1);
		categoryDao.saveCategory(c);
		
		s.setId(1);
		supplierDao.saveSupplier(s);
		
		p.setCategory(c);
		p.setSupplier(s);
	}

	/*@Test
	public void getProduct(){
		int id = 111;
		Product temp = dao.getProductById(id);
		
		if(temp==null){
			temp = new Product();
			temp.setId(id);
			temp.setName("product1");
			temp.setCategory(c);
			temp.setSupplier(s);
			dao.saveProduct(temp);
		}
		
		Assert.assertNotNull("Get product id", dao.getProductById(id));
		
		
	}
	
	@Test
	public void createProduct(){
		
		int id = 1001;
		Product temp = dao.getProductById(id);
		
		while(temp!=null)
		{			
			id+=1;
			temp = dao.getProductById(id);
			System.out.println(id);
			System.out.println("temp="+temp);
		}
		
		p.setId(id);
		
		dao.saveProduct(p);
		
		Assert.assertNotNull("Create product", dao.getProductById(id));
	}
	
	@Test
	public void deleteProduct(){
		
		int id=2000;
		
		Product temp = dao.getProductById(id);
		
		if(temp != null){
			dao.deleteProduct(temp);	
			Assert.assertNull("delete Product", dao.getProductById(id));
		}
		else
		{
			// creates a record with the id and then delete
			p.setId(id);
			
			dao.saveProduct(p);
			temp = dao.getProductById(id);
			
			//checks whether record is created before deleting
			Assert.assertNotNull(dao.getProductById(id));
			// deletes the record
			dao.deleteProduct(temp);
			//checks whether record is deleted 
			Assert.assertNull(dao.getProductById(id));
			
		}
	}
	
	@Test
	public void updateProduct(){
		int id=3000;
		
		// update the Product
		Product temp = dao.getProductById(id);
		//Assert.assertNotNull("check Product exists", temp);
		if(temp != null){
			temp.setName("updated name "+id);
			dao.updateProduct(temp);
			
			Assert.assertEquals(temp, dao.getProductById(id));
		}
		else
		{
			// creates a record with the id and then update
			p.setId(id);
			
			dao.saveProduct(p);
			temp = dao.getProductById(id);
			
			//checks whether record is created before deleting
			Assert.assertNotNull(dao.getProductById(id));
			// updates the record
			temp.setName("updated name "+id);
			dao.updateProduct(temp);
			//checks whether record is updated
			Assert.assertEquals(temp, dao.getProductById(id));
		}
	}

	@Test
	public void getProductList() {
		List<Product> list = dao.getProducts();
		System.out.println(list+" list-size="+list.size());
		
		
		Assert.assertNotNull("Get Product", list);
		
		//Assert.assertEquals(10, dao.getProducts().size());
	}*/
}
