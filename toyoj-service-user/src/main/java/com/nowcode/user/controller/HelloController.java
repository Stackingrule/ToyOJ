package com.nowcode.user.controller;

import com.nowcode.api.controller.HelloControllerApi;

import javax.servlet.http.HttpServletResponse;

/**
 * @Title: HelloController
 * @Package: com.nowcode.user.controller
 * @description:
 * @author: Stackingrule
 * @created: 2021/08/20 22:44
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
public class HelloController implements HelloControllerApi {

    @Override
    public String hello() {
        return "Hello";
    }
}
