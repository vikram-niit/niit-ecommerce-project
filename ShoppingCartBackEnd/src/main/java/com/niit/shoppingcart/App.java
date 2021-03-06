package com.niit.shoppingcart;

import java.util.Iterator;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.EmployeeDao3;

public class App {

	private static Employee emp;
	private static Configuration cfg;
    public static void main( String[] args )
    {
    	 Resource r=new ClassPathResource("applicationContext.xml");  
    	    BeanFactory factory=new XmlBeanFactory(r);  
    	    
    	    EmployeeDao3 dao=(EmployeeDao3)factory.getBean("d");  
    	      
    	    Employee e=new Employee();  
    	    e.setEid(3);  
    	    e.setName("hibernatesetname");  
    	    e.setSalary(50000);  
    	      
    	 //   dao.saveEmployee(e);  
          
       List<Employee>  list = dao.getEmployees();  
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println("employee"+employee);
			
		}
    }
}


