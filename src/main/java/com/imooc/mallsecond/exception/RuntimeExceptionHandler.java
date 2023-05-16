package com.imooc.mallsecond.exception;

import com.imooc.mallsecond.enums.ResponseEnum;
import com.imooc.mallsecond.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException: ", e);
        return ResponseVo.error(ResponseEnum.ERROR, e.getMessage());
    }
}
