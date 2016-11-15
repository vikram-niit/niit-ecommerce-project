package com.niit.shoppingcartfrontend.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
			.formLogin()
				//.loginPage("/login")
			    .loginPage("/home2")
				//.loginProcessingUrl("/loginProcess")
			    //.loginProcessingUrl("/login")
				.defaultSuccessUrl("/home3")
				.failureUrl("/home2")
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logoutSuccess");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.passwordEncoder(new Md5PasswordEncoder())
			.withUser("keith").password("417c7382b16c395bc25b5da1398cf076").roles("USER", "SUPERVISOR").and()
			.withUser("erwin").password("12430911a8af075c6f41c6976af22b09").roles("USER", "SUPERVISOR").and()
			.withUser("jeremy").password("57c6cbff0d421449be820763f03139eb").roles("USER").and()
			.withUser("scott").password("942f2339bf50796de535a384f0d1af3e").roles("USER");
		
	}*/
	
	@Autowired
	DataSource dataSource;
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
             System.out.println("Inside the configauthentication");
             System.out.println("data source:"+dataSource);
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select emailid,password,enabled from applicationuser where emailid=?")
		.authoritiesByUsernameQuery(
			"select u1.emailid, u2.authority from applicationuser u1, userrole u2 where u1.userid = u2.userid and u1.emailid =?");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 System.out.println("Inside the configure");
	  http.authorizeRequests()
		.antMatchers("/user/**").access("hasRole('ROLE_USER')")
		.and()
		  .formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/user").failureUrl("/log?error").usernameParameter("username").passwordParameter("password")
		.and()
		  .logout().logoutSuccessUrl("/log?logout")
		.and()
		  .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf();
	  http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.and()
		  .formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/admin").failureUrl("/log?error").usernameParameter("username").passwordParameter("password")
		.and()
		  .logout().logoutSuccessUrl("/log?logout")
		.and()
		  .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf();
	  
	  System.out.println("endof configure");
	}

}
