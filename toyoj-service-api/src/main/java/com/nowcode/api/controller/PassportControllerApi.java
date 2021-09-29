package com.nowcode.api.controller;

import com.nowcode.entity.bo.LoginBO;
import com.nowcode.entity.bo.RegisterBO;
import com.nowcode.utils.JSONResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Title: PassportController
 * @Package: com.nowcode.api.controller
 * @description:
 * @author: Stackingrule
 * @created: 2021/08/19 11:41
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
@Api(value = "用户注册登录", tags = {"用户注册登录的controller"})
@RequestMapping("/passport")
public interface PassportControllerApi {

    @ApiOperation(value = "获得邮件验证码", notes = "获得邮件验证码", httpMethod = "GET")
    @GetMapping("/getEmailCode")
    public JSONResponse getEmailCode(String userEmail, HttpServletRequest request);

    @ApiOperation(value = "注册接口", notes = "注册接口", httpMethod = "POST")
    @PostMapping("/register")
    JSONResponse register(@Valid @RequestBody RegisterBO registerBO, BindingResult result,
                          HttpServletRequest request,
                          HttpServletResponse response);

    @ApiOperation(value = "登录接口", notes = "登录接口", httpMethod = "POST")
    @PostMapping("/login")
    JSONResponse login(@Valid @RequestBody LoginBO loginBO, BindingResult result,
                       HttpServletRequest request,
                       HttpServletResponse response);

    @ApiOperation(value = "登出接口", notes = "登出接口", httpMethod = "POST")
    @GetMapping("/logout")
    JSONResponse logout(
                       HttpServletRequest request,
                       HttpServletResponse response);

    @ApiOperation(value = "验证码接口", notes = "验证码接口", httpMethod = "GET")
    @GetMapping("/kaptcha")
    void getKaptcha(HttpServletResponse response);

    @ApiOperation(value = "验证码接口", notes = "验证码接口", httpMethod = "GET")
    @GetMapping("/activation")
    void activation(HttpServletResponse response);
}
