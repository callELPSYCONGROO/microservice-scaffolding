package com.wuhenjian.microservicescaffolding.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: 加农炮
 * @review:
 * @date: 2018/8/28 14:20
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    @Bean
    public ApiInfo apiInfo() {
        String description = "在网关层可以直接查看所用服务的swagger文档";
        return new ApiInfoBuilder()
                .title("服务API接口文档")
                .description(description)
                .version("1.0")
                .build();
    }
}
