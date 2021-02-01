package com.wuhenjian.microservicescaffolding.service2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Swagger 配置
 *
 * @author 無痕剑
 * @date 2021/1/21 0021 10:57
 */
@Configuration
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${spring.application.name-desc}")
	private String applicationNameDesc;

	@Bean
	public Docket docket() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title(applicationName)
				.description(applicationNameDesc)
				.build();
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.wuhenjian.microservicescaffolding.service2.controller"))
				.paths(PathSelectors.any())
				.build()
				;
	}
}
