package com.ddg.test.statemachine.controlleradvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Description:
 * ========================================================================
 * ------------------------------------------------------------------------
 *
 * @author wzj
 * @version 1.0
 * <p>
 * ========================================================================
 * @date 2022/3/4 18:40
 * @email: wangzhijie0908@gmail.com
 */
@RestControllerAdvice
public class OrderControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e){
        return e.getMessage();
    }

}
