package com.alilestera.exception;

import com.alilestera.common.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Alilestera
 * @date 2/17/2022
 */
@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseResult handlerException(Exception e) {
        return new ResponseResult(500, e.getMessage());
    }
}
