package com.aift.lukie.Service.outterService.Secondary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.Model.Secondary.DataProduct;
import com.aift.lukie.Repository.Secondary.DataProductRepository;
import com.aift.lukie.utilities.ExistHandler;

import java.util.*;
import java.util.logging.Logger;


@Service
public class DataProductService {
    
    @Autowired
    private DataProductRepository dataProductRepository;

    /// setting logger
    public Logger logger = Logger.getLogger(DataProductService.class.getName());
    
    public Object findByPid(HashMap<String,Object>resMap){
        String productId = (String) resMap.get("product_id");
        List<DataProduct> exist = dataProductRepository.findByProductId(productId);
        HashMap<String, Object> resultMap = new HashMap<>();
        if(!exist.isEmpty()){
            resultMap.put("data_product", exist);
        } else{
            resultMap.put("data_product",ExistHandler.NotExist);
        }
        return resultMap;
    }

    public Object findBySid(HashMap<String,Object>resMap){
        String sellerId = (String) resMap.get("seller_id");
        List<DataProduct> exist = dataProductRepository.findBySellerId(sellerId);
        HashMap<String, Object> resultMap = new HashMap<>();
        if(!exist.isEmpty()){
            resultMap.put("data_product", exist);
        } else{
            resultMap.put("data_product",ExistHandler.NotExist);
        }
        return resultMap;
    }

    public Object findByPidAndSid(HashMap<String,Object>resMap){
        String productId = (String) resMap.get("product_id");
        String sellerId = (String) resMap.get("seller_id");
        HashMap<String, Object> resultMap = new HashMap<>();
        List<DataProduct> exist = dataProductRepository.findByProductIdAndSellerId(productId,sellerId);
        if(!exist.isEmpty()){
            resultMap.put("data_product", exist);
        } else{
            resultMap.put("data_product",ExistHandler.NotExist);
        }
        return resultMap;
    }
}
