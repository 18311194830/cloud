package com.rht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConfigConsumerMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigConsumerMain3366.class,args);
    }
}
