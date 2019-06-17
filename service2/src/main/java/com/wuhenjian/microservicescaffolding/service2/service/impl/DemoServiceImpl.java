package com.wuhenjian.microservicescaffolding.service2.service.impl;

import com.wuhenjian.microservicescaffolding.service2.dao.BMapper;
import com.wuhenjian.microservicescaffolding.service2.dao.CMapper;
import com.wuhenjian.microservicescaffolding.service2.domain.dto.BDTO;
import com.wuhenjian.microservicescaffolding.service2.domain.dto.CDTO;
import com.wuhenjian.microservicescaffolding.service2.domain.entity.B;
import com.wuhenjian.microservicescaffolding.service2.domain.entity.C;
import com.wuhenjian.microservicescaffolding.service2.service.DemoService;
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

	private final BMapper bMapper;
	private final CMapper cMapper;

	@Autowired
	public DemoServiceImpl(BMapper bMapper,
	                       CMapper cMapper) {
		this.bMapper = bMapper;
		this.cMapper = cMapper;
	}

	@Override
	public List<BDTO> getB(Integer aId) {
		return bMapper.selectByCriteria(null)
				.stream()
				.map(b -> (BDTO) b)
				.peek(bdto -> bdto.setCList(getC(bdto.getBid())))
				.collect(Collectors.toList());
	}

	@Override
	public List<B> getBSingle() {
		return bMapper.selectByCriteria(null);
	}

	@Override
	public List<C> getCSingle() {
		return cMapper.selectByCriteria(null);
	}

	@Override
	public List<CDTO> getC(Integer bId) {
		return cMapper.selectByCriteria(null)
				.stream()
				.map(c -> (CDTO) c)
				.collect(Collectors.toList());
	}
}
