package com.tang.toyoj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: HelloController
 * @Package: com.tang.toyoj.controller
 * @description: Hello
 * @author: Stackingrule
 * @created: 2020/10/01 18:04
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "<h1>Welcome to ToyOJ</h1>";
    }
}
