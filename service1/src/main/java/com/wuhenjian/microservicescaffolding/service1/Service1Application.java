package com.wuhenjian.microservicescaffolding.service1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wuhenjian.microservicescaffolding.service1.service")
@MapperScan(basePackages = "com.wuhenjian.microservicescaffolding.util.mapper")
@SpringBootApplication(scanBasePackages = "com.wuhenjian.microservicescaffolding")
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
}
