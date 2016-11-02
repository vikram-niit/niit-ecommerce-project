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
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.shoppingcart.Employee;
import com.niit.shoppingcart.dao.EmployeeDao;
import com.niit.shoppingcart.dao.ProductDao;
import com.niit.shoppingcart.dao.UserDao;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Configuration
@ComponentScan(basePackages = "com.niit.shoppingcart")
@EnableTransactionManagement
@EnableWebMvc
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
   // properties.put("hibernate.hbm2ddl.auto", "create");
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
    
@Autowired
@Bean(name="EmployeeDao")
public EmployeeDao getEmployeeDao(HibernateTemplate template){		
	
	return new EmployeeDao(template);
}

@Autowired
@Bean(name="ProductDao")
public ProductDao getProductDao(HibernateTemplate template){		
	
	return new ProductDao(template);
}

@Autowired
@Bean(name="UserDao")
public UserDao getUserDao(HibernateTemplate template){		
	
	return new UserDao(template);
}

}