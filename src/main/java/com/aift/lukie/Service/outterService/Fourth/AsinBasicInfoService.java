package com.aift.lukie.Service.outterService.Fourth;

import java.sql.ResultSetMetaData;
import java.util.*;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.utilities.ExistHandler;
import com.aift.lukie.Model.Fourth.AsinBasicInfo;
import com.aift.lukie.Repository.Fourth.AsinBasicInfoRepository;

@Service
public class AsinBasicInfoService {
    
    @Autowired
    AsinBasicInfoRepository asinBasicInfoRepository;

    /// setting logger
    public Logger logger = Logger.getLogger(AsinBasicInfoService.class.getName());

    /**
     * @param productId
     * @return
     */
    public HashMap<String, Object> findByProductId(String productId){
        HashMap<String, Object> resultMap = new HashMap<>();
        AsinBasicInfo exist = asinBasicInfoRepository.findByProductId(productId);
        if(exist!=null){
            resultMap.put("asin_basic_info",exist);
        }else{
            resultMap.put("asin_basic_info",ExistHandler.NotExist);
        }
        return resultMap;
    }

    /**
     * @param sellerId
     * @return
     */
    public HashMap<String, Object> findBySellerId(String sellerId){
        HashMap<String, Object> resultMap = new HashMap<>();
        List<AsinBasicInfo> exist = asinBasicInfoRepository.findBySellerId(sellerId);
        if(exist.size()!=0){
            resultMap.put("asin_basic_info",exist);
        }else{
            resultMap.put("asin_basic_info",ExistHandler.NotExist);
        }
        return resultMap;
    }

    /**
     * 
     * @param productId
     * @param sellerId
     * @return
     */
    public HashMap<String, Object> findByProductIdAndSellerId(String productId, String sellerId){
        HashMap<String, Object> resultMap = new HashMap<>();
        List<AsinBasicInfo> exist = asinBasicInfoRepository.findByProductIdAndSellerId(productId,sellerId);
        if(exist.size()!=0){
            resultMap.put("asin_basic_info",exist);
        }else{
            resultMap.put("asin_basic_info",ExistHandler.NotExist);
        }
        return resultMap;
    }
}
