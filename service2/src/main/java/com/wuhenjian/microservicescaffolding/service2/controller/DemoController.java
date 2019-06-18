package com.wuhenjian.microservicescaffolding.service2.controller;

import com.wuhenjian.microservicescaffolding.util.domain.dto.ResultDTO;
import com.wuhenjian.microservicescaffolding.service2.service.DemoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:02
 */
@Api("demo")
@RestController
@RequestMapping("/demo")
public class DemoController {

	private final DemoService demoService;

	@Autowired
	public DemoController(DemoService demoService) {
		this.demoService = demoService;
	}

	@GetMapping("/b/single")
	public ResultDTO getBSingle() {
		return ResultDTO.success(demoService.getBSingle());
	}

	@GetMapping("/b")
	public ResultDTO getB(Integer aId) {
		return ResultDTO.success(demoService.getB(aId));
	}

	@GetMapping("/c/single")
	public ResultDTO getCSingle() {
		return ResultDTO.success(demoService.getCSingle());
	}

	@GetMapping("/c")
	public ResultDTO getC(Integer bId) {
		return ResultDTO.success(demoService.getC(bId));
	}
}
