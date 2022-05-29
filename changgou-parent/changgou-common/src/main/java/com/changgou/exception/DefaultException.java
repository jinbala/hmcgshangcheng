package com.changgou.exception;

import com.changgou.util.Result;
import com.changgou.util.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  自定义的异常处理类
 */
@ControllerAdvice//获取凡是从controller层抛出来的异常
public class DefaultException {
    /**
     * 自定义注解
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)//指定获取什么类型的异常
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,"系统异常",e.getMessage());
    }



}
