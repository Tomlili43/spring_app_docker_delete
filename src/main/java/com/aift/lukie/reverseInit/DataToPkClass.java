package com.aift.lukie.reverseInit;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import lombok.Getter;
import java.lang.reflect.Field;

import static com.aift.lukie.reverseInit.Utils.*;
import static com.aift.lukie.utilities.Utils.*;

@Getter
public class DataToPkClass {

    private List<Map<String,Object>> pkList = new ArrayList<Map<String,Object>>();
    private String tableNameOrigin;
    private String tableName;
    private String tableNameVariable;
    private StringBuilder code = new StringBuilder();
    public String entityPackage;
    public String entityPath;

    public DataToPkClass(Map<String,Object> configMap) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{

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
    }

    public void preparePkList(Map<String,Object> resMap){
        
        this.tableNameOrigin =(String) resMap.get("tableName");
        this.tableName = tableNameOrigin.trim().replaceAll("'", "");
        this.tableName = convertToCamelCase(this.tableName); /// convert to capital letter
        Object value = resMap.get("columnInfo"); // 获取唯一键对应的值
        List<Map<String,Object>> resList = (List<Map<String,Object>>) value;// convert obj to list

        for (Map<String,Object> map : resList){
            boolean isPK = (boolean) map.get("IsPrimaryKey");
            if(isPK){
                this.pkList.add(map);
            }
        }
    }

    private void primaryKeyClassCreator() throws IOException{

        boolean timeStampFlag = false;
        for (Map<String,Object> map : this.pkList){
            String columnType = (String) map.get("ColumnType");
            if(columnType.toLowerCase().equals("timestamp")){
                timeStampFlag = true;
                break;
            }
        }
        /// convert tableName and tableNameVarible
        this.tableName = convertToCamelCase(this.tableNameOrigin);
        this.tableNameVariable = convertToCamelCase(this.tableNameOrigin, false);

        code.append("package "+this.entityPackage+";\n") /// read from yaml
        .append("import "+this.entityPackage+"."+this.tableName+";\n") /// read from yaml
        .append("import java.util.*;\n")
        .append("import java.io.Serializable;\n");
        if(timeStampFlag){
            code.append("import java.sql.Timestamp;\n");
        }

        code.append("public class " + (String) this.tableName +"Id" + " implements Serializable {\n"); /// class brace
    
        for (Map<String,Object> map : pkList){
            String columnName = (String) map.get("ColumnName");
            String columnType = (String) map.get("ColumnType");
            Object convertColumnType = mapSqlColumnTypeToJavaType(columnType);
            columnName = convertToCamelCase(columnName,false);

            code.append("    private "+ convertColumnType + " " + columnName + ";\n");
            }
        
        code.append("    @Override\n")
        .append("    public boolean equals(Object o) {\n")
        .append("        if (this == o) return true;\n")
        .append("        if (o == null || getClass() != o.getClass()) return false;\n")
        .append("        " + this.tableName + " " + this.tableNameVariable + " = ("+this.tableName+") " + "o;\n" ); 
        
        int count = 0;
        boolean isFirst = true;
        for (Map<String,Object> map : pkList){
            String columnName = (String) map.get("ColumnName");
            columnName = convertToCamelCase(columnName,false);
            String columnNameMethod = convertToCamelCase((String) map.get("ColumnName"),true);
            count++;
            if (isFirst){
                code.append("        return Objects.equals("+columnName+","+this.tableNameVariable+".get"+columnNameMethod+"()"+") "+"&&\n");
                isFirst = false;
            } else if(count==pkList.size()){
                code.append("            Objects.equals("+columnName+","+this.tableNameVariable+".get"+columnNameMethod+"()"+");\n");
            } else {
                code.append("            Objects.equals("+columnName+","+this.tableNameVariable+".get"+columnNameMethod+"()"+") "+"&&\n");
            }
        }
        code.append("    }\n")///equal method brace
        .append("    @Override\n")
        .append("    public int hashCode(){\n")
        .append("        return Objects.hash(");

        count = 0;
        for (Map<String,Object> map : pkList){
            String columnName = (String) map.get("ColumnName");
            columnName = convertToCamelCase(columnName,false);
            count++;
            if (count!=pkList.size()){
                code.append(columnName+",");
            } else {
                code.append(columnName+");\n");
            }
        }
        code.append("    }\n") /// hasCode method brace
        .append("}\n"); /// class brace 
    }

    public boolean main(Map<String,Object> resMap) throws IOException{
        System.out.println("prepare Primary Key List and code related...");

        this.preparePkList(resMap); /// generate pk list fisrt to indetify whether has composite pk

        System.out.println("Generating code finished...");

        boolean pkClassFlag = false;

        if(this.pkList.stream().count() > 1){
            this.primaryKeyClassCreator();
            // finished and save to file  
            String currentDir = System.getProperty("user.dir");
            String relativePath = this.entityPath; /// read from yaml
            String absolutePath = currentDir + relativePath;
            String filePath = new String(absolutePath + this.tableName+"Id" +".java");

            File file = new File(filePath);
            if(!file.exists()){
                file.createNewFile();
                // Write data to the file
                FileWriter writer = new FileWriter(file);
                writer.write(this.code.toString());
                writer.close();
                System.out.println(this.tableName+"Id.java" + "finished generation... good bye!");
                pkClassFlag = true;

            } else {
                System.out.println("file name exists --"+this.tableName+"Id");
            }

        } else {
            System.out.println(this.tableName+"does not have composite primary key...");
        }

        return pkClassFlag;
    }
    
}
