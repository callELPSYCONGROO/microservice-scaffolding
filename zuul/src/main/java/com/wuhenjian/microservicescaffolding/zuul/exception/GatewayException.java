package com.wuhenjian.microservicescaffolding.zuul.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 网关异常
 * @author SwordNoTrace
 * @date 2018/8/22 23:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GatewayException extends RuntimeException {

	private Integer code;

	private String msg;

	public static GatewayException build() {
		return new GatewayException();
	}
}
