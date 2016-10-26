package com.niit.shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.EmployeeDao;

/**
 * Hello world!
 *
 */
public class App2 
{
	
	
	private static Employee emp;
	private static Configuration cfg;
    public static void main( String[] args )
    {
    	cfg = new Configuration();
       // cfg.configure("applicationContext.xml");
    	AnnotationConfigApplicationContext context = new 
    			AnnotationConfigApplicationContext(AppConfig.class);
        
        // Create new employee object
        Employee emp = new Employee();
        emp.setEid(11);
        emp.setName("spring-hibernate");
        emp.setSalary(50000);
        
     //   context.scan("com.niit.shoppingcart.model");
        
      //  emp = (Employee)context.getBean("employee");
     /*   Resource r=new ClassPathResource("applicationContext.xml");  
        BeanFactory factory=new XmlBeanFactory(r);  */
          
       //   HibernateTemplate template=(HibernateTemplate)context.getBean("template");
       /* EmployeeDao dao=(EmployeeDao)factory.getBean("d");*/  
         /* HibernateTransactionManager t = (HibernateTransactionManager) context.getBean("transactionManager");*/
          EmployeeDao dao = (EmployeeDao) context.getBean("EmployeeDao");
        
         /* List<Employee> list=new ArrayList<Employee>();  
  	    list=template.loadAll(Employee.class);  
         */ 
       List<Employee>  list = dao.getEmployees();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
			
		}
    }
    
    
}