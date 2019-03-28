package com.zyse.design.system.handler;


import com.zyse.design.controller.sys.SysUserController;
import com.zyse.design.system.enums.ResultStatusCode;
import com.zyse.design.untils.ResultUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;


@ControllerAdvice
@ResponseBody
/**
 * 异常封装
 * @description:功能描述
 * @ClassName:ExceptionAdvice.java
 * @Author: yc
 * @date: 2019/3/28 11:09
 * @Version:1.0
 */
public class ExceptionAdvice {

    private static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class, MissingServletRequestParameterException.class, BindException.class,
            ServletRequestBindingException.class, MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResultUtil handleHttpMessageNotReadableException(Exception e) {
        logger.error("参数解析失败", e);
        if (e instanceof BindException){
            return new ResultUtil(ResultStatusCode.BAD_REQUEST.getCode(), ((BindException)e).getAllErrors().get(0).getDefaultMessage());
        }
        return new ResultUtil(ResultStatusCode.BAD_REQUEST.getCode(), e.getMessage());
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultUtil handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        return new ResultUtil(ResultStatusCode.METHOD_NOT_ALLOWED, null);
    }

    /**
     * shiro权限异常处理
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResultUtil unauthorizedException(UnauthorizedException e){
        logger.error(e.getMessage(), e);

        return new ResultUtil(ResultStatusCode.UNAUTHO_ERROR);
    }

    /**
     * 500
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultUtil handleException(Exception e) {
        e.printStackTrace();
        logger.error("服务运行异常", e);
        return new ResultUtil(ResultStatusCode.SYSTEM_ERR, null);
    }
}
