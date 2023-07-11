package com.aift.lukie.Service.outterService.Primary;

import com.aift.lukie.Model.Primary.UpdatedTableTimeMonitor;
import com.aift.lukie.Repository.Primary.UpdatedTableTimeRepository;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.logging.*;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UpdatedTableTimeMonitorService {

    // @Autowired
    // @Qualifier("secondaryDataSource")
    // private DataSource secondaryDataSource;

    @Autowired
    // @Qualifier("UpdatedTableTimeRepository")
    private  UpdatedTableTimeRepository updatedTableTimeRepository;

    /// setting logger
    public Logger logger = Logger.getLogger(UpdatedTableTimeRepository.class.getName());

    /**
     * @param tableName
     * @return
     */
    public UpdatedTableTimeMonitor findOne(String tableName){
        return updatedTableTimeRepository.findByTableName(tableName);
    }

    /**
     *  try to do a get and create function or ORM model
     * 
     * @param <K>
     * @param jsonParam
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws NoSuchFieldException
     */
    public <K> Object getAndCreate(HashMap<String,K> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        // logger.info("getAndCreate");
        String tableName = (String) jsonParam.get("tableName");
        UpdatedTableTimeMonitor res = updatedTableTimeRepository.findByTableName(tableName);
        if (res != null){
            return "exist";
        }else{
            UpdatedTableTimeMonitor data = new UpdatedTableTimeMonitor(jsonParam);
            return updatedTableTimeRepository.save(data);
        }
    }


    /**
     * 
     * @param <T>
     * @param <K>
     * @param jsonParam
     * @return
     */
    public <T,K> Object findAndUpdate(HashMap<T,K> jsonParam){
        // logger.info("findAndUpdate");
        try{
            String tableName = (String) jsonParam.get("tableName");
            UpdatedTableTimeMonitor res = updatedTableTimeRepository.findByTableName(tableName);

            if (res != null){
                /// modifiedTime
                Timestamp modifiedTime = Timestamp.valueOf((String) jsonParam.get("modifiedTime")); 
                res.setmodifiedTime(modifiedTime);
                
                /// modifiedTimeNineThree
                Timestamp modifTimeNineThree = Timestamp.valueOf((String) jsonParam.get("modifiedTimeNineThree"));
                res.setmodifiedTimeNineThree(modifTimeNineThree);

                /// save data
                return updatedTableTimeRepository.save(res);
            }else{
                String resNotFound = tableName +" Not found ";
                return resNotFound; 
            }

            }catch(Exception e){
                    return e;
                }
    }

}
