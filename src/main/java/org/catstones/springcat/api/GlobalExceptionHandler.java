package org.catstones.springcat.api;

import org.catstones.springcat.common.response.ErrorResponse;
import org.catstones.springcat.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ErrorResponse handleBusinessException(BusinessException e) {
    // TODO: ResponseEntity
    ErrorResponse response =
        ErrorResponse.builder().message(e.getMessage()).status(e.getStatus()).build();
    return response;
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  protected ErrorResponse handleGlobalException(Exception e) {
    ErrorResponse response = ErrorResponse.builder().message(e.getMessage()).status(500).build();
    return response;
  }
}
