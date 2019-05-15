package com.wuhenjian.microservicescaffolding.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(value = "service-log")
public interface RemoteFeignService {
}
