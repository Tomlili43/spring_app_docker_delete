package com.aift.lukie.utilities;

import java.lang.reflect.Field;
import java.util.*;

/**
 * define the utitlites tools here
 */
public class Utils {
    public static void setElements(Object obj,String fieldName, Object value)throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Field elementField = obj.getClass().getDeclaredField(fieldName);
        elementField.setAccessible(true);
        elementField.set(obj,value);
    }
    
    public static Map<String,Object> convertObjectToMap(Object obj) throws IllegalArgumentException, IllegalAccessException{
        Map<String,Object> map = new HashMap<String,Object>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            String fieldName = field.getName();
            Object fieldValue = field.get(obj);
            map.put(fieldName,fieldValue);
        }
        return map;
    }

}
