package com.lcj.smartclub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lcj.smartclub.mapper")
public class SmartclubApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartclubApplication.class, args);
    }

}
