package com.example.webbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.webbook.service.impl.LoginSecurityService;

@Configuration
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	private LoginSecurityService loginService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	        
	

		
		http.csrf().disable();

		// Các trang không yêu cầu login
		http.authorizeRequests().antMatchers("/homepage/**","/web/css/**","/web/vender**","/web/js/**", "/login", "/logout").permitAll();

		// Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
		// Nếu chưa login, nó sẽ redirect tới trang /login.
		http.authorizeRequests().antMatchers("/GioHang/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");

		// Trang chỉ dành cho ADMIN
		http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
//		 http.authorizeRequests()
//		 .antMatchers("/homepage/**","/web/css/**","/web/vender**","/web/js/**").access("hasAnyRole('USER', 'ADMIN')") 
//		 .anyRequest().authenticated().and()
//		 .formLogin().loginPage("/logins").permitAll()
//		 .defaultSuccessUrl("/homepage")
//		 .failureUrl("/logins?Susscess=false")
//		 .loginProcessingUrl("/j_spring_security_check")
//		 .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
		 
		
		 
		 http.authorizeRequests().and().formLogin()
		 .loginProcessingUrl("/j_spring_security_check")
		 .loginPage("/logins")		 
		 .defaultSuccessUrl("/homepage", false)
		 .failureUrl("/logins?Susscess=false")
		 .usernameParameter("username")
		 .passwordParameter("password")
		 .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
		 
		
		 
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginService).passwordEncoder(passwordEncoder());
		
		
		
		
	}
	
	
     
	
	  
}
