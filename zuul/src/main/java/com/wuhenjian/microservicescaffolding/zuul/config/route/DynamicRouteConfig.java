package com.wuhenjian.microservicescaffolding.zuul.config.route;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 动态路由配置
 * @author: Overload
 * @review:
 * @date: 2018/11/22 9:29
 */
@Configuration
public class DynamicRouteConfig {

    @Value("${gateway.routes.dynamic.enabled}")
    private boolean enabledDynamicRoute;

    /**
     * 使用自定义的路由策略代替默认路由策略
     */
    @Bean
    public SimpleRouteLocator routeLocator(ZuulProperties zuulProperties) {
        return new DynamicRouteLocator(enabledDynamicRoute, zuulProperties.getPrefix(), zuulProperties);
    }
}
