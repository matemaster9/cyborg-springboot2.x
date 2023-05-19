package org.mastercs.cyborg.common.webcore;

import org.apache.commons.lang3.ArrayUtils;
import org.mastercs.cyborg.model.SuccessResponse;
import org.mastercs.cyborg.util.JsonUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

@ControllerAdvice
public class ResponseControllerAdviceImpl implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        GetMapping get = methodParameter.getMethodAnnotation(GetMapping.class);
        PostMapping post = methodParameter.getMethodAnnotation(PostMapping.class);
        PutMapping put = methodParameter.getMethodAnnotation(PutMapping.class);
        DeleteMapping delete = methodParameter.getMethodAnnotation(DeleteMapping.class);

        String[] methods = new String[0];
        if (get != null) {
            methods = get.value();
        }
        if (post != null) {
            methods = post.value();
        }
        if (put != null) {
            methods = put.value();
        }
        if (delete != null) {
            methods = delete.value();
        }

        return ArrayUtils.isNotEmpty(methods);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        // 保证后端统一接口返回操作 不影响 swagger.json
        Method method = methodParameter.getMethod();
        if (method != null && "openapiJson".equals(method.getName())) {
            return data;
        }

        // 避免返回String类型报错
        return (data instanceof String) ? JsonUtils.serialize(new SuccessResponse<>(data)) : new SuccessResponse<>(data);
    }
}