package com.niit.shoppingcartfrontend.config;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class CustomViewResolver extends UrlBasedViewResolver{

	@Override
	protected View loadView(String viewName, Locale locale) throws Exception {
		
		AbstractView view = buildView(viewName);
		
		View viewObj = (View) getApplicationContext().getAutowireCapableBeanFactory().initializeBean(view, viewName);
		
		if(viewObj instanceof JstlView)
		{
			JstlView jv = (JstlView)viewObj;
			System.out.println("jstlview="+jv+"beanname= "+jv.getBeanName()+"url="+jv.getUrl());
			
			/*if(!jv.getUrl().contains("/WEB-INF/jsp")){
				System.out.println("inside if");
				return null;
			}*/
			if(jv.getBeanName().indexOf("checkout")!=-1){
				return null;
			}
		}
		
		return viewObj;		
	}
}
