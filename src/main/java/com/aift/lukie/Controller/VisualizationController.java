package com.aift.lukie.Controller;

import java.util.*;

import com.aift.lukie.Model.Visualization.CategoryCounts;
import com.aift.lukie.Service.innerService.Visualization.VisualizationService;
import com.aift.lukie.utilities.ExistHandler;
import com.aift.lukie.utilities.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController ///annouce controller of this class
@RequestMapping(value="/visualization") // This means URL's start with /demo (after Application path)
public class VisualizationController {
    
    @Autowired
    VisualizationService visualizationService;

    @PostMapping(value="/visualizationData",consumes={"application/json"})
    public ResponseEntity<Object> visualizationDataDispenser(@RequestBody HashMap<String,Object> jsonParam){
        String tableName = (String) jsonParam.get("tableName");
        Object res = "TableName Not Exists";
        try{
            switch(tableName){
                case "categoryCounts":
                    res = visualizationService.categoryCounts();
                    break;
                case "categoryTimeCoverage":
                    res = visualizationService.categoryTimeCoverage();
                    break;
                case "modifiedCount":
                    res = visualizationService.modifiedCount();
                    break;
                case "uniqueProductsByMonthDm":
                    res = visualizationService.uniqueProductsByMonthDm();
                    break;
                case "uniqueProductsByMonthJs":
                    res = visualizationService.uniqueProductsByMonthJs();
                    break;
                case "uniqueProductsByMonth":
                    res = visualizationService.uniqueProductsByMonth();
                    break;
                case "usTransactionCountCn":
                    res = visualizationService.usTransactionCountCn();
                    break;
                case "usTransactionCount":
                    res = visualizationService.usTransactionCount();
                    break;
                case "usTransactionValueCn":
                    res = visualizationService.usTransactionValueCn();
                    break;
                case "usTransactionValue":
                    res = visualizationService.usTransactionValue();
                    break;
                case "usTransactionVolumeCn":
                    res = visualizationService.usTransactionVolumeCn();
                    break;
                case "usTransactionVolume":
                    res = visualizationService.usTransactionVolume();
                    break;
                case "usTransactionWeightCn":
                    res = visualizationService.usTransactionWeightCn();
                    break;
                case "usTransactionWeight":
                    res = visualizationService.usTransactionWeight();
                    break;
                case "modifiedCountAggProductAverageAndSum":
                    res = visualizationService.getModifiedCountAggProductAverageAndSum();
                    break;
                case "modifiedCountAggProductAverageAndSumPb":
                    res = visualizationService.getModifiedCountAggProductAverageAndSumPb();
                    break;
                case "modifiedCountAggSellerAverageAndSum":
                    res = visualizationService.getModifiedCountAggSellerAverageAndSum();
                    break;
                case "modifiedCountAggSellerAverageAndSumPb":
                    res = visualizationService.getModifiedCountAggSellerAverageAndSumPb();
                    break;
                case "modifiedCountDataMonth":
                    res = visualizationService.getModifiedCountDataMonth();
                    break;
                case "modifiedCountDataMonthPb":
                    res = visualizationService.getModifiedCountDataMonthPb();
                    break;
                case "modifiedCountDataProduct":
                    res = visualizationService.getModifiedCountDataProduct();
                    break;
                case "modifiedCountDataProductPb":
                    res = visualizationService.getModifiedCountDataProductPb();
                    break;
                case "modifiedCountSeller":
                    res = visualizationService.getModifiedCountSeller();
                    break;
                case "modifiedCountSellerPb":
                    res = visualizationService.getModifiedCountSellerPb();
                    break;
                case "modifiedCountSellerProducts":
                    res = visualizationService.getModifiedCountSellerProducts();
                    break;
                case "modifiedCountSellerProductsPb":
                    res = visualizationService.getModifiedCountSellerProductsPb();
                    break;
                case "modifiedTimes":
                    res = visualizationService.getModifiedTimes();
                    break;
                case "modifiedTimesPb":
                    res = visualizationService.getModifiedTimesPb();
                    break;
                case "uniqueProductsByMonthDmPb":
                    res = visualizationService.getUniqueProductsByMonthDmPb();
                    break;
            }
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
