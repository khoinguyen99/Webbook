package com.example.webbook.controller.admin;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import com.example.webbook.entity.LoginEntity;
import com.example.webbook.service.ILoginService;
import com.example.webbook.service.impl.LoginSecurityService;

@Controller(value = "ControllerofLogin")
public class AdminController {
  
	@Autowired
	LoginSecurityService loginSecurityService;
	
	@Autowired
	private ILoginService iLoginService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("logins")
	public ModelAndView showlogins(ModelMap model)
	{
	    ModelAndView andView = new ModelAndView("/webapp/views/admin/loginadmin");	
		
//		model.addAttribute("logins",new LoginEntity());
		return andView;	
	}
	
	@GetMapping("login")
	public String showlogin(ModelMap model)
	{
		
		
		model.addAttribute("loginss",new LoginEntity());
		
		return "/webapp/views/admin/loginadmin";	
	}
	
	
	@PostMapping("login")
	public ModelAndView dangnhap(ModelMap model,LoginEntity results,BindingResult bindingResult)
	{
		    
		    
		    
		     System.out.println("ok");
		   
		    
		    int result = iLoginService.login(results.getUsername(),results.getPassword(),true);
		    
		    if(result == 1)
		    {
		    	session.setAttribute("username",results.getUsername());
		    	session.setAttribute("password",results.getPassword());	
		    	
		    	
		    	
			    return new ModelAndView("/webapp/decorator/admin",model);
		    	
		    	
		    } else if (result == 0)
            {
		    	model.addAttribute("message", "T??i kho???n kh??ng t???n t???i.");
            }
            else if (result == -1)
            {
            	model.addAttribute("message", "T??i kho???n ??ang b??? kho??.");
            	
            }
            else if (result == -2)
            {
            
            	
            	model.addAttribute("message","M???t kh???u kh??ng ????ng");
	            	
	            	
            	
            	
            	
            }
            else if (result == -3)
            {
            	model.addAttribute("message", "T??i kho???n c???a b???n kh??ng c?? quy???n ????ng nh???p.");
            }else
            {
            	model.addAttribute("message", "T??i kho???n ho???c m???t kh???u kh??ng ch??nh x??c");  	
            }
            
            
		  
            	 
		    return new ModelAndView("redirect:/login");	
            
		    
		    
		    
		  
		    
		    
	}
	
	@GetMapping("/logoutSuccessful")
	public String logouts()
	{
		session.removeAttribute("nameuser");
		return "redirect:/homepage";
	}
	
	@GetMapping("/403")
	public String accessDenied(ModelMap model, Principal principal) {

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			String userInfo = loginSecurityService.toString(loginedUser);

			model.addAttribute("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);

		}

		return "webapp/views/webs/ErrorPage";
	}
	
	
	
}
