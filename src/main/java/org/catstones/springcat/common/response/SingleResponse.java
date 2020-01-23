package org.catstones.springcat.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResponse<T> extends BaseResponse {
  private T data;

  public SingleResponse(T data) {
    this.data = data;
  }
}
