package com.wuhenjian.microservicescaffolding.service.config.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringUtil
 * @author: Overload
 * @date: 2018/5/21 14:12
 * @version: 1.0
 */
public class StringUtil {

    public final static String URL_REGEX = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * Null对象和空字符串返回""字符串，其他返回原值
     * @param string 字符串
     * @return 返回值
     */
    public static String retrString(String string) {
        return string == null || "".equals(string) || string.matches("[ ]+") ? "" : string;
    }

    /**
     * 判断字符串是否为null或者空字符串或者全为空格
     * @param string 字符串
     */
    public static boolean isBlank(String string) {
        return string == null || string.length() == 0 || string.matches("[ ]+");
    }

    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }

    /**
     * 下划线转驼峰法(默认小驼峰)
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰(驼峰，第一个字符是大写还是小写)
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line, boolean... smallCamel) {
        if (line == null || "".equals(line)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(line);
        //匹配正则表达式
        while (matcher.find()) {
            String word = matcher.group();
            //当是true 或则是空的情况
            if ((smallCamel.length == 0 || smallCamel[0]) && matcher.start() == 0) {
                sb.append(Character.toLowerCase(word.charAt(0)));
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
            }

            int index = word.lastIndexOf('_');
            if (index > 0) {
                sb.append(word.substring(1, index).toLowerCase());
            } else {
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    /**
     * 驼峰法转下划线
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line, boolean... smallCamel) {
        if (line == null || "".equals(line)) {
            return "";
        }
        line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append((smallCamel.length == 0 || smallCamel[0]) ? word.toLowerCase() : word.toUpperCase());
            sb.append(matcher.end() == line.length() ? "" : "_");
        }
        return sb.toString();
    }

    /**
     * 修改FeignClient生成的URL中的serviceId
     * @param url URL字符串
     * @param nServiceId 新serviceId
     * @return 替换之后的字符串
     */
    public static String changeServiceId(String url, String nServiceId) {
        // 获取协议
        String protocol = url.split("://")[0];
        // 替换serviceId
        return url.replaceFirst("^http(s)?://[a-zA-Z0-9\\-]+/", protocol + "://" + nServiceId + "/");
    }

    /**
     * 获取URL中的serviceId
     * @param url 请求URL
     * @return serviceId
     */
    public static String urlServiceId(String url) {
        String[] s1 = url.split("://");
        String noProtocol = s1[1];
        String[] s2 = noProtocol.split("/");
        return s2[0];
    }
}
