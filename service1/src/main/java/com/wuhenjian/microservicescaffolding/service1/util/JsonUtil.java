package com.wuhenjian.microservicescaffolding.service1.util;

import com.alibaba.fastjson.JSON;
import com.wuhenjian.microservicescaffolding.service1.domain.dto.ResultDTO;

import java.util.List;

/**
 * @author 無痕剑
 * @date 2019/6/18 1:16
 */
public class JsonUtil {

	private JsonUtil() {}

	public static <T> List<T> json2Obj(ResultDTO resultDTO, Class<T> tClass) {
		return JSON.parseArray(JSON.toJSONString(resultDTO), tClass);
	}
}
