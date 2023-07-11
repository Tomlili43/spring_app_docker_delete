package com.aift.lukie.Service.outterService.Fifth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.Model.Fifth.DataSeller;
import com.aift.lukie.Repository.Fifth.DataSellerRepositoryPb;
import com.aift.lukie.utilities.ExistHandler;

import java.util.*;
import java.util.logging.Logger;

@Service
public class DataSellerServicePb {

    @Autowired
    DataSellerRepositoryPb dataSellerRepository;

    public Object findBySid(HashMap<String,Object>resMap){
        String sellerId = (String) resMap.get("seller_id");
        Optional<DataSeller> exist = dataSellerRepository.findById(sellerId);
        HashMap<String, Object> resultMap = new HashMap<>();
        if(exist.isPresent()){
            resultMap.put("data_seller", exist.get());
        } else{
            resultMap.put("data_seller",ExistHandler.NotExist);
        }
        return resultMap;
    }
}
