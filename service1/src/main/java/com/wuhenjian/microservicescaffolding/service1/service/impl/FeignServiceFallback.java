package com.wuhenjian.microservicescaffolding.service1.service.impl;

import com.wuhenjian.microservicescaffolding.service1.domain.dto.ResultDTO;
import com.wuhenjian.microservicescaffolding.service1.exception.DemoException;
import com.wuhenjian.microservicescaffolding.service1.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @author 無痕剑
 * @date 2019/6/18 1:12
 */
@Component
public class FeignServiceFallback implements FeignService {
	@Override
	public ResultDTO getBSingle() {
		throw new DemoException(16, "getBSingle");
	}

	@Override
	public ResultDTO getB(Integer aId) {
		throw new DemoException(21, "getB");
	}

	@Override
	public ResultDTO getCSingle() {
		throw new DemoException(26, "getCSingle");
	}

	@Override
	public ResultDTO getC(Integer bId) {
		throw new DemoException(31, "getC");
	}
}
