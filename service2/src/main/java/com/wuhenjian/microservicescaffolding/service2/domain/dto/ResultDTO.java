package com.wuhenjian.microservicescaffolding.service2.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author 無痕剑
 * @date 2019/6/17 23:46
 */
@Builder
@Data
public class ResultDTO {

	private Integer code;

	private String msg;

	private Object data;

	public static ResultDTO success(Object data) {
		return ResultDTO.builder().code(1000).msg("success").data(data).build();
	}

	public static ResultDTO fail(Integer code, String msg) {
		return ResultDTO.builder().code(code).msg(msg).build();
	}
}
