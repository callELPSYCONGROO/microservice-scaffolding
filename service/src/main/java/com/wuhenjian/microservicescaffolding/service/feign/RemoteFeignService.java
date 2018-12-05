package com.wuhenjian.microservicescaffolding.service.feign;

@Component
@FeignClient(
        value = "service-log",
        fallback = OperationLogFeignServiceHystrix.class
)
public interface RemoteFeignService {
}
