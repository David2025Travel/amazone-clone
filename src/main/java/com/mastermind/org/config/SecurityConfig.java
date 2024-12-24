package com.mastermind.org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain configure (HttpSecurity http) throws Exception {
		
		http.csrf().disable() ;
		
		http.authorizeHttpRequests(authorize->
					authorize.anyRequest().permitAll());
		
		return http.build();
	}
}
