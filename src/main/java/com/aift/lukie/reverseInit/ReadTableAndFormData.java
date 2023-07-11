package com.aift.lukie.reverseInit;

import java.lang.reflect.Field;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.*;

import lombok.Setter;
import static com.aift.lukie.utilities.Utils.*;

@Setter

public class ReadTableAndFormData {
    // private String url ="jdbc:mysql://192.168.2.108:3306/data?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    // private String user = "changliu";
    // private String password = "CityU951027";
    // private String database = "'data'";
    // private String tableName = "'asin_basic_info'";
    private String url;
    private String user;
    private String password;
    private String database;
    private String tableName;

    public ReadTableAndFormData(){};

    public ReadTableAndFormData(String url,String user,String password,String database,String tableName){
        this.url = url;
        this.user = user;
        this.password = password;
        this.database = database;
        this.tableName = tableName;
    };

    public ReadTableAndFormData(Map<String,Object> settingsMap) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
        /// confirm how many field of settings you got in the class
        List<String> fieldList = new ArrayList<String>();
        Class<?> myClass = this.getClass();
        Field[] fields = myClass.getDeclaredFields();

        for (Field field: fields){
            String name = field.getName();
            fieldList.add(name);
        }
        
        /// match the settings
        for(Map.Entry<String,Object> entry: settingsMap.entrySet()){
            String key = entry.getKey();
            String value = (String) entry.getValue();
            
            if (fieldList.contains(key)){
                setElements(this,key,value);
            }
        }

        for(int i=0;i<fieldList.size();i++){
            String value = fieldList.get(i);
            Field field = myClass.getDeclaredField(value);

            field.setAccessible(true);
            Object fieldValue = field.get(this);
            if (fieldValue == null) {
                throw new IllegalStateException(value + " is not set");
            }
        }
        System.out.println(">>>>>>>>>> Configuration set up! go for fetch meta data from table...");
    }

    // @Autowired
    // private JdbcTemplate jdbcTemplate;

    public Map<String,Object> generateDataList() throws Exception {
        
        System.out.println("starting revese engeering!!!");

        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("connection build");
        Statement statement = connection.createStatement();
        System.out.println("statement go on");
        String sqlStatement = String.format("SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_KEY, CHARACTER_MAXIMUM_LENGTH "+
                    "FROM INFORMATION_SCHEMA.COLUMNS "+
                    "WHERE TABLE_SCHEMA = \"%s\" AND TABLE_NAME = \"%s\"",this.database,this.tableName);

        System.out.println(sqlStatement);
        ResultSet resultSet = statement.executeQuery(sqlStatement);
        
        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
        while (resultSet.next()) {
            String columnName = resultSet.getString("COLUMN_NAME");
            String columnType = resultSet.getString("DATA_TYPE");
            long columnSize = resultSet.getLong("CHARACTER_MAXIMUM_LENGTH");
            boolean isNullable = resultSet.getString("IS_NULLABLE").equals("YES");
            boolean isPrimaryKey = resultSet.getString("COLUMN_KEY").equals("PRI");

            /// column information prepared 
            Map<String,Object> resultMap = new HashMap<String,Object>();
            resultMap.put("ColumnName", columnName);
            resultMap.put("ColumnType", columnType);
            resultMap.put("ColumnSize", columnSize);
            resultMap.put("IsNullable", isNullable);
            resultMap.put("IsPrimaryKey", isPrimaryKey);
            resultList.add(resultMap);

        }
        resultSet.close();

        String sqlStatementSecond = String.format("SELECT DISTINCT INDEX_NAME, GROUP_CONCAT(DISTINCT COLUMN_NAME ORDER BY SEQ_IN_INDEX) AS COLUMN_NAMES\n"+
        "FROM INFORMATION_SCHEMA.STATISTICS\n"+
        "WHERE TABLE_SCHEMA = \"%s\" AND TABLE_NAME = \"%s\" AND NON_UNIQUE = 0\n"+
        "GROUP BY INDEX_NAME",this.database,this.tableName);
        System.out.println(sqlStatementSecond);
        ResultSet resultSetSecond = statement.executeQuery(sqlStatementSecond);
        
        List<Map<String,Object>> resultListSecond = new ArrayList<Map<String,Object>>();
        while (resultSetSecond.next()) {
            String indexName = resultSetSecond.getString("INDEX_NAME");
            String columnNames = resultSetSecond.getString("COLUMN_NAMES");
            /// index informaton prepared
            
            if (!indexName.equals("PRIMARY")){
                Map<String,Object> resultMap = new HashMap<String,Object>();
                resultMap.put("IndexName",indexName);
                resultMap.put("ColumnNames",columnNames);
                resultListSecond.add(resultMap);
            }
        }
        resultSetSecond.close();
        
        /// close all sql statment executor, close connection to database.
        statement.close();
        connection.close();

        Map finalResMap = new HashMap<String,Object>();
        finalResMap.put("tableName",tableName);
        finalResMap.put("columnInfo",resultList);
        finalResMap.put("indexInfo",resultListSecond);


        return finalResMap;
    }
}
