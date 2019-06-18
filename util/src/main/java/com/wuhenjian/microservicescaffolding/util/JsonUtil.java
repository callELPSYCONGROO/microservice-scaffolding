package com.wuhenjian.microservicescaffolding.util;

import com.alibaba.fastjson.JSON;
import com.wuhenjian.microservicescaffolding.util.domain.dto.ResultDTO;
import com.wuhenjian.microservicescaffolding.util.exception.DemoException;

import java.util.List;

/**
 * @author 無痕剑
 * @date 2019/6/18 1:16
 */
public class JsonUtil {

	private JsonUtil() {}

	public static <T> List<T> json2Obj(ResultDTO resultDTO, Class<T> tClass) {
		if (resultDTO.getCode() != 1000) {
			throw new DemoException(resultDTO.getCode(), resultDTO.getMsg());
		}
		return JSON.parseArray(JSON.toJSONString(resultDTO.getData()), tClass);
	}
}
