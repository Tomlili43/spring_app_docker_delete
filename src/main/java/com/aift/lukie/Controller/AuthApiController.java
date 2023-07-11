package com.aift.lukie.Controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aift.lukie.Service.outterService.Teritary.UserService;
import com.aift.lukie.utilities.ResponseHandler;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value="/api")
public class AuthApiController {
    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')") // equivalent to .antMatchers("/api/admin/**").hasRole("ADMIN")
    public ResponseEntity<String> adminEndpoint() {
        return ResponseEntity.ok("Hello, Admin!");
    }

    @GetMapping("/ReadAndWrite")
    @PreAuthorize("hasRole('ReadAndWrite')") // equivalent to .antMatchers("/api/user/**").hasRole("USER")
    public ResponseEntity<String> userEndpoint() {
        return ResponseEntity.ok("Hello, data operator!");
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicEndpoint(HttpServletRequest request) {
        // Print out all headers
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
        }

        return ResponseEntity.ok("Hello, Public!");
    }
    
    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value="/generateToken",consumes={"application/json"})
    public ResponseEntity<Object> generateToken(@RequestBody HashMap<String,Object> jsonParam) throws JsonProcessingException {

        System.out.println(jsonParam);

        try{
            String res = userService.validateAndRequireToken(jsonParam);
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
