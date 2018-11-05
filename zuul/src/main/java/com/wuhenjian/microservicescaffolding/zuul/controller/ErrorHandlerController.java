package com.wuhenjian.microservicescaffolding.zuul.controller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.wuhenjian.microservicescaffolding.zuul.demo.ResultDTO;
import com.wuhenjian.microservicescaffolding.zuul.exception.GatewayException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 网关异常处理
 * @author: Overload
 * @date: 2018/6/19 16:37
 * @version: 1.0
 */
@Slf4j
@RestController
public class ErrorHandlerController implements ErrorController {

    /**
     * 出异常后进入该方法，交由下面的方法处理
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     * 处理异常返回值
     */
    @RequestMapping("/error")
    public ResultDTO error() {
        // 获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        context.setResponseStatusCode(HttpServletResponse.SC_OK);
        context.setSendZuulResponse(false);
	    // 请求对象
	    HttpServletRequest request = context.getRequest();
	    // 错误请求
	    if (request == null) {
		    throw GatewayException.build();
	    }
	    // 请求URI
	    String uri = request.getRequestURI();
        // 获取请求中的异常
        Throwable throwable = context.getThrowable();
        // ZuulException异常处理
        if (throwable instanceof ZuulException) {
	        ZuulException zuulException = (ZuulException) throwable;
	        // 获取到异常的根原因
            Throwable cause = zuulException.getCause();
            // 处理GatewayException异常
            if (cause instanceof GatewayException) {
	            //记录异常请求日志
	            log.error("用户请求非法路径[" + uri + "]");
                GatewayException gatewayException = (GatewayException) cause;
                return ResultDTO.builder().code(gatewayException.getCode()).msg(gatewayException.getMsg()).build();
            }
            // 其他的ZuulException异常
	        log.error("用户请求路径[" + uri + "]发生异常：" + cause.getMessage(), cause.getCause());
	        return ResultDTO.builder().code(500).msg(cause.getMessage()).build();
        }
	    return ResultDTO.builder().code(500).msg("fail").build();
    }
}
