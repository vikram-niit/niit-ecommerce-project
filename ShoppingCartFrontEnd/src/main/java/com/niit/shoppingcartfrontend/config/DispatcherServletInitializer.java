package com.niit.shoppingcartfrontend.config;




import javax.servlet.Filter;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		System.out.println("In DispatcherServletInitializer");
		
		return new Class<?>[] {
			SecurityConfig.class,
			//DataAccessConfig.class,
			WebMvcConfig.class,
			WebFlowConfig.class,
			MultipartFileUploadConfig.class,
			WebSocketConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new HiddenHttpMethodFilter() };
	}

}
