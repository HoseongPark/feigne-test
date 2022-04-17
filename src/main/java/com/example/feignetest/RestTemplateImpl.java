package com.example.feignetest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateImpl {

    @Bean
    public RestTemplate template(RestTemplateBuilder builder) {
        return builder.build();
    }
}
