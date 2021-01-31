package com.hzqing.core.web.exception;

import com.hzqing.common.exception.IceBaseException;
import com.hzqing.common.response.IceErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 衡钊清
 * @classname GlobalExceptionHandler
 * @description 全局异常处理类
 * @date  2020/7/23 22:07
 */
@RestControllerAdvice
public class IceGlobalExceptionHandler {

    protected final Logger log = LoggerFactory.getLogger(IceGlobalExceptionHandler.class);

    /**
     * IceBaseException 异常信息封装
     *
     * @date 2020/7/23 22:37
     **/
    @ExceptionHandler(IceBaseException.class)
    public IceErrorResponse applicationException(HttpServletResponse response, IceBaseException exception) {
        response.setStatus(exception.getHttpCode());
        log.error(exception.getMessage());
        return new IceErrorResponse(exception.getCode(), exception.getMessage());
    }


    /**
     * 系统异常
     *
     * @param response HttpServletResponse
     * @return 返回响应信息
     */
    @ExceptionHandler(Exception.class)
    public IceErrorResponse exception(HttpServletResponse response, Exception exception) {
        response.setStatus(500);
        log.error(exception.getMessage());
        exception.printStackTrace();
        return new IceErrorResponse("500", "服务器异常");
    }

}
