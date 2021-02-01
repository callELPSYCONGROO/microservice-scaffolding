package com.wuhenjian.microservicescaffolding.util.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 無痕剑
 * @date 2019/6/17 23:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "响应结果", description = "统一响应")
public class ResultDTO {

	@ApiModelProperty("响应码")
	private Integer code;

	@ApiModelProperty("响应信息")
	private String msg;

	@ApiModelProperty("响应数据")
	private Object data;

	public static ResultDTO success(Object data) {
		return new ResultDTO(1000, "success", data);
	}

	public static ResultDTO fail(Integer code, String msg) {
		return new ResultDTO(code, msg, null);
	}
}
