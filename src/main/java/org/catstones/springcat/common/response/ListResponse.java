package org.catstones.springcat.common.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResponse<T> extends BaseResponse {
  final private List<T> list;
  final private int count;

  public ListResponse(List<T> list) {
    this.list = list;
    this.count = list.size();
  }
}
