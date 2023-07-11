package com.aift.lukie.Service.aggregatedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.Model.Secondary.DataProduct;
import com.aift.lukie.Model.Secondary.DataSeller;
import com.aift.lukie.Service.outterService.Secondary.DataMonthService;
import com.aift.lukie.Service.outterService.Secondary.DataProductService;
import com.aift.lukie.Service.outterService.Secondary.DataSellerService;
import com.aift.lukie.utilities.ExistHandler;
import com.aift.lukie.Model.Secondary.DataMonth;
import com.aift.lukie.Model.Secondary.DataProduct;
import com.aift.lukie.Model.Secondary.DataSeller;

import java.util.*;
import java.util.logging.Logger;

@Service
public class AggNineThreeDBService {
    
    @Autowired
    DataMonthService dataMonthService;
    @Autowired
    DataProductService dataProductService;
    @Autowired
    DataSellerService dataSellerService;

    public HashMap findByPid(HashMap<String,Object>resMap){
        HashMap<String, List<DataMonth>> dataMonthMap = (HashMap<String, List<DataMonth>>) dataMonthService.findByPid(resMap);
        HashMap<String, List<DataProduct>> dataProductMap = (HashMap<String, List<DataProduct>>) dataProductService.findByPid(resMap);
        
        HashMap<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.putAll(dataMonthMap);
        resultMap.putAll(dataProductMap);
        return resultMap;
    }

    public HashMap findBySid(HashMap<String,Object>resMap){
        HashMap<String, List<DataMonth>> dataMonthMap =(HashMap<String, List<DataMonth>>) dataMonthService.findBySid(resMap);
        HashMap<String, List<DataProduct>> dataProductMap =(HashMap<String, List<DataProduct>>) dataProductService.findBySid(resMap);
        HashMap<String, List<DataSeller>> dataSellerMap =(HashMap<String, List<DataSeller>>) dataSellerService.findBySid(resMap);

        HashMap<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.putAll(dataMonthMap);
        resultMap.putAll(dataProductMap);
        resultMap.putAll(dataSellerMap);
        return resultMap;
    }

    public HashMap findByPidAndSid(HashMap<String,Object>resMap){
        HashMap<String, List<DataMonth>> dataMonthMap =(HashMap<String, List<DataMonth>>) dataMonthService.findByPidAndSid(resMap);
        HashMap<String, List<DataProduct>> dataProductMap =(HashMap<String, List<DataProduct>>) dataProductService.findByPidAndSid(resMap);
        HashMap<String, List<DataSeller>> dataSellerMap =(HashMap<String, List<DataSeller>>) dataSellerService.findBySid(resMap);

        HashMap<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.putAll(dataMonthMap);
        resultMap.putAll(dataProductMap);
        resultMap.putAll(dataSellerMap);
        return resultMap;
    }

}
