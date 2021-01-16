package com.wuhenjian.microservicescaffolding.gateway.route;

import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.wuhenjian.microservicescaffolding.gateway.config.GatewayNacosConfig;
import com.wuhenjian.microservicescaffolding.util.exception.DemoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;

/**
 * 网关路由热更新。
 * 获取到配置更新后，更新本进程的网关配置。
 *
 * @author 無痕剑
 * @date 2021/1/15 0015 16:18
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GatewayRouteHotUpdateService implements ApplicationEventPublisherAware {

    private final GatewayRouteDefinitionRepository gatewayRouteDefinitionRepository;

    private final GatewayNacosConfig gatewayNacosConfig;

    private ApplicationEventPublisher applicationEventPublisher;

    @Value("${spring.cloud.nacos.gateway.route.data}")
    private String gatewayRouteConfigDataId;

    @PostConstruct
    public void initListener() {
        try {
            gatewayNacosConfig.addListener(changeListener());
        } catch (NacosException e) {
            log.error(e.getErrMsg(), e);
            throw new DemoException(e.getErrCode(), "配置网关监听器时，发生异常：" + e.getErrMsg());
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 配置改变监听器
     *
     * @return 监听器对象
     */
    private Listener changeListener() {
        return new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                // 获取到更新，刷新GatewayRouteDefinitionRepository的本地缓存
                gatewayRouteDefinitionRepository.save(null);
                // 推送事件，网关框架执行org.springframework.cloud.gateway.route.RouteDefinitionLocator.getRouteDefinitions()方法
                applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
            }
        };
    }
}
