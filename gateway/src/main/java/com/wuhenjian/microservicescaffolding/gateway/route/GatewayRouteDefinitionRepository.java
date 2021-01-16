package com.wuhenjian.microservicescaffolding.gateway.route;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.exception.NacosException;
import com.wuhenjian.microservicescaffolding.gateway.config.GatewayNacosConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SpringCloud Gateway自动配置{@link GatewayAutoConfiguration#inMemoryRouteDefinitionRepository()}中，
 * {@code RouteDefinitionRepository}接口的实现{@code InMemoryRouteDefinitionRepository}来管理本地配置的路由。
 * 将路由配置由本地缓存迁移到nacos中，这里自定义{@code RouteDefinitionRepository}接口。
 *
 * @author 無痕剑
 * @date 2021/1/15 0015 15:26
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GatewayRouteDefinitionRepository implements RouteDefinitionRepository {

    /**
     * 本地缓存，减少请求nacos的次数
     */
    private static final List<RouteDefinition> LOCAL_ROUTE_CACHE = Collections.synchronizedList(new ArrayList<>());

    private final GatewayNacosConfig gatewayNacosConfig;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        if (CollectionUtils.isEmpty(LOCAL_ROUTE_CACHE)) {
            save(null);
        }

        return Flux.fromIterable(LOCAL_ROUTE_CACHE);
    }

    /**
     * 这里用这个方法来提供路由配置修改，方便其他业务调用而已，其实现并不是方法表达的意义
     *
     * @param route 该参数未使用
     * @return 空
     */
    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        String content;
        try {
            content = gatewayNacosConfig.getConfig();
        } catch (NacosException e) {
            log.error("获取nacos中网关路由配置时发生异常", e);
            return Mono.empty();
        }

        log.info("获取到网关路由配置：\n{}", content);
        List<RouteDefinition> routeDefinitionList;
        try {
            routeDefinitionList = JSON.parseArray(content, RouteDefinition.class);
        } catch (Exception e) {
            log.error("网关路由配置格式异常", e);
            return Mono.empty();
        }

        if (CollectionUtils.isEmpty(routeDefinitionList)) {
            log.info("网关路由配置为空");
            return Mono.empty();
        }

        LOCAL_ROUTE_CACHE.clear();
        LOCAL_ROUTE_CACHE.addAll(routeDefinitionList);
        return Mono.empty();
    }

    /**
     * 删除所以路由配置
     *
     * @param routeId 该参数未使用
     * @return 空
     */
    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        LOCAL_ROUTE_CACHE.clear();
        return Mono.empty();
    }
}
