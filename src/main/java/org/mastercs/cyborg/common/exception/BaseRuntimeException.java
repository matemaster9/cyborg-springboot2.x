package org.mastercs.cyborg.common.exception;

import org.mastercs.cyborg.constant.CommonErrorCode;
import org.mastercs.cyborg.constant.ErrorCode;

public class BaseRuntimeException extends RuntimeException{

    private final ErrorCode errorCode;

    private final Object extraMessage;


    public BaseRuntimeException() {
        super(CommonErrorCode.UNKNOWN.getMessage());
        errorCode = CommonErrorCode.UNKNOWN;
        extraMessage = null;
    }

    public BaseRuntimeException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.extraMessage = null;
    }

    public BaseRuntimeException(ErrorCode errorCode, Object extraMessage) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.extraMessage = extraMessage;
    }
}