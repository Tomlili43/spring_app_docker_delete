package com.aift.lukie.Service.outterService.Secondary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.Model.Secondary.DataMonth;
import com.aift.lukie.Repository.Secondary.DataMonthRepository;
import com.aift.lukie.utilities.ExistHandler;

import java.util.*;
import java.util.logging.Logger;


@Service
public class DataMonthService {
    
    @Autowired
    private DataMonthRepository dataMonthRepository;

    /// setting logger
    public Logger logger = Logger.getLogger(DataMonthService.class.getName());
    
    public Object findByPid(HashMap<String,Object>resMap){
        String productId = (String) resMap.get("product_id");
        List<DataMonth> exist = dataMonthRepository.findByProductId(productId);
        HashMap<String, Object> resultMap = new HashMap<>();
        if(!exist.isEmpty()){
            resultMap.put("data_month", exist);
        } else{
            resultMap.put("data_month", ExistHandler.NotExist);
        }
        return resultMap;
    }

    public Object findBySid(HashMap<String,Object>resMap){
        String sellerId = (String) resMap.get("seller_id");
        List<DataMonth> exist = dataMonthRepository.findBySellerId(sellerId);
        HashMap<String, Object> resultMap = new HashMap<>();
        
        if(!exist.isEmpty()){
            resultMap.put("data_month", exist); 
        } else{
            resultMap.put("data_month",ExistHandler.NotExist);
        }
        return resultMap;
    }

    public Object findByPidAndSid(HashMap<String,Object>resMap){
        String productId = (String) resMap.get("product_id");
        String sellerId = (String) resMap.get("seller_id");
        HashMap<String, Object> resultMap = new HashMap<>();
        List<DataMonth> exist = dataMonthRepository.findByProductIdAndSellerId(productId,sellerId);
        if(!exist.isEmpty()){
            resultMap.put("data_month", exist);
        } else{
            resultMap.put("data_month",ExistHandler.NotExist);
        }
        return resultMap;
    }
}
