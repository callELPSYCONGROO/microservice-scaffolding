package com.wuhenjian.microservicescaffolding.service2.service;

import com.wuhenjian.microservicescaffolding.service2.domain.dto.ADTO;
import com.wuhenjian.microservicescaffolding.service2.domain.dto.BDTO;
import com.wuhenjian.microservicescaffolding.service2.domain.dto.CDTO;
import com.wuhenjian.microservicescaffolding.service2.domain.entity.A;
import com.wuhenjian.microservicescaffolding.service2.domain.entity.B;
import com.wuhenjian.microservicescaffolding.service2.domain.entity.C;

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
