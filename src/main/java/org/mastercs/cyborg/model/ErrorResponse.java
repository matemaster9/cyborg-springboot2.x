package org.mastercs.cyborg.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mastercs.cyborg.constant.ErrorCode;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ErrorResponse extends AbstractWebResponse {

    /**
     * 接口报错信息
     */
    private Object errorBody;

    public ErrorResponse(ErrorCode errorCode) {
        setCode(errorCode.getCode());
        setMessage(errorCode.getMessage());
        setTimestamp(System.currentTimeMillis());
    }

    public ErrorResponse(String code, String errorMessage) {
        setCode(code);
        setMessage(errorMessage);
        setTimestamp(System.currentTimeMillis());
    }

    public ErrorResponse(String code, String errorMessage, Object errorBody) {
        setCode(code);
        setMessage(errorMessage);
        setTimestamp(System.currentTimeMillis());
        this.errorBody = errorBody;
    }
}