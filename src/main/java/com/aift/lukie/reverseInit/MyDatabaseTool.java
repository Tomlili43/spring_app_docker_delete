package com.aift.lukie.reverseInit;

import java.util.*;

import com.aift.lukie.utilities.ReverseConfigProperties;

import lombok.Getter;

import static com.aift.lukie.utilities.Utils.*;

@Getter
public class MyDatabaseTool{
    private final ReadTableAndFormData readTableAndFormData;
    private final DataToPkClass dataToPkClass;
    private final DataToEntityClass dataToEntityClass;
    private final DataToRepositoryClass dataToRepositoryClass;
    private final Map<String,Object> configMap;

    private String config;
    
    public MyDatabaseTool(ReverseConfigProperties config) throws java.io.IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
       
        System.out.println("settings >>> "+config.toString());
        this.configMap = convertObjectToMap(config);

        this.readTableAndFormData = new ReadTableAndFormData(configMap);
        this.dataToPkClass = new DataToPkClass(configMap);
        this.dataToEntityClass = new DataToEntityClass(configMap);
        this.dataToRepositoryClass = new DataToRepositoryClass(configMap);
    
    }

    public void execute() throws Exception {

        Map<String,Object> resMap = this.readTableAndFormData.generateDataList();
        System.out.println("resMap >>>>>>>>>> "+resMap);

        boolean pkClassFlag = this.dataToPkClass.main(resMap);

        System.out.println("This is pkList >>>>>>>>" + this.dataToPkClass.getPkList());
        System.out.println("Composed Primary Key exists >>>>>> "+pkClassFlag);
        
        this.dataToEntityClass.main(resMap,pkClassFlag);
        this.dataToRepositoryClass.main(resMap,pkClassFlag);

        System.out.println("The whole process finished...");
    }
}
