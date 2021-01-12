package com.wuhenjian.microservicescaffolding.service1.handler;

import com.wuhenjian.microservicescaffolding.util.domain.dto.ResultDTO;
import com.wuhenjian.microservicescaffolding.util.exception.DemoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * controller层异常处理
 * @author: Overload
 * @review:
 * @date: 2018/6/28/0028 15:52
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

	/**
	 * 基础数据自定义异常
	 */
	@ExceptionHandler(DemoException.class)
	public ResultDTO demoExceptionHandler(DemoException e) {
		log.error(e.getMsg(), e);
		return new ResultDTO(500, e.getMsg(), null);
	}

	/**
	 * 请求参数类型不匹配或转换错误
	 */
	@ExceptionHandler(TypeMismatchException.class)
	public ResultDTO typeMismatchExceptionHandler(TypeMismatchException e) {
		log.error(e.getMessage(), e);
		return new ResultDTO(500, e.getMessage(), null);
	}

	/**
	 * SpringMVC请求参数绑定异常
	 */
	@ExceptionHandler(ServletRequestBindingException.class)
	public ResultDTO servletRequestBindingExceptionHandler(ServletRequestBindingException e) {
		log.error(e.getMessage(), e);
		return new ResultDTO(500, e.getMessage(), null);
	}

	/**
	 * 请求参数校验异常
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResultDTO methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		log.error(e.getMessage(), e);
		// 避免错误信息重复
		Set<String> errorMessageSet = new HashSet<>();
		Optional.of(e.getBindingResult()).ifPresent(bindingResult -> bindingResult.getAllErrors().forEach(err -> errorMessageSet.add(err.getDefaultMessage())));
		StringBuilder allErrorMessage = new StringBuilder();
		errorMessageSet.forEach(err -> allErrorMessage.append(err).append("；"));
		String msg = errorMessageSet.size() == 0 ? "fail" : allErrorMessage.deleteCharAt(allErrorMessage.length() - 1).toString();
		return new ResultDTO(500, msg, null);
	}

	@ExceptionHandler(BindException.class)
	public ResultDTO bindExceptionHandler(BindException e) {
		log.error(e.getMessage(), e);
		// 避免错误信息重复
		Set<String> errorMessageSet = new HashSet<>();
		e.getAllErrors().forEach(err -> errorMessageSet.add(err.getDefaultMessage()));
		StringBuilder allErrorMessage = new StringBuilder();
		errorMessageSet.forEach(err -> allErrorMessage.append(err).append("；"));
		String msg = errorMessageSet.size() == 0 ? "fail" : allErrorMessage.deleteCharAt(allErrorMessage.length() - 1).toString();
		return new ResultDTO(500, msg, null);
	}

	/**
	 * 请求参数格式错误异常（http.body为空或为非json字符串）
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResultDTO httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
		log.error(e.getMessage(), e);
		return new ResultDTO(500, e.getMessage(), null);
	}

	/**
	 * 响应数据格式错误
	 */
	@ExceptionHandler(HttpMessageNotWritableException.class)
	public ResultDTO httpMessageNotReadableExceptionHandler(HttpMessageNotWritableException e) {
		log.error(e.getMessage(), e);
		return new ResultDTO(500, e.getMessage(), null);
	}

	/**
	 * 不支持该请求方法
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResultDTO httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
		log.error(e.getMessage(), e);
		return new ResultDTO(500, e.getMessage(), null);
	}

	/**
	 * 系统异常
	 */
	@ExceptionHandler(Exception.class)
	public ResultDTO exceptionHandler(Exception e) {
		log.error(e.getMessage(), e);
		return new ResultDTO(500, e.getMessage(), null);
	}
}
