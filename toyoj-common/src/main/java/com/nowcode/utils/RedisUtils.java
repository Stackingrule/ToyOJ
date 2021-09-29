package com.nowcode.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @Title: RedisUtils
 * @Package: com.nowcode.utils
 * @description: Redis功能封装
 * @author: Stackingrule
 * @created: 2021/09/18 23:03
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
public class RedisUtils {

    private static final String SPLIT = ":";
    private static final String PREFIX_KAPTCHA = "kaptcha";

    private static final Logger LOG = LoggerFactory.getLogger(RedisUtils.class);

    @Resource
    private RedisTemplate redisTemplate;


    /**
     * 获取验证码
     * @param owner
     * @return
     */
    public static String getKaptcha(String owner) {
        return PREFIX_KAPTCHA + SPLIT + owner;
    }
}
