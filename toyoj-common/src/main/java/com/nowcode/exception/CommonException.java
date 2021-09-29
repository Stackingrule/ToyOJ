package com.nowcode.exception;

/**
 * @Title: CommonException
 * @Package: com.nowcode.exception
 * @description: 同一异常处理类
 * @author: Stackingrule
 * @created: 2021/09/18 22:08
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
public class CommonException extends RuntimeException {

    private CommonExceptionCode code;

    public CommonException(CommonExceptionCode code) {
        super(code.getDesc());
        this.code = code;
    }

    public CommonExceptionCode getCode() {
        return code;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
