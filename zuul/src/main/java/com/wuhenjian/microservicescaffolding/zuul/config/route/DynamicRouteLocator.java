package com.wuhenjian.microservicescaffolding.zuul.config.route;

import com.bici.saas.common.util.string.StringUtil;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态路由实现
 * @author 無痕剑
 * @date 2018/11/15 22:05
 */
public class DynamicRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

	/**
	 * 是否启用动态路由。
	 * 在配置文件中：saas.routes.dynamic.enabled，默认为false
	 */
	private boolean enabled;

	public DynamicRouteLocator(boolean enabled, String servletPath, ZuulProperties properties) {
		super(servletPath, properties);
		this.enabled = enabled;
	}

	/**
	 * 重载路由规则
	 */
	@Override
	protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
		if (!enabled) {
			return super.locateRoutes();
		}
		Map<String, ZuulProperties.ZuulRoute> routeMap = new HashMap<>();
		// 从数据源获取路由配置
		// 先模拟几个配置
		String path = "/log/**";
		String serviceId = "service-log";

		// 任意一个为空，则不进行动态路由
		if (StringUtil.isBlank(path) || StringUtil.isBlank(serviceId)) {
			return super.locateRoutes();
		}
		// 生成ZuulRoute对象
		ZuulProperties.ZuulRoute zuulRoute = createZuulRoute(path, serviceId);

		routeMap.put(path, zuulRoute);

		String path1 = "/basedata/**";
		String serviceId2 = "service-basedata";
		ZuulProperties.ZuulRoute zuulRoute1 = createZuulRoute(path1, serviceId2);
		routeMap.put(path1, zuulRoute1);

		return routeMap;
	}

	/**
	 * 刷新路由
	 */
	@Override
	public void refresh() {
		super.doRefresh();
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * 生成ZuulRoute对象
	 * @param path 映射路径
	 * @param serviceId 服务Id
	 */
	private ZuulProperties.ZuulRoute createZuulRoute(String path, String serviceId) {
		ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
		zuulRoute.setId(path);
		zuulRoute.setPath(path);
		zuulRoute.setServiceId(serviceId);
		return zuulRoute;
	}
}
