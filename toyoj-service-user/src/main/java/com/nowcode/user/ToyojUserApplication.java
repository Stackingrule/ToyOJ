package com.nowcode.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.PostConstruct;

/**
 * @Title: ToyojUserApplication
 * @Package: com.nowcode.user.controller
 * @description:
 * @author: Stackingrule
 * @created: 2021/08/20 22:39
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.nowcode.user.mapper")
@ComponentScan(basePackages = {"com.nowcode", "org.n3r.idworker"})
public class ToyojUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToyojUserApplication.class, args);
    }
}
