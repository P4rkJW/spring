package org.catstones.springcat.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author
 */
@Getter
@Setter
public class SingleResult<T> extends BaseResult {
    private T data;
}
