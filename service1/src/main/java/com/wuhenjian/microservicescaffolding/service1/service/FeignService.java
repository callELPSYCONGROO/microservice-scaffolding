package com.wuhenjian.microservicescaffolding.service1.service;

import com.wuhenjian.microservicescaffolding.service1.service.impl.FeignServiceFallback;
import com.wuhenjian.microservicescaffolding.util.domain.dto.ResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 無痕剑
 * @date 2019/6/18 1:11
 */
@FeignClient(value = "service2", fallback = FeignServiceFallback.class, path = FeignService.BASE_PATH)
public interface FeignService {

	String BASE_PATH = "/demo";

	@GetMapping("/b/single")
	ResultDTO getBSingle();

	@GetMapping("/b")
	ResultDTO getB(@RequestParam("aId") Integer aId);

	@GetMapping("/c/single")
	ResultDTO getCSingle();

	@GetMapping("/c")
	ResultDTO getC(@RequestParam("bId") Integer bId);
}
