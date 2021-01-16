package com.wuhenjian.microservicescaffolding.service2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RefreshScope
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wuhenjian.microservicescaffolding.service2.service")
@MapperScan(basePackages = "com.wuhenjian.microservicescaffolding.util.mapper")
@SpringBootApplication(scanBasePackages = "com.wuhenjian.microservicescaffolding")
public class Service2Application {

	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}
}
