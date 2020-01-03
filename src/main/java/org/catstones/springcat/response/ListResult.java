package org.catstones.springcat.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResult<T> extends BaseResult {
    private List<T> list;
}
