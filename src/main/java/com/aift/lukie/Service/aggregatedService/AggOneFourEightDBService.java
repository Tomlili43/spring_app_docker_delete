package com.aift.lukie.Service.aggregatedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.Model.Fifth.DataProduct;
import com.aift.lukie.Model.Fifth.DataSeller;
import com.aift.lukie.Service.outterService.Fifth.DataMonthServicePb;
import com.aift.lukie.Service.outterService.Fifth.DataProductServicePb;
import com.aift.lukie.Service.outterService.Fifth.DataSellerServicePb;
import com.aift.lukie.utilities.ExistHandler;
import com.aift.lukie.Model.Fifth.DataMonth;

import java.util.*;
import java.util.logging.Logger;

@Service
public class AggOneFourEightDBService {
    
    @Autowired
    DataMonthServicePb dataMonthService;
    @Autowired
    DataProductServicePb dataProductService;
    @Autowired
    DataSellerServicePb dataSellerService;

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
