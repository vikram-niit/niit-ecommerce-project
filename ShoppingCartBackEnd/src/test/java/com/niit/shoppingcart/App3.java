package com.niit.shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.EmployeeDao;
import com.niit.shoppingcart.dao.ProductDao;
import com.niit.shoppingcart.model.Product;

public class App3 {

	
	public static void main(String[] args){
		
	AnnotationConfigApplicationContext context = new 
			AnnotationConfigApplicationContext(AppConfig.class);
    
    Product p = new Product();
    p.setId(1);
    p.setName("newProduct");
    
    Employee emp = new Employee();
    emp.setEid(1);
    emp.setName("Hibernatesetname");
    
 /*   Resource r=new ClassPathResource("applicationContext.xml");  
    BeanFactory factory=new XmlBeanFactory(r);  */
      
      HibernateTemplate template=(HibernateTemplate)context.getBean("template");
   /* EmployeeDao dao=(EmployeeDao)factory.getBean("d");*/  
     /* HibernateTransactionManager t = (HibernateTransactionManager) context.getBean("transactionManager");*/
        ProductDao dao = (ProductDao) context.getBean("ProductDao");
       
   template.setCheckWriteOperations(false);
   template.save(p);
 //  dao.saveProduct(p);
      
   /*List<Product>  list = dao.getProducts();  
    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		p = (Product) iterator.next();
		System.out.println(p);
        
    }*/
	}
}
