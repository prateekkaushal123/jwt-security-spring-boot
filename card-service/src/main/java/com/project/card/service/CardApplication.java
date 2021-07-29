package com.project.card.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class CardApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(CardApplication.class, args);
    }
}
