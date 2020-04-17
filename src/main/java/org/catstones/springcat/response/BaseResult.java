package org.catstones.springcat.response;
import lombok.Getter;
import lombok.Setter;

/**
 * @author An Nyeong
 */
@Setter
@Getter
public class BaseResult {

    private boolean success;

    private String message;

}
