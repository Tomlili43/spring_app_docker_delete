package com.aift.lukie.Controller;

import com.aift.lukie.Service.outterService.Primary.MonthAllService;
import com.aift.lukie.utilities.ResponseHandler;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/monthAll")
public class MonthAllController {
    @Autowired
    private  MonthAllService monthAllService;

    @PostMapping(value="/findByProductIdAndMonthAndYear",consumes={"application/json"})
    public ResponseEntity<Object> addNewRecord(@RequestBody HashMap<String,Object> jsonParam) {
        // System.out.println(jsonParam.toString());
        try{
            Object res = monthAllService.findByProductIdAndMonthAndYear(jsonParam);
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
