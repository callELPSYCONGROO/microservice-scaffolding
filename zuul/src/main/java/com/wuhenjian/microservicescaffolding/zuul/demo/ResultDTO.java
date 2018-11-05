package com.wuhenjian.microservicescaffolding.zuul.demo;

import lombok.Builder;
import lombok.Data;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:39
 */
@Data
@Builder
public class ResultDTO {

	private Integer code;

	private String msg;
}
