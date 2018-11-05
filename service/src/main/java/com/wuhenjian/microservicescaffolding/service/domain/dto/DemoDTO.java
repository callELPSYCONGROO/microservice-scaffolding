package com.wuhenjian.microservicescaffolding.service.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:03
 */
@Builder
@Data
public class DemoDTO {

	@ApiModelProperty("错误码")
	private Integer code;

	@ApiModelProperty("错误信息")
	private String msg;

	@ApiModelProperty("结果")
	private Object data;
}
