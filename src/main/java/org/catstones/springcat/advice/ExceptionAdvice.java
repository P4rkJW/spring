package org.catstones.springcat.advice;

import javax.servlet.http.HttpServletRequest;
import org.catstones.springcat.response.BaseResult;
import org.catstones.springcat.service.ResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {

    private final ResponseService response;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected BaseResult defaultEception(HttpServletRequest request, Exception e) {
        return response.getFailResult("실패!");
    }
}
