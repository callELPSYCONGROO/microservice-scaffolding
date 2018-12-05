package com.wuhenjian.microservicescaffolding.service.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * API接口文档启动配置
 * @author: Overload
 * @review:
 * @date: 2018/6/22 10:46
 * @version: 1.0
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api(ApiInfo apiInfo) {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.wuhenjian.microservicescaffolding.service.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	public ApiInfo apiInfo() {
		String description = "demo服务接口文档描述";
		return new ApiInfoBuilder()
				.title("DEMO服务API接口文档")
				.description(description)
				.version("1.0")
				.build();
	}
}
