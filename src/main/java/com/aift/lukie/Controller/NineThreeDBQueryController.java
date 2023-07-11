package com.aift.lukie.Controller;

import com.aift.lukie.Service.aggregatedService.AggNineThreeDBService;

import com.aift.lukie.utilities.ResponseHandler;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value="/93database")
public class NineThreeDBQueryController {
    @Autowired
    private  AggNineThreeDBService aggNineThreeDBService;

    @PostMapping(value="/findByProductId",consumes={"application/json"})
    public ResponseEntity<Object> findByProductId(@RequestBody HashMap<String,Object> jsonParam) {
        // System.out.println(jsonParam.toString());
        try{
            Object res =(Object) aggNineThreeDBService.findByPid(jsonParam);
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping(value="/findBySellerId",consumes={"application/json"})
    public ResponseEntity<Object> findBySellerId(@RequestBody HashMap<String,Object> jsonParam) {
        // System.out.println(jsonParam.toString());
        try{
            Object res = (Object) aggNineThreeDBService.findBySid(jsonParam);
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping(value="/findByProductIdAndSellerId",consumes={"application/json"})
    public ResponseEntity<Object> findByProductIdAndSellerId(@RequestBody HashMap<String,Object> jsonParam) {
        // System.out.println(jsonParam.toString());
        try{
            Object res = aggNineThreeDBService.findByPidAndSid(jsonParam);
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
