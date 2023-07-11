package com.aift.lukie.reverseInit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

import static com.aift.lukie.reverseInit.Utils.*;
import static com.aift.lukie.utilities.Utils.*;
public class DataToRepositoryClass {

    private StringBuilder code = new StringBuilder();
    private String tableName;
    private String tableNameOrigin;
    private String entityPackage;
    private String repositoryPackage;
    private String repositoryPath;
    private String pkDataType;

    public DataToRepositoryClass(Map<String,Object>configMap) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        List<String> propertyList = Arrays.asList("entityPackage","repositoryPackage","repositoryPath");
        Class<?> myClass = this.getClass();

        for (int i = 0; i<propertyList.size(); i++){

            String value = (String) propertyList.get(i);

            setElements(this, value, (String) configMap.get(value));
            Field field = myClass.getDeclaredField(value);

            field.setAccessible(true);
            Object fieldValue = field.get(this);
            if (fieldValue == null) {
                throw new IllegalStateException(value + " is not set");
            }
        };
    };

    private void generateClass(Map<String,Object> resMap, boolean pkClassFlag){
        this.tableNameOrigin =(String) resMap.get("tableName");
        this.tableName = tableNameOrigin.trim().replaceAll("'", "");
        this.tableName = convertToCamelCase(this.tableName); /// convert to capital letter

        ///////////////////////// import /////////////////////////////
        code.append("package "+this.repositoryPackage+";\n\n") /// read from yaml
        .append("import org.springframework.data.jpa.repository.JpaRepository;\n")
        .append("import org.springframework.stereotype.Repository;\n")
        .append("import "+this.entityPackage+"."+this.tableName+";\n");///read from yaml

        if (pkClassFlag==true){
            code.append("import "+this.entityPackage+"."+this.tableName+"Id;\n\n"); ///read from yaml
        }
        else{
            code.append("\n");
        }
        //////////////////////// import end //////////////////////////////

        /////////////////////// class ////////////////////////////////////
        code.append("@Repository\n");
        if (pkClassFlag==true){
            code.append("public interface "+this.tableName+"Repository extends JpaRepository<"+this.tableName+","+this.tableName+"Id>{\n}");
        } else{
            Object value = resMap.get("columnInfo"); // 获取唯一键对应的值
            List<Map<String,Object>> resList = (List<Map<String,Object>>) value;// convert obj to list
    
            for (Map<String,Object> map : resList){
                boolean isPK = (boolean) map.get("IsPrimaryKey");
                if(isPK){
                    this.pkDataType =(String) mapSqlColumnTypeToJavaType((String) map.get("ColumnType"));
                    break;
                }
            }
            code.append("public interface "+this.tableName+"Repository extends JpaRepository<"+this.tableName+","+this.pkDataType+">{\n}");
        }
    }

    public void main(Map<String,Object> resMap,boolean pkClassFlag) throws IOException{
        this.generateClass(resMap,pkClassFlag);
        // finished and save to file  
        String currentDir = System.getProperty("user.dir");
        String relativePath = this.repositoryPath; /// read from yaml
        String absolutePath = currentDir + relativePath;
        String filePath = absolutePath + this.tableName+"Repository"+".java";
     
        File file = new File(filePath);
        if(!file.exists()){
            file.createNewFile();
            // Write data to the file
            FileWriter writer = new FileWriter(file);
            writer.write(code.toString());
            writer.close();
        }  else {
            System.out.println("file name exists --"+this.tableName+"Id");
        }
        System.out.println("The generation of repository is finished...good bye!");
    }
}
