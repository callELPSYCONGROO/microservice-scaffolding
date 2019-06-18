package com.wuhenjian.microservicescaffolding.util.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 無痕剑
 * @date 2019/6/17 23:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {

	private Integer code;

	private String msg;

	private Object data;

	public static ResultDTO success(Object data) {
		return new ResultDTO(1000, "success", data);
	}

	public static ResultDTO fail(Integer code, String msg) {
		return new ResultDTO(code, msg, null);
	}
}
