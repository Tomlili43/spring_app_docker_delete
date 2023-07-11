package com.aift.lukie.Controller;

import com.aift.lukie.Model.Primary.UpdatedTableTimeMonitor;
import com.aift.lukie.Service.outterService.Primary.UpdatedTableTimeMonitorService;
import com.aift.lukie.utilities.ResponseHandler;
import java.util.HashMap;
import java.util.logging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController ///annouce controller of this class
@RequestMapping(value="/updatedTableTimeMonitor") // This means URL's start with /demo (after Application path)
public class UpdatedTableTimeMonitorController {
    
    @Autowired
    private  UpdatedTableTimeMonitorService updatedTableTimeMonitorService;

    /// setting logger
    public Logger logger = Logger.getLogger(UpdatedTableTimeMonitorController.class.getName());

    //hello
	@GetMapping("/")
	public String index() {
		return "Greetings from lukieee!";
	}

    @PostMapping(value="/update",consumes={"application/json"})
    public <T,K> ResponseEntity<Object> addNewRecord(@RequestBody HashMap<T,K> jsonParam
    // @RequestBody UpdatedTableTimeMonitor updatedTableTimeMonitor
    ) {
        logger.info(jsonParam.toString());
        try{
            Object res = updatedTableTimeMonitorService.findAndUpdate(jsonParam);
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    
    @PostMapping(value="/getByTableName",consumes={"application/json"} )
    public ResponseEntity<Object> getByCode(@RequestBody String tableName) {
        logger.info(tableName);
        try{
            UpdatedTableTimeMonitor res = updatedTableTimeMonitorService.findOne(tableName);
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    
    @PostMapping(value="/getAndCreate",consumes={"application/json"})
    public<T,K> ResponseEntity<Object> getAndCreateRecord(@RequestBody HashMap<String,K>  jsonParam
    // @RequestBody UpdatedTableTimeMonitor updatedTableTimeMonitor
    ) {
        logger.info(jsonParam.toString());
        try{
            Object res = updatedTableTimeMonitorService.getAndCreate(jsonParam);
            return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, res);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

}
}