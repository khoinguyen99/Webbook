package com.example.webbook.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.webbook.contant.SystemConstant;
import com.example.webbook.entity.LoginEntity;
import com.example.webbook.respontories.LoginRespontory;
import com.example.webbook.service.ILoginService;

@Service
public class LoginService implements ILoginService{

    @Autowired
    private LoginRespontory loginRespontory;
    
   
    
    

	@Autowired
    private SystemConstant constant;
    
    @Override
	public int login(String username,String pass,Boolean isLoginAdmin)
    {
    	
    	
    	Optional<LoginEntity> optExist = loginRespontory.findByUser(username);
    	
    	
    	
    	
    	if(optExist.isEmpty())
    	{
    	   return 0;	
    		
    	}else
    	{
    		if(isLoginAdmin==true)
    		{
    		    if(optExist.get().getQuyen().equals(constant.MOD_GROUP) || optExist.get().getQuyen().equals(constant.ADMIN_GROUP))
    		    {
    		    	if(optExist.get().getStatus() == false)
    		    	{
    		    		return -1;
    		    	}else
    		    	{
    		    		if(optExist.get().getPassword().equals(pass))
    		    		      return 1;
    		    	    else
    		    		      return -2;
    		    		
    		    		
    		    	}
    		    }
    		    else
    		    {
    		    	return -3;
    		    }
    		}else
    		{
    			if(optExist.get().getStatus()==false)
    			{
    				return -1;
    			}
    			else
    			{
    				if(optExist.get().getPassword() == pass)
		    		      return 1;
		    	    else
		    		      return -2;
    			}
    			
    		}
    	}
    		
    		
    }
    
    
    
    
    
	 
	 
}
