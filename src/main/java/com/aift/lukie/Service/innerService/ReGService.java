package com.aift.lukie.Service.innerService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.reverseInit.MyDatabaseTool;
import com.aift.lukie.utilities.ReverseConfigProperties;

@Service
public class ReGService {
    @Autowired
    ReverseConfigProperties config;
    
    public void execute() throws Exception{
        MyDatabaseTool myDatabaseTool = new MyDatabaseTool(config);
        myDatabaseTool.execute();
    }
}
