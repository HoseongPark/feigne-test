package com.example.feignetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeigneTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeigneTestApplication.class, args);
    }

}
