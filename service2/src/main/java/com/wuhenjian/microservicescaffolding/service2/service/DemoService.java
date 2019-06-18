package com.wuhenjian.microservicescaffolding.service2.service;

import com.wuhenjian.microservicescaffolding.util.domain.dto.BDTO;
import com.wuhenjian.microservicescaffolding.util.domain.dto.CDTO;
import com.wuhenjian.microservicescaffolding.util.domain.entity.B;
import com.wuhenjian.microservicescaffolding.util.domain.entity.C;

import java.util.List;

/**
 * @author 無痕剑
 * @date 2019/6/18 0:33
 */
public interface DemoService {

	List<BDTO> getB(Integer aId);

	List<B> getBSingle();

	List<C> getCSingle();

	List<CDTO> getC(Integer bId);
}
