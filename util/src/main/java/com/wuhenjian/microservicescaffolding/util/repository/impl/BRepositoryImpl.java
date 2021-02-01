package com.wuhenjian.microservicescaffolding.util.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuhenjian.microservicescaffolding.util.domain.entity.B;
import com.wuhenjian.microservicescaffolding.util.mapper.BMapper;
import com.wuhenjian.microservicescaffolding.util.repository.BRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 無痕剑
 * @date 2021/1/21 0021 12:24
 */
@Repository
public class BRepositoryImpl extends ServiceImpl<BMapper, B> implements BRepository {
}
