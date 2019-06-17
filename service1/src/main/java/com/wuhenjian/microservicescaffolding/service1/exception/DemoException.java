package com.wuhenjian.microservicescaffolding.service1.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoException extends RuntimeException {

	private Integer code;

	private String msg;
}
