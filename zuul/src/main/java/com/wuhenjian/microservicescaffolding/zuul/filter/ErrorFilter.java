package com.wuhenjian.microservicescaffolding.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 异常过滤器
 * @author: Overload
 * @review:
 * @date: 2018/8/15 15:15
 */
@Slf4j
@Component
public class ErrorFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_FORWARD_FILTER_ORDER;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// 获取上下文
		RequestContext context = RequestContext.getCurrentContext();
		// 获取异常信息
//        context.getThrowable().getMessage()
		// 设置为系统异常
		context.setResponseBody("fail");
		return null;
	}
}
