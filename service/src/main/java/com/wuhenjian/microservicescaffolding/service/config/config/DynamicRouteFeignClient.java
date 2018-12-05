package com.wuhenjian.microservicescaffolding.service.config.config;

import feign.Client;
import feign.Request;
import feign.Response;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;

import java.io.IOException;

/**
 * 动态路由FeignClient
 * @author 無痕剑
 * @date 2018/11/27 22:49
 */
public class DynamicRouteFeignClient extends LoadBalancerFeignClient {

	public DynamicRouteFeignClient(Client delegate, CachingSpringLoadBalancerFactory lbClientFactory, SpringClientFactory clientFactory) {
		super(delegate, lbClientFactory, clientFactory);
	}

	/**
	 * 重写这个方法，在前面加上动态路由。
	 * 其实就是修改URL
	 */
	@Override
	public Response execute(Request request, Request.Options options) throws IOException {
		/*
		 获取远程调用的URL
		 格式：http://service-log/operation/remote/listByTypeAndId?mappingType=asd&mappingId=12&companyId=11
		  */
		String url = request.url();
		// 获取请求接口的serviceId
        String serviceId = StringUtil.urlServiceId(url);
        // 看获取场景是通过本地服务连缓存系统还是连配置中心服务获取
        // 连接配置中心的请求，需要跳过下面几步，直接return
        //TODO 获取用户购买的场景对应的serivceId
        String nServiceId = "";
        // 修改URL中serviceId为对应场景serviceId
		String newUrl = StringUtil.changeServiceId(url, nServiceId);
		//生成新请求
		Request newRequest = Request.create(request.method(), newUrl, request.headers(), request.body(), request.charset());
		// 执行请求
		return super.execute(newRequest, options);
	}
}
