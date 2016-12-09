package com.niit.shoppingcartfrontend.config;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

/*	@Override
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
	//  .withUser("niitadmin").password("niitadmin").roles("ADMIN");
	  
	  /*.usersByUsernameQuery(
		"select username,password,enabled from users where username = ?")
	.authoritiesByUsernameQuery(
		"select username,authority from authorities where username = ?");*/
	  
	  .usersByUsernameQuery(
		"select username, password, enabled from user where username=?")
	.authoritiesByUsernameQuery(
		"select u1.username, u2.authority from user u1, userrole2 u2 where u1.id = u2.userid and u1.username=?");
	  
		/*.usersByUsernameQuery(
			"select username, password from user where username=?")
		.authoritiesByUsernameQuery(
			"select u1.username, u2.authority from user u1, userrole2 u2 where u1.id = u2.userid and u1.username=?");*/
	}
	
	/*@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails e = new UserDetails() {
			
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public String getUsername() {
				// TODO Auto-generated method stub
				return "niituser";
			}
			
			public String getPassword() {
				// TODO Auto-generated method stub
				return "niitpassword";
			}
			
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		List<UserDetails> users = new ArrayList<UserDetails>();
		users.add(e);
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(users);
		manager.createUser(User.withUsername("user").password("password").roles("USER").build());
		manager.createUser(User.withUsername("admin").password("password").roles("USER","ADMIN").build());
		return manager;
	}*/
	
	/*@Autowired
	DataSource dataSource;
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.withDefaultSchema()
				.withUser("niituser2").password("niitpassword2").roles("USER").and()
				//.withUser("select username from user where username=?").and()
				.withUser("admin").password("password").roles("USER", "ADMIN");
	}*/
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		 System.out.println("Inside the configure");
		 //System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
		
		
	}*/
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		 
		
		http
		.authorizeRequests()
			//.anyRequest().authenticated()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.and()
			.formLogin().defaultSuccessUrl("/home").failureUrl("/login?error").usernameParameter("username").passwordParameter("password")
			.and()
			  .logout().logoutSuccessUrl("/login?logout").invalidateHttpSession(true)
			  .and()
		.httpBasic();
		
		http
		.authorizeRequests()
			//.anyRequest().authenticated()
		.antMatchers("/user/**").access("hasRole('ROLE_USER')")
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/processLogin").permitAll()
			.defaultSuccessUrl("/home").failureUrl("/login?error").usernameParameter("username").passwordParameter("password")
			.and()
			  .logout().logoutSuccessUrl("/login?logout")
			  .and()
		.httpBasic();
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        .antMatchers("/resources/**").permitAll()
        .antMatchers("/").permitAll()
        .antMatchers("/getProductsByCategory/*").permitAll()
        //.antMatchers("/flows/**").permitAll()
        //.antMatchers("/").permitAll()
        .antMatchers("/Registration*").permitAll()
        .antMatchers("/register").permitAll()
        .antMatchers("/home").permitAll()
        .antMatchers("/contact").permitAll()
        .antMatchers("/about").permitAll()
        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/user/**").access("hasRole('ROLE_USER')")
        .antMatchers("/flows*").access("hasRole('ROLE_USER')")
            .anyRequest().authenticated() 
            .and()
        .formLogin().loginPage("/login").permitAll()
        .defaultSuccessUrl("/admin/home")
        .and()
        .logout().permitAll();
        
		http
        .authorizeRequests()
        .antMatchers("/resources/**").permitAll()    
        //.antMatchers("/flows/**").permitAll()
        .antMatchers("/user/**").access("hasRole('ROLE_USER')")
            .anyRequest().authenticated() 
            .and()
        .formLogin().loginPage("/login").permitAll()
        .defaultSuccessUrl("/home")
        .and()
        .logout().permitAll();
		
		http.authorizeRequests()
		.antMatchers("/flows/*").access("hasRole('ROLE_USER')");
		
            /*.and()
        .httpBasic();    */ 
		http.csrf().disable();
		
	}
	
	
	

}
