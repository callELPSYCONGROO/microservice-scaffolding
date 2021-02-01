package com.wuhenjian.microservicescaffolding.service1.service.impl;

import com.wuhenjian.microservicescaffolding.service1.service.DemoService;
import com.wuhenjian.microservicescaffolding.service1.service.FeignService;
import com.wuhenjian.microservicescaffolding.util.JsonUtil;
import com.wuhenjian.microservicescaffolding.util.domain.dto.ADTO;
import com.wuhenjian.microservicescaffolding.util.domain.dto.BDTO;
import com.wuhenjian.microservicescaffolding.util.domain.dto.CDTO;
import com.wuhenjian.microservicescaffolding.util.domain.entity.A;
import com.wuhenjian.microservicescaffolding.util.domain.entity.B;
import com.wuhenjian.microservicescaffolding.util.domain.entity.C;
import com.wuhenjian.microservicescaffolding.util.mapper.AMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 無痕剑
 * @date 2019/6/18 0:33
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DemoServiceImpl implements DemoService {

	private final AMapper aMapper;

	private final FeignService feignService;

	@Override
	public List<A> getASingle() {
		return aMapper.selectList(null);
	}

	@Override
	public List<ADTO> getA() {
		return aMapper.selectList(null)
				.stream()
				.map(a -> {
					ADTO adto = (ADTO) a;
					adto.setBList(getB(a.getAid()));
					return adto;
				})
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
