package com.nowcode.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "test", tags = {"test"})
@RequestMapping("/hello")
public interface HelloControllerApi {

    @ApiOperation(value = "验证码接口", notes = "验证码接口", httpMethod = "GET")
    @GetMapping("/hello")
    String hello();
}
