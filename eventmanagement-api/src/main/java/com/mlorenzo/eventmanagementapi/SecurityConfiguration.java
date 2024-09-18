package com.mlorenzo.eventmanagementapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("manuel").password("{noop}12345").roles("USER")
			.and()
			.withUser("admin").password("{noop}admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/eventmanagement-api/events/**").hasRole("USER")
			// Se comenta porque ahora usamos "Method Level Security" para los recursos que requieren role ADMIN
			//.antMatchers("/eventmanagement-api/events/**").hasRole("ADMIN") // POST, PUT, PATCH, DELETE
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
	}
	
	

}
