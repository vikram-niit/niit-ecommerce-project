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
import com.niit.shoppingcart.dao.EmployeeDAO;
import com.niit.shoppingcart.dao.EmployeeDao3;

/**
 * Hello world!
 *
 */
public class App2 
{
	
	
	private static Employee emp;
	
    public static void main( String[] args )
    {
    	
        AnnotationConfigApplicationContext context = new 
    			AnnotationConfigApplicationContext(AppConfig.class);
        
        // Create new employee object
        Employee emp = new Employee();
        emp.setEid(119);
        emp.setName("spring-hibernate4");
        emp.setSalary(50000);
       
        context.scan("com.niit.shoppingcart");
        
        emp = (Employee)context.getBean("employee");
        
        EmployeeDAO empDAO = (EmployeeDAO) context.getBean("EmployeeDAO");
        System.out.println("empDAO="+empDAO);  
      
        EmployeeDao3 dao = (EmployeeDao3) context.getBean("EmployeeDao");
        dao.saveEmployee(emp);
         
        List<Employee>  list = dao.getEmployees();  
        
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
			
		}
    }
    
    
}
