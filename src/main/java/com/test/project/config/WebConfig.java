package com.test.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author usman
 *
 */
@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{
	 @Value("${allowed.ip}")
	 private String allowedIp;
	 
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
		  http.csrf().disable();
	        http.authorizeRequests()
			.antMatchers("/**").access(String.format("hasIpAddress('%s')",allowedIp));
	    }
	 
	 
}
