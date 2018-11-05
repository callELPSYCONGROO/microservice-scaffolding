package com.wuhenjian.microservicescaffolding.service.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:04
 */
@Data
public class DemoEntity {

	@ApiModelProperty("demo")
	private String demo;
}
