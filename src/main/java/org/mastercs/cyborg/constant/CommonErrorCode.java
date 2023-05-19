package org.mastercs.cyborg.constant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    SUCCESS("0000", "请求成功"),

    UNKNOWN("CSV0001", "未知错误"),

    ILLEGAL_PARAM("CSV0002", "非法参数");

    private final String code;
    private final String message;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
