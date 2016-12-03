package com.niit.shoppingcartfrontend.config;

import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.js.ajax.AjaxUrlBasedViewResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;
import org.springframework.webflow.mvc.view.FlowAjaxTilesView;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.extras.tiles2.dialect.TilesDialect;
import org.thymeleaf.extras.tiles2.spring4.web.configurer.ThymeleafTilesConfigurer;
import org.thymeleaf.extras.tiles2.spring4.web.view.FlowAjaxThymeleafTilesView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.AjaxThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.niit")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private WebFlowConfig webFlowConfig;

	@Bean(name="flows")
	public CheckoutFlowHandler handler(){
		return new CheckoutFlowHandler();
	}
	
	
	@Bean
	public ViewResolver viewResolver2(){
		UrlBasedViewResolver resolver = 
				new UrlBasedViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/flows/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(4);
		
		return resolver;
	}
	
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = 
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		
		return resolver;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/intro").setViewName("intro");
		registry.addViewController("/login");
		registry.addViewController("/logoutSuccess");
		registry.addViewController("/home2").setViewName("home2");
		registry.addViewController("/home3").setViewName("home3");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/", "/",
				"classpath:/META-INF/web-resources/");
	}
	
	@Bean
	public FlowHandlerMapping flowHandlerMapping() {
		FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
		//handlerMapping.setOrder(-1);
		handlerMapping.setOrder(2);
		handlerMapping.setFlowRegistry(this.webFlowConfig.flowRegistry());
		return handlerMapping;
	}

	@Bean
	public FlowHandlerAdapter flowHandlerAdapter() {
		FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
		handlerAdapter.setFlowExecutor(this.webFlowConfig.flowExecutor());
		handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
		return handlerAdapter;
	}
	
	/*@Bean
	public TilesConfigurer tilesConfigurer3() {
		TilesConfigurer configurer = new TilesConfigurer();*/
	//	configurer.setDefinitions("/WEB-INF/**/views.xml");
	//	return configurer;
	//}
	/*
	@Bean 
	public AjaxUrlBasedViewResolver tilesViewResolver3(){
		AjaxUrlBasedViewResolver tilesViewResolver = new AjaxUrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		tilesViewResolver.setOrder(-1);
		Properties props = new Properties();
		props.put("viewClass", FlowAjaxTilesView.class);
		tilesViewResolver.setAttributes(props);
		
		return new AjaxUrlBasedViewResolver();
		
		
	}
*/
	
	/*@Bean
	public AjaxThymeleafViewResolver tilesViewResolver() {
		AjaxThymeleafViewResolver viewResolver = new AjaxThymeleafViewResolver();
		viewResolver.setViewClass(FlowAjaxThymeleafTilesView.class);
		viewResolver.setTemplateEngine(templateEngine());
		//viewResolver.setOrder(-1);
		viewResolver.setOrder(1);
		
		return viewResolver;
	}
	*/
	/*@Bean
	public AjaxUrlBasedViewResolver tilesViewResolver2() {
		AjaxUrlBasedViewResolver viewResolver = new AjaxUrlBasedViewResolver();
		viewResolver.setViewClass(FlowAjaxTilesView.class);
		viewResolver.setPrefix("/WEB-INF/");
		//viewResolver.setOrder(-1);
		viewResolver.setOrder(2);
		
		return viewResolver;
	}
*/
	/*@Bean
	public SpringTemplateEngine templateEngine(){

		Set<IDialect> dialects = new LinkedHashSet<IDialect>();
		dialects.add(new TilesDialect());
		dialects.add(new SpringSecurityDialect());
		dialects.add(new ConditionalCommentsDialect());

		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setAdditionalDialects(dialects);
		return templateEngine;
	}

	@Bean
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/");
		//templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}
*/
	//@Bean
	//public ThymeleafTilesConfigurer tilesConfigurer() {
	//	ThymeleafTilesConfigurer configurer = new ThymeleafTilesConfigurer();
	//	configurer.setDefinitions("/WEB-INF/**/views.xml");
	//	return configurer;
	//}
	
	//@Bean
	//public TilesConfigurer tilesConfigurer2() {
	//	TilesConfigurer configurer = new TilesConfigurer();
	//	configurer.setDefinitions("/WEB-INF/**/views.xml");
	//	return configurer;
	//}
	
}
