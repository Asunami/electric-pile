package com.qifa.pileportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qifa.pileportal.dao")
public class PilePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PilePortalApplication.class, args);
    }

}
