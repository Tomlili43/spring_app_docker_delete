package com.aift.lukie.Service.outterService.Teritary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.logging.Logger;
import java.text.ParseException;


import com.aift.lukie.Model.Teritary.SellerToken;
import com.aift.lukie.Repository.Teritary.SellerTokenRepository;
import com.aift.lukie.utilities.ExistHandler;
import static com.aift.lukie.reverseInit.Utils.*;

@Service
public class SellerTokenService {
    
    @Autowired
    // @Qualifier("UpdatedTableTimeRepository")
    private SellerTokenRepository sellerTokenRepository;

    /// setting logger
    public Logger logger = Logger.getLogger(SellerTokenService.class.getName());

    public Object updateAndCreateSellerToken(HashMap<String,Object>resMap) throws NoSuchFieldException, IllegalAccessException, ParseException{
        // System.out.println(resMap);
        HashMap<String,Object> convertedMap = new HashMap<String,Object>();

        resMap.keySet().stream().forEach(key->{
            String newKey = convertToCamelCase(key,false);
            convertedMap.put(newKey,resMap.get(key));
        });

        // System.out.println(convertedMap);
        
        // String sellerId = (String) convertedMap.get("sellerId");
        // String sellingPartnerId = (String) convertedMap.get("sellingPartnerId");
        // String spapiOauthCode = (String) convertedMap.get("spapiOauthCode");
        // String redirectUri = (String) convertedMap.get("redirectUri");;
        String sellerId = (String) convertedMap.get("name");
        String sellingPartnerId = (String) convertedMap.get("id");
        String redirectUri = (String) convertedMap.get("link");

        String spapiOauthCode = (String) convertedMap.get("spapiOauthCode");
        String platform = (String) convertedMap.get("platform");
        Integer expiresIn = (Integer) convertedMap.get("expiresIn");
        String tokenType = (String) convertedMap.get("tokenType");
        String accessToken = (String) convertedMap.get("accessToken");
        String refreshToken = (String) convertedMap.get("refreshToken");

        return sellerTokenRepository.insertSellerToken(
            sellerId,
            sellingPartnerId,
            spapiOauthCode,
            redirectUri,
            platform,
            expiresIn,
            tokenType,
            accessToken,
            refreshToken
        );

        /// version control 版本控制
        /// now we do not need to update the token, just save it and retrieved it by the time,不更新token,只按时间取。
        // String id = (String) convertedMap.get("id");
        // Optional<SellerToken> exist = sellerTokenRepository.findById(id);
        // if (exist.isPresent()){
        //     return sellerTokenRepository.save(exist.get().setAllElements(convertedMap));
        // } else {
        //     SellerToken sellerToken = new SellerToken(convertedMap);
        //     return sellerTokenRepository.save(sellerToken);
        // }
    }
     
    public Object findSellerToken(HashMap<String,Object>resMap){
        logger.info(">>>>> findSellerToken");
        String sellingPartnerId = (String) resMap.get("sellingPartnerId");
        
        SellerToken exist = sellerTokenRepository.findFirstBySellingPartnerIdOrderByCreateTokenTimeDesc(sellingPartnerId);
        // System.out.println(exist.toString());
        if(exist!=null){
            return exist;
        } else{
            return ExistHandler.NotExist;
        }
        
    }

}
