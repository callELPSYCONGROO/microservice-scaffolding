package com.wuhenjian.microservicescaffolding.service.service.impl;

import com.wuhenjian.microservicescaffolding.service.dao.DemoDao;
import com.wuhenjian.microservicescaffolding.service.domain.command.DemoCommand;
import com.wuhenjian.microservicescaffolding.service.domain.dto.DemoDTO;
import com.wuhenjian.microservicescaffolding.service.domain.entity.DemoEntity;
import com.wuhenjian.microservicescaffolding.service.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:16
 */
@Service
public class DemoServiceImpl implements DemoService {

	private final DemoDao demoDao;

	@Autowired
	public DemoServiceImpl(DemoDao demoDao) {
		this.demoDao = demoDao;
	}

	@Override
	public void demo(DemoCommand command) {
		DemoEntity entity = new DemoEntity();
		entity.setDemo(command.getDemo());
		demoDao.insert(entity);
	}

	@Override
	public DemoDTO demo(String demo) {
		return demoDao.get(demo);
	}
}
