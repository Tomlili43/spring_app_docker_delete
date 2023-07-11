package com.aift.lukie.utilities;

import java.security.SecureRandom;
import java.util.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aift.lukie.Model.Teritary.User;
import com.aift.lukie.Repository.Teritary.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;

@Component
@Getter
public class JWTUtils {

    private ObjectMapper mapper = new ObjectMapper();
    private SimpleModule module = new SimpleModule();

    @Autowired
    UserRepository userRepository;

    /// because the HS512 need at least 512 bits long so that i write this method to random generate the string
    private static String generateRandomString() {
        
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[64];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    private void saveUuid(String username,String uuid){
        User userInfo = userRepository.findByUsername(username);
        userInfo.setUuid(uuid);
        userRepository.save(userInfo);
    }
    
    private String getUuid(String username){
        User userInfo = userRepository.findByUsername(username);
        return userInfo.getUuid();
    }

    /**
     * @Descrption generate token
     * @param username
     * @param role
     * @return
     * @throws JsonProcessingException
     */
    public String generateToken(String username, String role) throws JsonProcessingException {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600000);
        
        String SECRET_KEY = "lukieOntheBeat:" + generateRandomString();

        SecretKey key = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS512.getJcaName());

        String keySpecJson = mapper.writeValueAsString(key);

        System.out.println("generated key:"+keySpecJson);
        saveUuid(username, keySpecJson);
        
        String tokenGenerated = Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
        System.out.println("token generated:\n "+tokenGenerated);
        return tokenGenerated;
    }

    /**
     * @Description validate token and get username from it
     * @param token
     * @return username
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    public String validateTokenAndGetUsername(String username,String token) throws JsonMappingException, JsonProcessingException {
        // custom a deserializer for SecretKeySpec, because SecretKeySpec doesnt have constructor.
        module.addDeserializer(SecretKeySpec.class, new SecretKeySpecDeserializer());
        mapper.registerModule(module);

        // fetch corresponding uuid
        String SECRET_KEY= getUuid(username);
        System.out.println("retrieved key:\n"+SECRET_KEY);
        SecretKeySpec keySpec = mapper.readValue(SECRET_KEY, SecretKeySpec.class);

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(keySpec)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

}
