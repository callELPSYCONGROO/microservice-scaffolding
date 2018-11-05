package com.wuhenjian.microservicescaffolding.service.service;

import com.wuhenjian.microservicescaffolding.service.domain.command.DemoCommand;
import com.wuhenjian.microservicescaffolding.service.domain.dto.DemoDTO;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:15
 */
public interface DemoService {

	void demo(DemoCommand command);

	DemoDTO demo(String demo);
}
