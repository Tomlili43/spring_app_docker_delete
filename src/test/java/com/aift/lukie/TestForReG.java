package com.aift.lukie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aift.lukie.LukieApplication;
import com.aift.lukie.Service.innerService.ReGService;


@SpringBootTest(classes = LukieApplication.class)
public class TestForReG {

    @Autowired
    private ReGService reGService;

    @Test
    public void main() throws Exception {

        reGService.execute();

    }
}
