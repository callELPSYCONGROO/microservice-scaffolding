package com.wuhenjian.microservicescaffolding.service2.service.impl;

import com.wuhenjian.microservicescaffolding.service2.service.DemoService;
import com.wuhenjian.microservicescaffolding.util.domain.dto.BDTO;
import com.wuhenjian.microservicescaffolding.util.domain.dto.CDTO;
import com.wuhenjian.microservicescaffolding.util.domain.entity.B;
import com.wuhenjian.microservicescaffolding.util.domain.entity.C;
import com.wuhenjian.microservicescaffolding.util.mapper.BMapper;
import com.wuhenjian.microservicescaffolding.util.mapper.CMapper;
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
		return bMapper.selectList(null)
				.stream()
				.map(b -> {
					BDTO bdto = (BDTO) b;
					bdto.setCList(getC(bdto.getBid()));
					return bdto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public List<B> getBSingle() {
		return bMapper.selectList(null)
				.stream()
				.map(bdto -> (B) bdto)
				.collect(Collectors.toList());
	}

	@Override
	public List<C> getCSingle() {
		return cMapper.selectList(null);
	}

	@Override
	public List<CDTO> getC(Integer bId) {
		return cMapper.selectList(null).stream().map(c -> (CDTO) c).collect(Collectors.toList());
	}
}
