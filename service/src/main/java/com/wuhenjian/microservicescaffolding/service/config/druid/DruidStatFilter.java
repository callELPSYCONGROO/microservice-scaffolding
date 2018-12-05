package com.wuhenjian.microservicescaffolding.service.config.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 拦截配置
 * @author: Overload
 * @review:
 * @date: 2018-05-30 12:05:44
 * @version: 1.0
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
		initParams={
				@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
		}
)
public class DruidStatFilter extends WebStatFilter {
}
