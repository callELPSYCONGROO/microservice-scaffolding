package com.wuhenjian.microservicescaffolding.service1.controller;

import com.wuhenjian.microservicescaffolding.service1.service.DemoService;
import com.wuhenjian.microservicescaffolding.util.domain.dto.CDTO;
import com.wuhenjian.microservicescaffolding.util.domain.dto.ResultDTO;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:02
 */
@Api(tags = "所有ABC数据")
@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DemoController {

	private final DemoService demoService;

	@GetMapping("/a/single")
	@ApiOperation("获取A表")
	public ResultDTO getASingle() {
		return ResultDTO.success(demoService.getASingle());
	}

	@GetMapping("/a")
	@ApiOperation("获取A连体数据")
	public ResultDTO getA() {
		return ResultDTO.success(demoService.getA());
	}

	@GetMapping("/b/single")
	@ApiOperation("获取B表")
	public ResultDTO getBSingle() {
		return ResultDTO.success(demoService.getBSingle());
	}

	@GetMapping("/b")
	@ApiOperation("获取B连体数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "aId", value = "A的ID"),
	})
	public ResultDTO getB(Integer aId) {
		return ResultDTO.success(demoService.getB(aId));
	}

	@GetMapping("/c/single")
	@ApiOperation("获取C表")
	public ResultDTO getCSingle() {
		return ResultDTO.success(demoService.getCSingle());
	}

	@GetMapping("/c")
	@ApiOperation("获取C连体数据")
	@ApiImplicitParam(name = "bId", value = "B的ID")
	@ApiResponse(code = 200, message = "OK", response = CDTO.class, responseContainer = "List")
	public ResultDTO getC(Integer bId) {
		return ResultDTO.success(demoService.getC(bId));
	}
}
