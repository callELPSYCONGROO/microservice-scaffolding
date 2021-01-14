package com.wuhenjian.microservicescaffolding.util.domain.dto;

import com.wuhenjian.microservicescaffolding.util.domain.entity.A;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author 無痕剑
 * @date 2019/6/18 0:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ADTO extends A {

	private List<BDTO> bList;
}
