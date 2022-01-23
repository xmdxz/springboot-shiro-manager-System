package com.house.util;

import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Objects;

/**
 * @Author xpdxz
 * @ClassName RequestUtil
 * @Description TODO
 * @Date 2022/1/10 22:08
 */
public class RequestUtil {

    /**
     * 获取当前request的值
     *
     * @param parameter 参数
     * @return value
     */
    public static String getRequestValue(String parameter) {
        final RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (parameter == null || ObjectUtils.isEmpty(attributes)) {
            return null;
        }
        return (String) attributes.getAttribute(parameter, RequestAttributes.SCOPE_REQUEST);
    }

    public static Integer getUserId() {
        return Integer.parseInt(Objects.requireNonNull(getRequestValue("id")));
    }

    public static Integer getUserInfoId() {
        return Integer.parseInt(Objects.requireNonNull(getRequestValue("userInfoId")));
    }

    public static boolean allParamsIsNull(Object... params) {
        for (Object param : params) {
            if (ObjectUtils.isEmpty(param)) {
                return true;
            }
        }
        return false;
    }
}
