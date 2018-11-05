package com.wuhenjian.microservicescaffolding.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.wuhenjian.microservicescaffolding.zuul.exception.GatewayException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求路径过滤
 * @author overload
 * @date 2018/8/22 22:32
 */
@Component
public class RequestPathFilter extends ZuulFilter {

	/** 网关是否过滤带remote关键字的请求 */
	@Value("${saas.gateway.internal}")
	private boolean internal;

	/** 网关过滤关键字列表，使用英文逗号分割多个关键字 */
	@Value("${saas.gateway.invalid-path}")
	private String invalidPaths;

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SERVLET_30_WRAPPER_FILTER_ORDER;
	}

	@Override
	public boolean shouldFilter() {
		return internal;
	}

	@Override
	public Object run() throws ZuulException {
		// 请求上下文
		RequestContext context = RequestContext.getCurrentContext();
		// 请求对象
		HttpServletRequest request = context.getRequest();
		// 请求URI
		String uri = request.getRequestURI();
		// 过滤不合法的请求
		if (StringUtils.isBlank(invalidPaths)) {
			return null;
		}
		String[] strings = invalidPaths.split(",");
		for (String path : strings) {
			if (uri.contains(path)) {
				// 将ZuulException抛给ErrorHandlerController处理
				throw new ZuulException(GatewayException.build(),
						500,
						"fail");
			}
		}
		return null;
	}
}
