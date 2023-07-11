package com.aift.lukie.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Descrption: custom a plaintext passwordencoder, og recommend use bryt. 自定义一个明文加密器，方便使用。
 * this is a prompt authetication
 */
class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/api/generateToken/**").hasRole("ADMIN")
            .antMatchers("/api/admin/**").hasRole("ADMIN")
            .antMatchers("/api/ReadAndWrite/**").hasRole("ReadAndWrite")
            .antMatchers("/api/public/**").permitAll()
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated() /// confirm all request need to autheticate
            .and()
            .csrf().disable()
            .httpBasic();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("changliu")
            .password("root") // use {noop} prefix to indicate plain text password
            .roles("ADMIN")
            .and()
            .withUser("dataOperator")
            .password("operatorGoodjob") // use {noop} prefix to indicate plain text password
            .roles("ReadAndWrite")
            .and()
            .passwordEncoder(new CustomPasswordEncoder())
            ;
    }
}


