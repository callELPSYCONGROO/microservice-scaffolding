package com.wuhenjian.microservicescaffolding.service1.domain.dto;

import com.wuhenjian.microservicescaffolding.service1.domain.entity.C;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author 無痕剑
 * @date 2019/6/18 0:58
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CDTO extends C {

	public CDTO() {
	}

	public CDTO(Integer cid, String cname, Date ctime, Integer bid) {
		super(cid, cname, ctime, bid);
	}
}
