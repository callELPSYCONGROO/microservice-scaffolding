package com.wuhenjian.microservicescaffolding.service2.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DemoException extends RuntimeException {

	private Integer code;

	private String msg;
}
