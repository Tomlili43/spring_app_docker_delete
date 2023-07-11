// package com.aift.lukie;

// import java.util.*;
// import java.util.logging.*;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.internal.matchers.Null;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import com.aift.lukie.Model.Primary.MonthAll;
// import com.aift.lukie.Service.outterService.MonthAllService;

// /// Testing service can do over here ///

// @ExtendWith(SpringExtension.class)
// @SpringBootTest
// public class outterServiceTests {
    
//     @Autowired
//     private MonthAllService monthAllService;

//     /// setting logger
//     public Logger logger = Logger.getLogger(outterServiceTests.class.getName());

//     @Test
//     public void testGetMonthAllByProductIdAndMonthAndYear() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

//         // ////find by year and month test
//         // HashMap<String,Object> jsonParam = new HashMap<String,Object>(){{
//         //     put("productId","0000084034");
//         //     put("month",4);
//         //     put("year",2023);
//         // }};


//         // MonthAll res = monthAllService.findByProductIdAndMonthAndYear(jsonParam);
//         // if (res != null){
//         //     logger.info(res.toString());
//         // } else{
//         //     logger.info("empty!");
//         // }

//         ////find by product id test 
//         // List<MonthAll> res = monthAllService.findByProductId("0000084034");
//         // if (res != null){
//         //     for(int i=0;i<res.size();i++)    {   
//         //         MonthAll item = res.get(i);   
//         //         logger.info(item.toString());
//         //     }    
//         // } else{
//         //     logger.info("empty!");
//         // }
//         //
        
//         // //// bulk find and create test
//         // List<HashMap<String,Object>> jsonParamList = new ArrayList<HashMap<String,Object>>(){{
//         //     HashMap<String,Object> myMap = new HashMap<String,Object>(){
//         //         {
//         //             put("productId","test");
//         //             put("year",2022);
//         //             put("month", 1);
//         //         }
//         //     };
//         //     add(myMap);
//         // }};
//         // // logger.info(jsonParamList.toString());

//         // //// bulk find and update test
//         // List<HashMap<String,Object>> jsonParamList = new ArrayList<HashMap<String,Object>>(){{
//         //     HashMap<String,Object> myMap = new HashMap<String,Object>(){
//         //         {
//         //             put("productId","test");
//         //             put("year",2022);
//         //             put("month", 1);
//         //             put("sales",Double.valueOf(1000));
//         //         }
//         //     };

//         //     HashMap<String,Object> myMap2 = new HashMap<String,Object>(){
//         //         {
//         //             put("productId","test2");
//         //             put("year",2223);
//         //             put("month", 1);
//         //         }
//         //     };

//         //     add(myMap);
//         //     add(myMap2);
//         // }};
//         // // logger.info(jsonParamList.toString());

//         // Object res = monthAllService.bulkfindAndUpdate(jsonParamList);
//         // logger.info(res.toString());
//     }
// }
