package com.wuhenjian.microservicescaffolding.service2.dao;

import com.wuhenjian.microservicescaffolding.util.domain.dto.ADTO;
import com.wuhenjian.microservicescaffolding.util.domain.entity.A;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AMapper {

    int deleteByPrimaryKey(Integer aid);

    int insert(A record);

    int insertBatch(@Param("records") List<A> records);

    int insertSelective(A record);

    A selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(A record);

    int countByModel(A model);

    List<ADTO> selectByModel(A model);
}