package com.wuhenjian.microservicescaffolding.service2.dao;

import com.wuhenjian.microservicescaffolding.service2.domain.entity.C;
import com.wuhenjian.microservicescaffolding.service2.domain.entity.CCriteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMapper {
    int countByCriteria(CCriteria criteria);

    int deleteByCriteria(CCriteria criteria);

    int deleteByPrimaryKey(Integer cid);

    int insert(C record);

    int insertBatch(@Param("records") List<C> records);

    int insertSelective(C record);

    List<C> selectByCriteria(CCriteria criteria);

    C selectByPrimaryKey(Integer cid);

    int updateByCriteriaSelective(@Param("record") C record, @Param("criteria") CCriteria criteria);

    int updateByCriteria(@Param("record") C record, @Param("criteria") CCriteria criteria);

    int updateByPrimaryKeySelective(C record);

    int updateByPrimaryKey(C record);

    int countByModel(C model);

    List<C> selectByModel(C model);
}