package org.mastercs.cyborg.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonUtils() {
    }

    /**
     * object -> json
     *
     * @param arg 序列化对象
     * @return 序列化后的json字符串
     */
    public static String serialize(Object arg) {
        try {
            return MAPPER.writeValueAsString(arg);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    /**
     * json -> object
     *
     * @param json      json字符串
     * @param typeClass 类型
     * @param <T>       泛型
     * @return 返回type class对象实例
     */
    public static <T> T deserialize(String json, Class<T> typeClass) {
        try {
            MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return MAPPER.readValue(json, typeClass);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    /**
     * 带有泛型的对象
     *
     * @param json          json字符串
     * @param typeReference 泛型
     * @param <T>           泛型
     * @return 泛型对象实例
     */
    public static <T> T deserialize(String json, TypeReference<T> typeReference) {
        try {
            MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
            return MAPPER.readValue(json, typeReference);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }
}