package com.wuhenjian.microservicescaffolding.gateway.controller;

import com.wuhenjian.microservicescaffolding.util.domain.dto.ResultDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

/**
 * @author 無痕剑
 * @date 2021/1/14 0014 19:14
 */
@RestController
public class FallbackController {

    @RequestMapping("/fallback")
    public ResultDTO fallback(ServerWebExchange exchange, Throwable throwable) {
        return ResultDTO.fail(999, "兜底熔断");
    }
}
