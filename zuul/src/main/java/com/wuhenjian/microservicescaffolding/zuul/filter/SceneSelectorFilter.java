package com.wuhenjian.microservicescaffolding.zuul.filter;

import com.bici.saas.gateway.util.RequestUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * <p>场景选择过滤器。</p>
 * <p>查询一个静态常量，匹配到请求用户的对应场景的 <code>serviceId</code> ，并设置到请求上下文中的属性{@link FilterConstants#SERVICE_ID_KEY}中。</p>
 * <p>该过滤器放置在 {@link PreDecorationFilter} 之后，
 * 相当于替换 <code>PreDecorationFilter</code> 已经设置好的 <code>serviceId</code> 。</p>
 * <p>如果放置在 <code>PreDecorationFilter</code> 之前， <code>PreDecorationFilter</code> 会不进行过滤。就需要重写 <code>PreDecorationFilter</code> 的功能。</p>
 * @author 無痕剑
 * @date 2018/11/23 23:40
 */
@Slf4j
@Component
public class SceneSelectorFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	/**
	 * 将该过滤器放置在PreDecorationFilter之后
	 */
	@Override
	public int filterOrder() {
		return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
	}

	/**
	 * 所有请求都要适配场景
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// 获取当前请求上下文
		RequestContext currentContext = RequestContext.getCurrentContext();
		// 获取URI
		String uri = currentContext.getRequest().getRequestURI();
		// 获取服务名称
		String serviceName = RequestUtil.matchServiceName(uri);
		// 获取用户信息
//		CurrentUser user = CurrentUserUtil.getCurrentUserFromHeader(currentContext.getRequest());
		// 根据serviceName和user.companyId获取场景

		// 将请求头中的serviceId设置为对应场景
		currentContext.set(FilterConstants.SERVICE_ID_KEY, "service-basedata");
		return null;
	}
}
