package com.example.securityapp1;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
//@EnableWebSecurity to enable Spring Security’s web security support and provide the Spring MVC integration. 
//It also extends WebSecurityConfigurerAdapter and overrides a couple of its methods to set some specifics of the web security configuration.
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	// this method is mainly to configure our own user name & password
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("abc").password("{noop}xyz").roles("ADMIN").and().withUser("aaa")
				.password("{noop}xyz").roles("ADMIN");

		auth.inMemoryAuthentication().withUser("abc").password("xyz").roles("ADMIN").and().withUser("aaa")
				.password("xy0z").roles("ADMIN");

		auth.inMemoryAuthentication().withUser("abc").password(getPasswordEncoder().encode("xyz")).roles("ADMIN").and()
				.withUser("aaa").password(getPasswordEncoder().encode("xy0z")).roles("ADMIN");

	}

	// http://localhost:9090/logout

	// ANother way to specify that password is not encrypted to spring security
	// framework using creating a bean as below
	/*
	 * @Bean public PasswordEncoder getPasswordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
