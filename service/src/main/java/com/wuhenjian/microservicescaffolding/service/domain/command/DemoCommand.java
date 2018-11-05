package com.wuhenjian.microservicescaffolding.service.domain.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:03
 */
@Data
public class DemoCommand {

	@NotNull(message = "请求参数不能为空")
	@ApiModelProperty("参数")
	private String demo;
}
