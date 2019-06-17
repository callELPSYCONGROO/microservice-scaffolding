package com.wuhenjian.microservicescaffolding.service2.domain.dto;

import com.wuhenjian.microservicescaffolding.service2.domain.entity.A;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 無痕剑
 * @date 2019/6/18 0:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ADTO extends A {

	private List<BDTO> bList;
}
