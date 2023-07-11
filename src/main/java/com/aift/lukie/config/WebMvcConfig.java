package com.aift.lukie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.aift.lukie.utilities.JWTInterceptor;
/**
 * @Description: this is the jwt token authetication.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private JWTInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/api/**") // under /api all need JWT token
                .excludePathPatterns("/api/generateToken","/api/public"); // for generateToken only need to log in admin account
    }
}
