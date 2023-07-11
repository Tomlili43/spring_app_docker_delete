package com.aift.lukie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@SpringBootConfiguration
@ServletComponentScan
public class LukieApplication {

	public static void main(String[] args) {
		SpringApplication.run(LukieApplication.class, args);
	}

}


