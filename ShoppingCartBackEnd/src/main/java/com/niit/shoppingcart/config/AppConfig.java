package com.niit.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.Employee;
import com.niit.shoppingcart.dao.UserDao3;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Order;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.ShippingAddress;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.model.UserRole;

@Configuration
@ComponentScan(basePackages = "com.niit.shoppingcart")
@EnableTransactionManagement
@Component
public class AppConfig {

    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:~/test");
    dataSource.setUsername("sa");
    dataSource.setPassword("");
  
    return dataSource;
    }
    
    
    private Properties getHibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.show_sql", "true");
    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    //properties.put("hibernate.hbm2ddl.auto", "create");
    properties.put("hibernate.hbm2ddl.auto", "update");
   
    return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    sessionBuilder.addProperties(getHibernateProperties());
    /*sessionBuilder.addAnnotatedClasses(Category.class);
    sessionBuilder.addAnnotatedClasses(Supplier.class);
    sessionBuilder.addAnnotatedClasses(User.class);
    sessionBuilder.addAnnotatedClasses(Product.class);*/
    sessionBuilder.addAnnotatedClass(Employee.class);
    sessionBuilder.addAnnotatedClass(Product.class);
    sessionBuilder.addAnnotatedClass(Category.class);
    sessionBuilder.addAnnotatedClasses(Supplier.class);
    sessionBuilder.addAnnotatedClasses(User.class);
    sessionBuilder.addAnnotatedClasses(UserRole.class);
    
    return sessionBuilder.buildSessionFactory();
    }
    
@Autowired
@Bean(name = "transactionManager")
public HibernateTransactionManager getTransactionManager(
SessionFactory sessionFactory) {
HibernateTransactionManager transactionManager = new HibernateTransactionManager(
sessionFactory);

return transactionManager;
}

@Autowired
@Bean(name="template")
@Transactional
public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory){
	return new HibernateTemplate(sessionFactory);
}
    
/*@Autowired
@Bean(name="EmployeeDao")
public EmployeeDao3 getEmployeeDao(HibernateTemplate template){		
	
	return new EmployeeDao3(template);
}*/

/*@Autowired
@Bean(name="ProductDao")
public ProductDao3 getProductDao(HibernateTemplate template){		
	
	return new ProductDao3(template);
}*/

@Autowired
@Bean(name="UserDao")
public UserDao3 getUserDao(HibernateTemplate template){		
	
	return new UserDao3(template);
}

@Bean(name="order")
public Order order(){
	Order order =  new Order();
	order.setShippingAddress(getShippingAddress());
	
	return order;
}

@Bean(name="shippingAddress")
public ShippingAddress getShippingAddress(){
	return new ShippingAddress();
}

}