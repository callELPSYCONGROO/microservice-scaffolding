package com.wuhenjian.microservicescaffolding.service1.service;

import com.wuhenjian.microservicescaffolding.service1.domain.dto.ADTO;
import com.wuhenjian.microservicescaffolding.service1.domain.dto.BDTO;
import com.wuhenjian.microservicescaffolding.service1.domain.dto.CDTO;
import com.wuhenjian.microservicescaffolding.service1.domain.entity.A;
import com.wuhenjian.microservicescaffolding.service1.domain.entity.B;
import com.wuhenjian.microservicescaffolding.service1.domain.entity.C;

import java.util.List;

/**
 * @author 無痕剑
 * @date 2019/6/18 0:33
 */
public interface DemoService {

	List<A> getASingle();

	List<ADTO> getA();

	List<BDTO> getB(Integer aId);

	List<B> getBSingle();

	List<C> getCSingle();

	List<CDTO> getC(Integer bId);
}
