package com.aift.lukie.Service.outterService.Secondary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.Model.Secondary.DataSeller;
import com.aift.lukie.Repository.Secondary.DataSellerRepository;
import com.aift.lukie.utilities.ExistHandler;

import java.util.*;
import java.util.logging.Logger;

@Service
public class DataSellerService {

    @Autowired
    DataSellerRepository dataSellerRepository;

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
