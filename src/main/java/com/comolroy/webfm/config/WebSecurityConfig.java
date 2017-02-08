package com.comolroy.webfm.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		
	@Resource
	private UserDetailsService userDetailsService;
	


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", 
											"/home", 
											"/error", 
											"/singupWF", 
											"/note", 
											"/allUser", 
											"/forgot-password", 
											"/reset-password/*",
											"/users/*", 
											"/public/**").permitAll().anyRequest().authenticated();
		// .defaultSuccessUrl("/sites") and .successHandler(yourSuccessHandlerBean)
		// can be use here
		http.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/userfirsthome")
				.and().logout().permitAll();
		 http.csrf().disable();
		
	}
	
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService);
		
	}
}
