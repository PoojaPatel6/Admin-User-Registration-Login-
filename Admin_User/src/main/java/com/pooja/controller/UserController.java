//package com.pooja.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.pooja.dto.UserDto;
//import com.pooja.service.UserService;
//
//import ch.qos.logback.core.model.Model;
//
//@Controller
//public class UserController {
//	
//	@Autowired
//	private UserService userService;
//	
//	
//	
//	@GetMapping("/registration")
//	public String getRegistrationPage() {
//		
//		return "register";
//		
//	}
//	
//	@PostMapping("/registration")
//	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
//		userService.save(userDto);
//		
//		model.addAttribute("message", "Registered Successfully");
//		return "register";
//		
//	}
//
//}





package com.pooja.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import com.pooja.dto.UserDto;
import com.pooja.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	UserDetailsService userDetailsService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/registration")
 
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "register";
    }
    
    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        userService.save(userDto);
//        model.addAttribute("message", "Registered Successfully");
        model.addAttribute("message", "Successfully Registered");
        return "register";
    }
   
    
    
    
    @GetMapping("/login")
    public String login() {
    	return "login";
    }
    
    @GetMapping("user-page")
    public String userPage(Model  model, Principal principal) {
    	UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
    	model.addAttribute("user", userDetails);	
    			
    	return "user";
    }
    
    
    @GetMapping("admin-page")
    public String adminPage(Model  model, Principal principal) {
    	UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
    	model.addAttribute("user", userDetails);
    	return "admin";
    	
    	
    }
    @GetMapping("investor-page")
    public String investorPage(Model  model, Principal principal) {
    	UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
    	model.addAttribute("user", userDetails);
    	return "investor";
    	
    	
    }
    
    
    
    
    @GetMapping("startup-page")
    public String startupPage(Model  model, Principal principal) {
    	UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
    	model.addAttribute("user", userDetails);
    	return "startup";
    	
    	
    }
}



