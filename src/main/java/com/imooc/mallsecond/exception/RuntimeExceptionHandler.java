package com.imooc.mallsecond.exception;

import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 描述: TODO
 */

@ControllerAdvice
@Slf4j
public class RuntimeExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException: ", e);
        return ResponseVo.error(ResponseEnum.ERROR, e.getMessage());
    }

    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo handleUserLoginException(UserLoginException e) {
        log.error("UserLoginException: ", e);
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }

    //统一检查请求中的参数是否都存在且合法
    //因为如果参数不合法就会抛出下面这个异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVo handleNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException: ", e);
        BindingResult bindingResult = e.getBindingResult();
        return ResponseVo.error(ResponseEnum.PARAM_ERROR, bindingResult);
    }
}
