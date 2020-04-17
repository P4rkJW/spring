package org.catstones.springcat.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  private final int status;

  public BusinessException(String msg, int status) {
    super(msg);
    this.status = status;
  }
}
