package com.wuhenjian.microservicescaffolding.service2.dao;

import com.wuhenjian.microservicescaffolding.service2.domain.entity.A;
import com.wuhenjian.microservicescaffolding.service2.domain.entity.ACriteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AMapper {
    int countByCriteria(ACriteria criteria);

    int deleteByCriteria(ACriteria criteria);

    int deleteByPrimaryKey(Integer aid);

    int insert(A record);

    int insertBatch(@Param("records") List<A> records);

    int insertSelective(A record);

    List<A> selectByCriteria(ACriteria criteria);

    A selectByPrimaryKey(Integer aid);

    int updateByCriteriaSelective(@Param("record") A record, @Param("criteria") ACriteria criteria);

    int updateByCriteria(@Param("record") A record, @Param("criteria") ACriteria criteria);

    int updateByPrimaryKeySelective(A record);

    int updateByPrimaryKey(A record);

    int countByModel(A model);

    List<A> selectByModel(A model);
}