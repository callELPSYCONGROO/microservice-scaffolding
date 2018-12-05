package com.wuhenjian.microservicescaffolding.service.config.config;

import feign.Client;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 無痕剑
 * @date 2018/11/27 23:38
 */
@Configuration
public class DynamicRouteFeignConfig {

	@Bean
	public Client feignClient(CachingSpringLoadBalancerFactory cachingFactory, SpringClientFactory clientFactory) {
		return new DynamicRouteFeignClient(new Client.Default(null, null), cachingFactory, clientFactory);
	}
}
