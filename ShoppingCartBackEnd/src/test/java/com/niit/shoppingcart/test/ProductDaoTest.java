package com.niit.shoppingcart.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.niit.shoppingcart.Employee;
import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.EmployeeDao3;
import com.niit.shoppingcart.dao.ProductDao3;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

public class ProductDaoTest {

	
	public static void main(String[] args){
		
	AnnotationConfigApplicationContext context = new 
			AnnotationConfigApplicationContext(AppConfig.class);
    
	Category c = new Category();
    c.setId(7);
	
    Product p = new Product();
    p.setId(110);
    p.setName("newProduct");
    p.setCategory(c);
    
    
    
    Employee emp = new Employee();
    emp.setEid(2);
    emp.setName("Hibernatesetname");
    
 /*   Resource r=new ClassPathResource("applicationContext.xml");  
    BeanFactory factory=new XmlBeanFactory(r);  */
      
      HibernateTemplate template=(HibernateTemplate)context.getBean("template");
   /* EmployeeDao dao=(EmployeeDao)factory.getBean("d");*/  
     /* HibernateTransactionManager t = (HibernateTransactionManager) context.getBean("transactionManager");*/
        ProductDao3 dao = (ProductDao3) context.getBean("ProductDao");
       
   //template.setCheckWriteOperations(false);
   //template.save(p);
   dao.saveProduct(p);
      
   List<Product>  list = dao.getProducts();  
    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		p = (Product) iterator.next();
		System.out.println(p);
        
    }
   
   
   EmployeeDao3 empDao = (EmployeeDao3) context.getBean("EmployeeDao");
   
   /* List<Employee> list=new ArrayList<Employee>();  
    list=template.loadAll(Employee.class);  
   */ 
 List<Employee>  list2 = empDao.getEmployees();  
  for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
		Employee employee = (Employee) iterator.next();
		System.out.println(employee);
	}
	}
}

