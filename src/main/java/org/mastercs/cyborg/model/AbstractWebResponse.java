package org.mastercs.cyborg.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class AbstractWebResponse {

    /**
     * 响应码
     */
    protected String code;

    /**
     * 响应信息
     */
    protected String message;

    /**
     * 请求时间戳
     */
    protected long timestamp;
}
