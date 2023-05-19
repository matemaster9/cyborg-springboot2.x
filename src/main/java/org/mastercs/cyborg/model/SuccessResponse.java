package org.mastercs.cyborg.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mastercs.cyborg.constant.CommonErrorCode;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class SuccessResponse<T> extends AbstractWebResponse {

    /**
     * 接口响应成功数据
     */
    private T data;

    public SuccessResponse(T data) {
        setCode(CommonErrorCode.SUCCESS.getCode());
        setMessage(CommonErrorCode.SUCCESS.getMessage());
        setTimestamp(System.currentTimeMillis());
        this.data = data;
    }
}