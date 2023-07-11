package com.aift.lukie.reverseInit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

import static com.aift.lukie.reverseInit.Utils.*;
import static com.aift.lukie.utilities.Utils.*;

public class DataToEntityClass {

    private StringBuilder code = new StringBuilder();
    private String tableNameOrigin;
    private String tableName;
    private String entityPackage;
    private String entityPath;

    public DataToEntityClass(Map<String,Object> configMap) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        List<String> propertyList = Arrays.asList("entityPackage", "entityPath");
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

    public void generateClassFile(Map<String,Object> resMap, boolean pkClassFlag) throws IOException{
        
        // String key = resMap.keySet().iterator().next(); // 获取唯一的键
        // this.tableNameOrigin = key.trim().replaceAll("'", "");
        // this.tableName = tableNameOrigin; // store tableName and will convert in the follow part
        this.tableNameOrigin =(String) resMap.get("tableName");
        this.tableName = tableNameOrigin.trim().replaceAll("'", "");
        this.tableName = convertToCamelCase(this.tableName); /// convert to capital letter

        Object value = resMap.get("columnInfo"); // 获取唯一键对应的值
        List<Map<String,Object>> resList = (List<Map<String,Object>>) value;// convert obj to list

        Object indexValue = resMap.get("indexInfo"); // 获取index info的信息
        List<Map<String,Object>> resListIndexInfo = (List<Map<String,Object>>) indexValue;

        /////////////////////////////// import //////////////////////////////////////
        code.append("package "+this.entityPackage+";\n"); /// read from yaml

        if (pkClassFlag ==true){
            code.append("import " + this.entityPackage +"."+ this.tableName + "Id;\n"); /// read from yaml
        }

        code.append("import javax.persistence.*;\n")
        .append("import java.io.Serializable;\n")
        .append("import java.math.*;\n")
        .append("import java.util.*;\n")
        .append("import static com.aift.lukie.utilities.Utils.*;\n")
        .append("import lombok.Getter;\n");

        ///define whether need to import timestamp from sql
        boolean timeStampFlag = false;
        for (Map<String,Object> map : resList){
            String columnType = (String) map.get("ColumnType");
            if(columnType.toLowerCase().equals("timestamp")){
                timeStampFlag = true;
                break;
            }
        }
        if (timeStampFlag==true){
            code.append("import java.sql.Timestamp;\n");
        }
        code.append("\n");

        /////////////////////////////// import end //////////////////////////////////

        /////////////////////////////// class header ////////////////////////////////

        /////////// 修改方向 判断resListIndexInfo的长度确定是否有unique_index 去选择append的结果
        
        if (resListIndexInfo.size() == 0 ){
            code.append("@Entity\n")
            .append("@Table(name=" + "\""+this.tableNameOrigin+"\")\n");
        } else {
            code.append("@Entity\n")
            .append("@Table(name=" + "\""+this.tableNameOrigin+"\"," + " uniqueConstraints = {\n");
            //// 开始遍历resListIndexInfo 去输出
            for (int i = 0; i < resListIndexInfo.size(); i++){
                Map<String,Object> dataStripe = resListIndexInfo.get(i);
                
                String indexName = (String) dataStripe.get("IndexName");
                String columnNames = (String) dataStripe.get("ColumnNames");

                System.out.println("indexName >>> "+indexName);
                System.out.println("columnNames >>>" + columnNames);

                code.append("    @UniqueConstraint(name ="+"\""+indexName+"\""+", columnNames = {");

                String[] columns = columnNames.split(",");
                List<String> columnList  = Arrays.asList(columns); 
                for (int j=0;j<columnList.size();j++){
                    String item = columnList.get(j);
                    if (j < columnList.size()-1){
                        code.append("\""+item+"\""+",");
                    }else{
                        code.append("\""+item+"\"");
                    }
                }
                code.append("})");
                if (i < resListIndexInfo.size()-1){
                    code.append(",\n");
                }else{
                    code.append("\n");
                }
            }
            code.append("})\n");
            
        }

        if (pkClassFlag == true){
            code.append("@IdClass("+this.tableName+"Id"+".class)\n");
        }

        code.append("@Getter\n")
        .append("public class " + this.tableName + " implements Serializable {\n\n");/// class brace
        /////////////////////////////// class header end ////////////////////////////////

        ////////////////////////////// constructor ////////////////////////////////////////
        code.append("    public " + this.tableName + "(){}\n\n")/// default constructor
        .append("    public <K> " + this.tableName + "(HashMap<String,K> other)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {\n")///constructor brace
        .append("        for (Map.Entry<String,K> entry:other.entrySet()){\n")///loop brace
        .append("            setElements(this,entry.getKey(),entry.getValue());\n")
        .append("        }\n")///loop brace
        .append("    }\n");
        ////////////////////////////// constructor end ////////////////////////////////////
        
        ////////////////////////////// each column row ////////////////////////////////////
        for (Map<String,Object> map : resList){
            boolean isPK = (boolean) map.get("IsPrimaryKey");
            code.append(generateEachRow(map,isPK));
        }
        ////////////////////////////// each column row end /////////////////////////////////

        ////////////////////////////// toString() //////////////////////////////////////////
        code.append("    @Override\n")
        .append("    public String toString(){\n")///toString() brace
        .append("        return String.format(\n")
        .append("            "+"\""+"{"+"\""+"+\n");

        for (Map<String,Object> map : resList){
            code.append("    \" "+ map.get("ColumnName") + ": \"+" + convertToCamelCase((String) map.get("ColumnName"),false) + "+\n");
        }
        code.append("            "+"\" }\"" )
        .append("    );}\n");/// toString() brace
        //////////////////////////// toString() end /////////////////////////////////////////
        
        /////////////////////////// setAllElements() ////////////////////////////////////////
        code.append("    public "+ this.tableName +" setAllElements(HashMap<String,Object> jsonParam) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{\n")
        .append("        for (Map.Entry<String, Object> entry : jsonParam.entrySet()){\n")
        .append("            setElements(this, entry.getKey(),entry.getValue());\n")
        .append("        }\n")
        .append("        return this;\n")
        .append("    }\n");
        /////////////////////////// setAllElements() end ////////////////////////////////////
        code.append("}\n"); /// class brace
        /////////////////////////// code write end //////////////////////////////////////////
    }

    private StringBuilder generateEachRow(Map<String,Object>map, boolean isPrimaryKey){
        StringBuilder eachRow = new StringBuilder(); 
        String columnName = (String) map.get("ColumnName");
        String columnType = (String) map.get("ColumnType");

        if (isPrimaryKey==true){
            eachRow.append("    @Id\n");
        }
        System.out.println(">>>"+map);
        /// varchar(200) or char(200) if it is not, just int, double, or ...
        String columnSize = null;
        if (columnType.toLowerCase() =="varchar" || columnType.toLowerCase() == "char"){
            columnSize ="(" +(String) map.get("ColumnSize")+")";
            
        } else {
            columnSize = "";
        }

        eachRow.append("    @Column(name = " + "\""+columnName+"\"," + "columnDefinition = " + "\""+columnType + columnSize+"\","+"nullable = "+ map.get("IsNullable") + ")\n" );
        eachRow.append("    private "+ mapSqlColumnTypeToJavaType(columnType) + " " + convertToCamelCase(columnName,false) + ";\n");

        return eachRow;
    }
    public void main(Map<String,Object> resMap, boolean pkClassFlag) throws IOException{
        System.out.println("The enetiy generating process on...\nlukie is generating code for you now...");

        generateClassFile(resMap, pkClassFlag);

        System.out.println("The entity code generating process finished...\ntry to save the code...");
        // finished and save to file  
        String currentDir = System.getProperty("user.dir");
        String relativePath = this.entityPath; /// read from yaml
        String absolutePath = currentDir + relativePath;
        String filePath = absolutePath + this.tableName +".java";

        System.out.println("filePath >>>>>" + filePath);
        
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
        System.out.println("The entity generation finished ... good bye!");
    }
}
