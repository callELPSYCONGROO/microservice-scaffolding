package com.wuhenjian.microservicescaffolding.zuul.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 無痕剑
 * @date 2019/5/15 14:59
 */
public class RequestUtil {

	/**
	 * 获取URI中的服务名称
	 * @param uri 请求URI
	 * @return 服务名称，未匹配成功返回null
	 */
	public static String matchServiceName(String uri) {
		Matcher matcher = Pattern.compile("^/api/([0-9a-zA-Z]+)/(\\S+)").matcher(uri);
		if (matcher.find()) {
			// 返回第一个正则表达式匹配到的内容，就是服务名称
			return matcher.group(1);
		}
		return null;
	}

	public static String addUrlParams(String url, Map<String, Object> params) {
		StringBuilder sb = new StringBuilder(url);
		sb.append("?");
		params.forEach((k, v) -> sb.append(k).append("=").append(v).append("&"));
		String result = sb.toString();
		if (result.endsWith("&")) {
			result = sb.substring(0, sb.length() - 1);
		}
		return result;
	}
}
