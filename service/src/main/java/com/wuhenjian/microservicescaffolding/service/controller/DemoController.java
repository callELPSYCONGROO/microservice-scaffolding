package com.wuhenjian.microservicescaffolding.service.controller;

import com.wuhenjian.microservicescaffolding.service.domain.command.DemoCommand;
import com.wuhenjian.microservicescaffolding.service.domain.dto.DemoDTO;
import com.wuhenjian.microservicescaffolding.service.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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

	@ApiOperation(value = "POST-demo", response = DemoDTO.class, httpMethod = "POST")
	@ApiImplicitParam(dataTypeClass = DemoCommand.class)
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public DemoDTO post(@Validated @RequestBody DemoCommand command) {
		demoService.demo(command);
		return DemoDTO.builder().code(1000).msg("SUCCESS").build();
	}

	@Validated
	@ApiOperation(value = "GET-demo", response = DemoDTO.class, httpMethod = "GET")
	@ApiImplicitParam()
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public DemoDTO get(@NotNull(message = "请求参数不能为空") @RequestParam("demo") String demo) {
		DemoDTO data = demoService.demo(demo);
		return DemoDTO.builder().code(1000).msg("SUCCESS").data(data).build();
	}
}
