package com.niit.shoppingcart.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.niit.shoppingcart.Employee;
import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.EmployeeDao3;
import com.niit.shoppingcart.dao.ProductDao3;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

public class Product_SupplierTest {

	public static void main(String[] args){
		
		
		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(AppConfig.class);
	    
		Category c = new Category();
	    c.setId(7);
		
	    Product p = new Product();
	    p.setId(17);
	    p.setName("newProduct");
	    p.setCategory(c);
	    
	    Supplier s1 = new Supplier(1, "s1");
	    Supplier s2 = new Supplier(2, "s2");
	    Supplier s3 = new Supplier(3, "s3");
	    
	    Set<Supplier> suppliers = new HashSet<Supplier>();
	    suppliers.add(s1);
	    suppliers.add(s2);
	    suppliers.add(s3);
	 //  p.setSuppliers(suppliers);
	   
	   
	    ProductDao3 dao = (ProductDao3) context.getBean("ProductDao");
	       
	   
	   dao.saveProduct(p);
	      
	   List<Product>  list = dao.getProducts();  
	    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			p = (Product) iterator.next();
			System.out.println(p);
	  //      System.out.println(p.getSuppliers());
	    }
	   
	   
	   EmployeeDao3 empDao = (EmployeeDao3) context.getBean("EmployeeDao");
	   	 
	   List<Employee>  list2 = empDao.getEmployees();  
	  for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
		}
	}
}
