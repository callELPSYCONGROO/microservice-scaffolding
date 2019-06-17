package com.wuhenjian.microservicescaffolding.service1.service;

import com.wuhenjian.microservicescaffolding.service1.domain.dto.ResultDTO;
import com.wuhenjian.microservicescaffolding.service1.service.impl.FeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 無痕剑
 * @date 2019/6/18 1:11
 */
@FeignClient(value = "service2", contextId = "feignService", fallback = FeignServiceFallback.class)
public interface FeignService {

	@GetMapping("/b/single")
	ResultDTO getBSingle();

	@GetMapping("/b")
	ResultDTO getB(@RequestParam("aId") Integer aId);

	@GetMapping("/c/single")
	ResultDTO getCSingle();

	@GetMapping("/c")
	ResultDTO getC(@RequestParam("bId")Integer bId);
}
