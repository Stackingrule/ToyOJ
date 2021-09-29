package com.nowcode.user.controller;

import com.google.code.kaptcha.Producer;
import com.nowcode.api.controller.PassportControllerApi;
import com.nowcode.entity.bo.LoginBO;
import com.nowcode.entity.bo.RegisterBO;
import com.nowcode.exception.CommonExceptionCode;
import com.nowcode.user.service.PassportService;
import com.nowcode.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Title: PassportController
 * @Package: com.nowcode.user.controller
 * @description:
 * @author: Stackingrule
 * @created: 2021/08/20 22:55
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */

@RestController
public class PassportController extends BaseController implements PassportControllerApi {

    private static final Logger LOG = LoggerFactory.getLogger(PassportController.class);

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private Producer kaptchaProducer;

    @Autowired
    private RedisOperator redisOperator;

    @Autowired
    private SnowFlake snowFlake;


    @Autowired
    private PassportService passportService;

    @Override
    public JSONResponse getEmailCode(String userEmail, HttpServletRequest request) {
        return null;
    }

    @Override
    public JSONResponse register(RegisterBO registerBO, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        passportService.register(registerBO);
        return null;
    }

    @Override
    public JSONResponse login(LoginBO loginBO, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        //JSONResponse response =
        return null;
    }

    @Override
    public JSONResponse logout(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public void getKaptcha(HttpServletResponse response) {
        // 生成验证码
        String text = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(text);

        // 验证码归属
        String kaptchaOwner = CommonUtils.generateUUID();
        Cookie cookie = new Cookie("kaptchaOwner", kaptchaOwner);
        cookie.setMaxAge(120);
        cookie.setPath(contextPath);
        response.addCookie(cookie);

        // 将验证码存入Redis
        String redisKey = RedisKeyUtils.getKaptchaKey(kaptchaOwner);
        redisOperator.set(redisKey, text, 120);

        // 将验证码输出给浏览器
        response.setContentType("/image/png");
        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            LOG.error("响应验证码失败" + e.getMessage());
        }
    }

    @Override
    public void activation(HttpServletResponse response) {

    }

}
