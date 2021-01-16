package com.wuhenjian.microservicescaffolding.gateway.config;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author 無痕剑
 * @date 2021/1/15 0015 16:49
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GatewayNacosConfig {

    private final NacosConfigProperties nacosConfigProperties;

    @Value("${spring.cloud.nacos.gateway.route.data}")
    private String gatewayRouteConfigDataId;

    /**
     * 获取网关配置
     *
     * @return 配置文本
     * @throws NacosException Nacos链接、获取配置异常
     */
    public String getConfig() throws NacosException {
        return NacosFactory.createConfigService(buildProperties())
                .getConfig(gatewayRouteConfigDataId, nacosConfigProperties.getGroup(), nacosConfigProperties.getTimeout());
    }

    /**
     * 增加网关配置监听器
     *
     * @param listener 监听器对象
     * @throws NacosException Nacos链接异常
     */
    public void addListener(Listener listener) throws NacosException {
        NacosFactory.createConfigService(buildProperties())
                .addListener(gatewayRouteConfigDataId, nacosConfigProperties.getGroup(), listener);
    }

    /**
     * 创建配置
     *
     * @return 配置
     */
    private Properties buildProperties() {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.NAMESPACE, nacosConfigProperties.getNamespace());
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, nacosConfigProperties.getServerAddr());
        return properties;
    }
}
