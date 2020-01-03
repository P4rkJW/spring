package org.catstones.springcat.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author An Nyeong
 */
@Setter
@Getter
public class BaseResult {

    @ApiModelProperty(value = "성공 여부")
    private boolean success;

    @ApiModelProperty(value = "메시지")
    private String message;

}
