package com.pooja.service;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@Service
//public class CustomSuccessHandler implements AuthenticationSuccessHandler {
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException, ServletException {
//	
//		
//		
//		var authorities = authentication.getAuthorities();
//		var roles = authorities.stream().map(r -> r.getAuthority()).findFirst();
//		
//		
//		if(roles.orElse("").equals("ADMIN")) {
//			
//			response.sendRedirect("/admin-page");
//			
//		}else if(roles.orElse("").equals("USER")) {
//			response.sendRedirect("/user-page");
//			
//		}else {
//			response.sendRedirect("/error");
//			
//		}
//		
//		
//		
//	}
@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        var authorities = authentication.getAuthorities();
        var roleOptional = authorities.stream().map(r -> r.getAuthority()).findFirst();

        // Check if the Optional has a value and handle it safely
        if (roleOptional.isPresent()) {
            String role = roleOptional.get();
            if (role.equals("ADMIN")) {
                response.sendRedirect("/admin-page");
            } else if (role.equals("USER")) {
                response.sendRedirect("/user-page");
            } else if (role.equals("INVESTOR")) {
                response.sendRedirect("/investor-page");
            } else if (role.equals("STARTUP")) {
                response.sendRedirect("/startup-page");
            } else {
                response.sendRedirect("/error");
            }
        } else {
            // Handle the case where no roles are found
            response.sendRedirect("/error");
        }
    }
}



