package com.hh.layuidemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hh.layuidemo.mapper")
public class LayuidemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LayuidemoApplication.class, args);
    }

}
