package org.catstones.springcat.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
