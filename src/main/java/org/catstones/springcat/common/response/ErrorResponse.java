package org.catstones.springcat.common.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
