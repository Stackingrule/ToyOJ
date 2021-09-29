package com.nowcode.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @Title: CommonUtils
 * @Package: com.nowcode.utils
 * @description: 通用工具类
 * @author: Stackingrule
 * @created: 2021/08/21 09:05
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
public class CommonUtils {

    /**
     * 生成随机字符串
     * @return {@link String}
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * MD5加密
     * @param key {@link String}
     * @return {@link String}
     */
    public static String md5(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    /**
     *
     * @return {@link String}
     */
    public static String generateSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
