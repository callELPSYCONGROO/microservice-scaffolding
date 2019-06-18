package com.wuhenjian.microservicescaffolding.service1.dao;

import com.wuhenjian.microservicescaffolding.util.domain.dto.CDTO;
import com.wuhenjian.microservicescaffolding.util.domain.entity.C;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMapper {

    int deleteByPrimaryKey(Integer cid);

    int insert(C record);

    int insertBatch(@Param("records") List<C> records);

    int insertSelective(C record);

    C selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(C record);

    int countByModel(C model);

    List<CDTO> selectByModel(C model);
}