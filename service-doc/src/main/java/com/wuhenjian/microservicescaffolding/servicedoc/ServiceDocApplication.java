package com.wuhenjian.microservicescaffolding.servicedoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceDocApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDocApplication.class, args);
    }
}
