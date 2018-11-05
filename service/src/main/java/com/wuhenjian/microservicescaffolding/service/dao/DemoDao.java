package com.wuhenjian.microservicescaffolding.service.dao;

import com.wuhenjian.microservicescaffolding.service.domain.dto.DemoDTO;
import com.wuhenjian.microservicescaffolding.service.domain.entity.DemoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 無痕剑
 * @date 2018/11/5 23:19
 */
@Repository
public interface DemoDao {

	DemoDTO get(@Param("demo") String demo);

	int insert(DemoEntity entity);
}
