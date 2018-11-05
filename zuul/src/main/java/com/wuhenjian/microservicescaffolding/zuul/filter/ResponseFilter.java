package com.wuhenjian.microservicescaffolding.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 返回值输出过滤器，用于处理返回值
 * @author: Overload
 * @date: 2018/6/19 15:18
 * @version: 1.0
 */
@Component
public class ResponseFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();// 获取上下文
		context.addZuulResponseHeader("Content-Type", "application/json;charset=UTF-8");
		InputStream inputStream = context.getResponseDataStream();
		String responseBody;
		try {
			responseBody = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
		} catch (IOException e) {
			context.setResponseBody("fail");
			return null;
		}
		if (context.getResponseStatusCode() != 200) {// zuul网关请求状态
			context.setResponseBody("fail");
			return null;
		}
		context.setResponseBody(responseBody);
		return null;
	}
}
