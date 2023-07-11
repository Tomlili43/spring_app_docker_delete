package com.aift.lukie.Service.aggregatedService;

import java.util.*;

import com.aift.lukie.Service.outterService.Primary.MonthAllService;
import com.aift.lukie.Service.outterService.Primary.MonthAllJsService;
import com.aift.lukie.Service.outterService.Fourth.AsinBasicInfoService;
import com.aift.lukie.Service.outterService.Fourth.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aift.lukie.utilities.ExistHandler;


import java.util.*;
import java.util.logging.Logger;

@Service 
public class AggOneOEightDBService {
    @Autowired
    AsinBasicInfoService asinBasicInfoService;

    @Autowired
    SellerService sellerService;

    @Autowired
    MonthAllService monthAllService;

    @Autowired
    MonthAllJsService monthAllJsService;

    public HashMap<String,Object> findByPid(HashMap<String,Object> resMap){
        String productId = (String) resMap.get("product_id");
        HashMap<String,Object> asinBasicInfoRes = asinBasicInfoService.findByProductId(productId);
        HashMap<String,Object> monthAllRes = monthAllService.findByProductIdV2(productId);
        HashMap<String,Object> monthAllJsRes = monthAllJsService.findByProductIdV2(productId);

        HashMap<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.putAll(asinBasicInfoRes);
        resultMap.putAll(monthAllRes);
        resultMap.putAll(monthAllJsRes);
        
        return resultMap;
    }

    public HashMap<String,Object> findBySid(HashMap<String,Object> resMap){
        String sellerId = (String) resMap.get("seller_id");
        HashMap<String,Object> asinBasicInfoRes = asinBasicInfoService.findBySellerId(sellerId);
        HashMap<String,Object> sellerReS = sellerService.findBySellerId(sellerId);

        HashMap<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.putAll(asinBasicInfoRes);
        resultMap.putAll(sellerReS);
        return resultMap;
    }

    public HashMap<String,Object> findByPidAndSid(HashMap<String,Object> resMap){
        String productId = (String) resMap.get("product_id");
        String sellerId = (String) resMap.get("seller_id"); 

        HashMap<String,Object> asinBasicInfoRes = asinBasicInfoService.findByProductIdAndSellerId(productId,sellerId);
        HashMap<String,Object> sellerReS = sellerService.findBySellerId(sellerId);

        HashMap<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.putAll(asinBasicInfoRes);
        resultMap.putAll(sellerReS);
        return resultMap;
    }
}
