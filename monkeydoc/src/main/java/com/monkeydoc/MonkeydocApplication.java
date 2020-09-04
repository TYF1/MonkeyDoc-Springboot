package com.monkeydoc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@MapperScan("com.monkeydoc.mapper")
@SpringBootApplication
public class MonkeydocApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonkeydocApplication.class, args);
    }

}
