package org.catstones.springcat.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse extends BaseResponse {
  private String message;
  private LocalDateTime timestamp;
  private int status;

  @Builder
  public ErrorResponse(String message, int status) {
    this.message = message;
    this.status = status;
    this.setSuccess(false);
    this.timestamp = LocalDateTime.now();
  }
}
