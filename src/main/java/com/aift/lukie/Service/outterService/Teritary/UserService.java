package com.aift.lukie.Service.outterService.Teritary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.Model.Teritary.User;
import com.aift.lukie.Repository.Teritary.UserRepository;
import com.aift.lukie.utilities.JWTUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.*;
import java.util.logging.*;

@Service
public class UserService {
    @Autowired
    // @Qualifier("UpdatedTableTimeRepository")
    private UserRepository userRepository;

    @Autowired
    private JWTUtils jwtUtils;

    /// setting logger
    public Logger logger = Logger.getLogger(User.class.getName());

    public Object validatePassword(HashMap<String,Object> jsonParam){
        String username = (String) jsonParam.get("username");
        String password = (String) jsonParam.get("password");
        User userInfo = userRepository.findByUsername(username);
        if (userInfo != null && userInfo.getPassword().equals(password)){
            return userInfo.getRole();
        }else{
            return false;
        }
    }

    public String validateAndRequireToken(HashMap<String,Object> jsonParam) throws JsonProcessingException{

        Object res = validatePassword(jsonParam);
        
        if (res instanceof Boolean){
            if ((Boolean) res == false){
                return new String("autheticated failure");
            } else {
                return new String("authetication error occurred");
            }
        } else {
            return jwtUtils.generateToken((String) jsonParam.get("username"),(String) res);
        }
    }

}
