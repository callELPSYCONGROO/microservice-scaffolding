package com.wuhenjian.microservicescaffolding.util.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuhenjian.microservicescaffolding.util.domain.entity.A;
import com.wuhenjian.microservicescaffolding.util.mapper.AMapper;
import com.wuhenjian.microservicescaffolding.util.repository.ARepository;
import org.springframework.stereotype.Repository;

/**
 * @author 無痕剑
 * @date 2021/1/21 0021 12:24
 */
@Repository
public class ARepositoryImpl extends ServiceImpl<AMapper, A> implements ARepository {
}
