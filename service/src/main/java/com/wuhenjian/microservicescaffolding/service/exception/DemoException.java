package com.wuhenjian.microservicescaffolding.service.exception;

import lombok.Data;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:31
 */
@Data
public class DemoException extends RuntimeException {

	private Integer code;

	private String msg;
}
