package com.hzqing.common.rest.exception;

import com.hzqing.common.rest.result.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 衡钊清
 * @classname GlobalExceptionHandler
 * @description TODO
 * @date 2021-02-03 下午10:39
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 404异常处理
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ResponseBody
    public ErrorResult errorHandler(HttpServletRequest request, NoHandlerFoundException exception, HttpServletResponse response) {
        ErrorResult errorResult = new ErrorResult("405", "ll");
        return errorResult;
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorResult errorHandler(HttpServletRequest request, AccessDeniedException e, HttpServletResponse response) {
        ErrorResult result = new ErrorResult("405", e.getMessage());
        return result;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResult errorHandler(HttpServletRequest request, Exception exception, HttpServletResponse response) {
        ErrorResult errorResult = new ErrorResult("40445", exception.getMessage());
        return errorResult;
    }

}
