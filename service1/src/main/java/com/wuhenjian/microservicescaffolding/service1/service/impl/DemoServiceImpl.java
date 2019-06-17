package com.wuhenjian.microservicescaffolding.service1.service.impl;

import com.wuhenjian.microservicescaffolding.service1.dao.AMapper;
import com.wuhenjian.microservicescaffolding.service1.domain.dto.ADTO;
import com.wuhenjian.microservicescaffolding.service1.domain.dto.BDTO;
import com.wuhenjian.microservicescaffolding.service1.domain.dto.CDTO;
import com.wuhenjian.microservicescaffolding.service1.domain.entity.A;
import com.wuhenjian.microservicescaffolding.service1.domain.entity.B;
import com.wuhenjian.microservicescaffolding.service1.domain.entity.C;
import com.wuhenjian.microservicescaffolding.service1.service.DemoService;
import com.wuhenjian.microservicescaffolding.service1.service.FeignService;
import com.wuhenjian.microservicescaffolding.service1.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 無痕剑
 * @date 2019/6/18 0:33
 */
@Service
public class DemoServiceImpl implements DemoService {

	private final AMapper aMapper;
	private final FeignService feignService;

	@Autowired
	public DemoServiceImpl(AMapper aMapper, FeignService feignService) {
		this.aMapper = aMapper;
		this.feignService = feignService;
	}

	@Override
	public List<A> getASingle() {
		return aMapper.selectByModel(null);
	}

	@Override
	public List<ADTO> getA() {
		return aMapper.selectByCriteria(null)
				.stream()
				.map(a -> (ADTO) a)
				.peek(aDTO -> aDTO.setBList(getB(aDTO.getAid())))
				.collect(Collectors.toList());
	}

	@Override
	public List<BDTO> getB(Integer aId) {
		return JsonUtil.json2Obj(feignService.getB(aId), BDTO.class);
	}

	@Override
	public List<B> getBSingle() {
		return JsonUtil.json2Obj(feignService.getBSingle(), B.class);
	}

	@Override
	public List<C> getCSingle() {
		return JsonUtil.json2Obj(feignService.getCSingle(), C.class);
	}

	@Override
	public List<CDTO> getC(Integer bId) {
		return JsonUtil.json2Obj(feignService.getC(bId), CDTO.class);
	}
}
