package com.aift.lukie.Service.outterService.Primary;

import java.util.*;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.Model.Primary.MonthAll;
import com.aift.lukie.Repository.Primary.MonthAllRepository;

import com.aift.lukie.utilities.ExistHandler;

@Service
public class MonthAllService {

    @Autowired
    // @Qualifier("UpdatedTableTimeRepository")
    private MonthAllRepository monthAllRepository;

    /// setting logger
    public Logger logger = Logger.getLogger(MonthAllService.class.getName());

    ////////////////// V2 For Query Data Only -- START ////////////////////////////
    /**
     * @param productId
     * @return
     */
    public HashMap<String, Object> findByProductIdV2(String productId){
        HashMap<String, Object> resultMap = new HashMap<>();
        List<MonthAll> exist = monthAllRepository.findByProductId(productId);

        if (exist.size()!=0){
            resultMap.put("month_all",exist);
        }else{
            resultMap.put("month_all",ExistHandler.NotExist);
        }
        return resultMap;
    }
    ////////////////// V2 For Query Data Only -- END ////////////////////////////

    /**
     * @param productId
     * @return
     */
    public List<MonthAll> findByProductId(String productId){
        return monthAllRepository.findByProductId(productId);
    }

    /**
     * @param jsonParam
     * @param productId
     * @param year
     * @param month 
     * @return
     */
    public MonthAll findByProductIdAndMonthAndYear(HashMap<String,Object> jsonParam){

        // logger.info(jsonParam.toString());
        String productId = (String) jsonParam.get("productId");
        int year = (int) jsonParam.get("year");
        int month = (int) jsonParam.get("month");
        
        return monthAllRepository.findByProductIdAndMonthAndYear(productId, month, year);
    }

    /**
     * @param jsonParam
     * @param productId
     * @param year
     * @param month 
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws NoSuchFieldException
     */
    public Object findAndCreate(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        
        MonthAll exist = this.findByProductIdAndMonthAndYear(jsonParam);

        if (exist == null){
            MonthAll newRecord = new MonthAll(jsonParam);
            return monthAllRepository.save(newRecord);
        } else{
            return ExistHandler.Exist;
        }
    }
    /**
     * 
     * @param jsonParamList
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public Object bulkFindAndCreate(List<HashMap<String,Object>> jsonParamList) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        
        List<HashMap<String,Object>> resList = new ArrayList<HashMap<String,Object>>(); 

        for (int i=0;i<jsonParamList.size();i++){
            HashMap<String,Object> jsonParam = jsonParamList.get(i);
            Object res = this.findAndCreate(jsonParam);
            if (res == ExistHandler.Exist){
                resList.add(jsonParam);
            } else{
                ;
            }
        }

        if (resList.isEmpty()!=true){
            return String.format(
                "{"+" the prodct_id existed:"+resList+" }"
            );
        } else {
            return "SUCCESS";
        }        
    }

    /**
     * 
     * @param jsonParam
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public Object findAndUpdate(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        MonthAll exist = this.findByProductIdAndMonthAndYear(jsonParam);
        if (exist != null){
            return monthAllRepository.save(exist.setAllElements(jsonParam));
        } else {
            return ExistHandler.NotExist;
        }
    }

    public Object bulkfindAndUpdate(List<HashMap<String,Object>> jsonParamList) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{

        List<HashMap<String,Object>> resList = new ArrayList<HashMap<String,Object>>();

        for (int i=0;i<jsonParamList.size();i++){
            HashMap<String,Object> jsonParam = jsonParamList.get(i);
            Object res = this.findAndUpdate(jsonParam);
            // logger.info(res.toString());
            if (res == ExistHandler.NotExist){
                resList.add(jsonParam);
            } else{
                ;
            }
        }

        if (resList.isEmpty()!=true){
            return String.format(
                "{"+" the prodct_id do not existed:"+resList+" }"
            );
        } else {
            return "SUCCESS";
        }        
    }

}
