package com.example.webbook.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.webbook.entity.LoginEntity;
import com.example.webbook.respontories.LoginRespontory;

@Service
public class LoginSecurityService implements UserDetailsService {

	@Autowired
	HttpSession session;
	
	@Autowired
	LoginRespontory loginRespontory;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<LoginEntity> optExist = loginRespontory.findByUser(username);
		
		
		if(optExist.isPresent())
		{
		    LoginEntity entity = optExist.get(); 
		    
		    List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
	        
	        GrantedAuthority authorityadmin = new SimpleGrantedAuthority(entity.getQuyen());
	      
	        
	        grantList.add(authorityadmin);
	        
	        
	       
	     
		    
		    UserDetails  userdetails = new User(entity.getUsername(),entity.getPassword(),grantList);
		    
		    session.setAttribute("nameuser",entity.getUsername());
		    
		    session.setAttribute("quyen",entity.getQuyen());
		    
		    session.setAttribute("emails",entity.getEmail());
		    
		    
		    return userdetails;
		}else
		{
			new UsernameNotFoundException("Login Fail !");
		}
			
		
		return null;
	}
	
	 public static String toString(User user) {
	        StringBuilder sb = new StringBuilder();

	        sb.append("UserName:").append(user.getUsername());

	        Collection<GrantedAuthority> authorities = user.getAuthorities();
	        if (authorities != null && !authorities.isEmpty()) {
	            sb.append(" (");
	            boolean first = true;
	            for (GrantedAuthority a : authorities) {
	                if (first) {
	                    sb.append(a.getAuthority());
	                    first = false;
	                } else {
	                    sb.append(", ").append(a.getAuthority());
	                }
	            }
	            sb.append(")");
	        }
	        return sb.toString();
	    }

	
	
	
    
}
