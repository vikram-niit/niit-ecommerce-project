package com.niit.shoppingcartfrontend.config;

import javax.transaction.TransactionManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.persistence.HibernateFlowExecutionListener;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration{

	@Autowired
	private WebMvcConfig webMvcConfig;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	public FlowDefinitionRegistry flowRegistry(){
		return getFlowDefinitionRegistryBuilder()
				.setBasePath("/WEB-INF")				
				.addFlowLocationPattern("/**/flow.xml").build();
	}
	
	@Bean
	public FlowExecutor flowExecutor(){
		/*return getFlowExecutorBuilder(flowRegistry()).build();*/
		
		return getFlowExecutorBuilder(flowRegistry())
				//.addFlowExecutionListener(new SecurityFlowExecutionListener(), "*")
				.addFlowExecutionListener(new HibernateFlowExecutionListener(sessionFactory, transactionManager))
				.build();
				
	}
	
	@Bean
	public FlowBuilderServices flowBuilderServices() {
		return getFlowBuilderServicesBuilder()
				.setViewFactoryCreator(mvcViewFactoryCreator())
				//.setValidator(validator())
				.setDevelopmentMode(true)
				.build();
	}

	@Bean
	public MvcViewFactoryCreator mvcViewFactoryCreator() {
		MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
//		factoryCreator.setViewResolvers(Arrays.<ViewResolver>asList(this.webMvcConfig.tilesViewResolver()));
//		factoryCreator.setViewResolvers(Arrays.<ViewResolver>asList(this.webMvcConfig.tilesViewResolver3()));
		factoryCreator.setUseSpringBeanBinding(true);
		return factoryCreator;
	}

	/*@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}*/
}
