package com.zensar.messageapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.zensar.messageapi.security.jwt.filter.JwtFilter;
import com.zensar.messageapi.security.service.ZensarUserServiceImpl;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private ZensarUserServiceImpl userDetailsService;
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	return passwordEncoder;
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		     .userDetailsService(userDetailsService)
		     .passwordEncoder(getBCryptPasswordEncoder());
		
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		    .csrf().disable()
		    .authorizeRequests()
		    .antMatchers(HttpMethod.POST,"/api/authenticate").permitAll()
	
		    .anyRequest()
		    .authenticated()
		    .and()
		    .addFilter(new JwtFilter(authenticationManagerBean()))
		     .sessionManagement()
		     .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean()throws Exception{
		return super.authenticationManagerBean();
	}

}
