package com.aift.lukie.utilities;

import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JWTInterceptor implements HandlerInterceptor {

@Autowired
private JWTUtils jwtUtils;

@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Get the JWT from the "token" header
        String token = request.getHeader("token");
        String usernameValid = request.getHeader("username");

        // Verify the JWT using JWTUtils
        String username = jwtUtils.validateTokenAndGetUsername(usernameValid,token);

        // If the JWT is invalid, send an error response and return false
        if (username == null) {
            ResponseEntity<Object> apiResponse = ResponseHandler.generateResponse("JWT token invalid", HttpStatus.valueOf(505), false);
            String json = new ObjectMapper().writeValueAsString(apiResponse);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(json);
            return false;
        }

        // Otherwise, add the username to the request attribute and return true
        request.setAttribute("username", username);
        return true;
    }
}
