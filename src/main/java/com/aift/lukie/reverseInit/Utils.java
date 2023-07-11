package com.aift.lukie.reverseInit;

import java.util.*;

public class Utils {
    //////////////////
    /// tools class///
    ///    工具栏   ///
    //////////////////

    public static String convertToCamelCase(String input){
        return convertToCamelCase(input,true);
    }

    public static String convertToCamelCase(String input, boolean capitalizeFirstLetter) {
        StringBuilder camelCaseString = new StringBuilder();

        input = input.replaceAll("\\s", ""); ///remove space
        input = replaceDigitsWithLetters(input);/// remove numerical value

        if (!input.contains("_")) {
            if (capitalizeFirstLetter) {
                camelCaseString = new StringBuilder(input.toLowerCase());
                camelCaseString.setCharAt(0, Character.toUpperCase(camelCaseString.charAt(0)));
            }else{
                camelCaseString = new StringBuilder(input);
            }
        } else {
            String[] parts = input.split("_");
            for (int i = 0; i < parts.length; i++) {
                String part = parts[i];
                if (part.length() > 0) {
                    if (i == 0 && !capitalizeFirstLetter) {
                        camelCaseString.append(part.toLowerCase());
                    } else {
                        camelCaseString.append(Character.toUpperCase(part.charAt(0)));
                        if (part.length() > 1) {
                            camelCaseString.append(part.substring(1).toLowerCase());
                        }
                    }
                }
            }
        }
        return camelCaseString.toString();
    }

    public static Object mapSqlColumnTypeToJavaType(String columnType){

        columnType = columnType.toUpperCase();/// convert all to upper case
        String res = null; 

        switch(columnType){
            case "BIT":
            case "BOOLEAN":
                res = "Boolean";
                break;
                
            case "INTEGER":
            case "INT":
            case "SMALLINT":
            case "TINYINT":
                res = "Integer";
                break;

            case "BIGINT":
                res = "BigInterger";
                break;

            case "FLOAT":
                res = "Float";
                break;

            case "REAL":
            case "DOUBLE":
            case "DECIMAL":
                res = "Double";
                break;
                
            case "CHAR":
            case "VARCHAR":
            case "LONGVARCHAR":
            case "TEXT":
            case "LONGTEXT":
                res = "String";
                break;

            case "NUMERIC":
                res = "Long";
                break;

            case "DATE":
            case "DATETIME":
                res = "Date";
                break;

            case "TIME":
                res = "Time";
                break;

            case "TIMESTAMP":
                res = "Timestamp";
                break;
                
            case "BINARY":
            case "VARBINARY":
            case "LONGVARBINARY":
                res = "Byte[]";
                break;
        }
        return res;
    }

    public static String replaceDigitsWithLetters(String input) {
        // 定义数字和字母的映射表
        Map<Character, String> digitToLetterMap = new HashMap<>();
        digitToLetterMap.put('0', "zero");
        digitToLetterMap.put('1', "one");
        digitToLetterMap.put('2', "two");
        digitToLetterMap.put('3', "three");
        digitToLetterMap.put('4', "four");
        digitToLetterMap.put('5', "five");
        digitToLetterMap.put('6', "six");
        digitToLetterMap.put('7', "seven");
        digitToLetterMap.put('8', "eight");
        digitToLetterMap.put('9', "nine");
    
        // 将数字替换为字母
        for (char digit : digitToLetterMap.keySet()) {
            String letter = digitToLetterMap.get(digit);
            input = input.replaceAll(String.valueOf(digit), String.valueOf(letter));
        }
    
        return input;
    }

}
