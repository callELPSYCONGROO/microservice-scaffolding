package com.wuhenjian.microservicescaffolding.service1.dao;

import com.wuhenjian.microservicescaffolding.util.domain.dto.BDTO;
import com.wuhenjian.microservicescaffolding.util.domain.entity.B;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BMapper {

    int deleteByPrimaryKey(Integer bid);

    int insert(B record);

    int insertBatch(@Param("records") List<B> records);

    int insertSelective(B record);

    B selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(B record);

    int countByModel(B model);

    List<BDTO> selectByModel(B model);
}