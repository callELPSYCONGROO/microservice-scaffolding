package com.wuhenjian.microservicescaffolding.service1.dao;

import com.wuhenjian.microservicescaffolding.service1.domain.entity.B;
import com.wuhenjian.microservicescaffolding.service1.domain.entity.BCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BMapper {
    int countByCriteria(BCriteria criteria);

    int deleteByCriteria(BCriteria criteria);

    int deleteByPrimaryKey(Integer bid);

    int insert(B record);

    int insertSelective(B record);

    List<B> selectByCriteria(BCriteria criteria);

    B selectByPrimaryKey(Integer bid);

    int updateByCriteriaSelective(@Param("record") B record, @Param("criteria") BCriteria criteria);

    int updateByCriteria(@Param("record") B record, @Param("criteria") BCriteria criteria);

    int updateByPrimaryKeySelective(B record);

    int updateByPrimaryKey(B record);

    int countByModel(B model);

    List<B> selectByModel(B model);
}