package com.starts.turingclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@ServletComponentScan
@EnableFeignClients
@Configuration
public class TuringClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(TuringClientApplication.class, args);

    }

}
