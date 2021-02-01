package com.wuhenjian.microservicescaffolding.service2.controller;

import com.wuhenjian.microservicescaffolding.service2.service.DemoService;
import com.wuhenjian.microservicescaffolding.util.domain.dto.BDTO;
import com.wuhenjian.microservicescaffolding.util.domain.dto.CDTO;
import com.wuhenjian.microservicescaffolding.util.domain.dto.ResultDTO;
import com.wuhenjian.microservicescaffolding.util.domain.entity.B;
import com.wuhenjian.microservicescaffolding.util.domain.entity.C;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:02
 */
@Api(tags = "BC的数据")
@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DemoController {

	private final DemoService demoService;

	@GetMapping("/b/single")
	@ApiOperation(value = "获取B表", response = BDTO.class, responseContainer = "List")
	public ResultDTO getBSingle() {
		return ResultDTO.success(demoService.getBSingle());
	}

	@GetMapping("/b")
	@ApiOperation(value = "获取B连体数据", response = B.class, responseContainer = "List")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "aId", value = "A的ID"),
	})
	public ResultDTO getB(Integer aId) {
		return ResultDTO.success(demoService.getB(aId));
	}

	@GetMapping("/c/single")
	@ApiOperation(value = "获取C表", response = C.class, responseContainer = "List")
	public ResultDTO getCSingle() {
		return ResultDTO.success(demoService.getCSingle());
	}

	@GetMapping("/c")
	@ApiOperation(value = "获取C连体数据", response = CDTO.class, responseContainer = "List")
	@ApiImplicitParam(name = "bId", value = "B的ID")
	public ResultDTO getC(Integer bId) {
		return ResultDTO.success(demoService.getC(bId));
	}
}
