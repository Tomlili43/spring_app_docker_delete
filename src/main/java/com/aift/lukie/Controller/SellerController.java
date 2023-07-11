package com.aift.lukie.Controller;

import com.aift.lukie.Model.Teritary.SellerToken;
import com.aift.lukie.Service.outterService.Teritary.SellerTokenService;

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

@Tag(name = "SellerToken", description = "Seller Token APIs Instruction")
@CrossOrigin(origins="https://localhost:8081")
@RestController
@RequestMapping(value="/SellerToken")
public class SellerController {
    @Autowired
    private  SellerTokenService sellerTokenService;

    //////////////// updateAndCreate //////////////////////
    @Operation(summary = "update or create a new data by Id", tags = { "updateAndCreate", "post" })
    @ApiResponses({
        @ApiResponse(responseCode = "201", content = {
            @Content(schema = @Schema(implementation = SellerToken.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(value="/updateAndCreate",consumes={"application/json"})
    public ResponseEntity<Object> updateAndCreate(@RequestBody HashMap<String,Object> jsonParam) {
        System.out.println(">>>>>>>>>>>  updateAndCreate -- "+jsonParam.toString());
        try{
            Object res = sellerTokenService.updateAndCreateSellerToken(jsonParam);
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    ////////////////////////////////////////////////////////

    //////////////// findSellerToken ///////////////////////
    @Parameter(name = "Id", description = "seller id", required = true)
    @Operation(summary = "find data by Id", tags = { "findSellerToken", "post", "filter" })
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = SellerToken.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "204", description = "There are no data by Id", content = {
            @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(value="/findSellerToken",consumes={"application/json"})
    public ResponseEntity<Object> findSellerToken(@RequestBody HashMap<String,Object> jsonParam) {
        System.out.println(">>>>>>>>>>>  findSellerToken -- "+jsonParam.toString());
        try{
            Object res = sellerTokenService.findSellerToken(jsonParam);
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    /////////////////////////////////////////////////////////
}
