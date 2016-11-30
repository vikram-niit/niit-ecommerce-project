package com.niit.shoppingcartfrontend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MultipartFileUploadConfig {

	@Bean
	public CommonsMultipartResolver multipartResolver(){
		
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxInMemorySize(1048576);
		multipartResolver.setMaxUploadSize(20971520);
		
		return multipartResolver;
	}
}
