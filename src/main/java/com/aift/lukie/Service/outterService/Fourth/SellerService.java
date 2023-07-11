package com.aift.lukie.Service.outterService.Fourth;

import java.util.*;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.utilities.ExistHandler;
import com.aift.lukie.Model.Fourth.Seller;
import com.aift.lukie.Repository.Fourth.SellerRepository;

@Service
public class SellerService {
    
    @Autowired
    SellerRepository sellerRepository;

    /// setting logger
    public Logger logger = Logger.getLogger(SellerService.class.getName());

    /**
     * @param sellerId
     * @return
     */
    public HashMap<String, Object> findBySellerId(String sellerId){
        HashMap<String, Object> resultMap = new HashMap<>();
        Seller exist = sellerRepository.findBySellerId(sellerId);
        if(exist!=null){
            resultMap.put("seller",exist);
        }else{
            resultMap.put("seller",ExistHandler.NotExist);
        }
        return resultMap;
    }

}
