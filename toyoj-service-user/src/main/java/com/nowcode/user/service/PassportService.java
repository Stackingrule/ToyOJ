package com.nowcode.user.service;

import com.nowcode.entity.User;
import com.nowcode.entity.UserExample;
import com.nowcode.entity.bo.LoginBO;
import com.nowcode.entity.bo.RegisterBO;
import com.nowcode.exception.CommonException;
import com.nowcode.exception.CommonExceptionCode;
import com.nowcode.user.mapper.UserMapper;
import com.nowcode.utils.CommonUtils;
import com.nowcode.utils.JSONResponse;
import com.nowcode.utils.MailClient;
import com.nowcode.utils.RedisKeyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Title: PassportController
 * @Package: com.nowcode.user.service
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/01 09:57
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
@Service
public class PassportService {

    private static final Logger LOG = LoggerFactory.getLogger(PassportService.class);

    @Resource
    private MailClient mailClient;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;


    @Resource
    private TemplateEngine templateEngine;

    @Value("${toyoj.path.domain}")
    private String domain;

    @Value("${server.servlet.context-path}")
    private String contextPath;


    public Map<String, Object> register(RegisterBO registerBO) {
        JSONResponse response = new JSONResponse();
        Map<String, Object> map = new HashMap<>();

        // 验证账号
        User user = selectByName(registerBO.getUsername());
        if (user != null) {
            map.put("usernameMsg", "该账号已存在!");
        }

        // 验证邮箱
        user = selectByEmail(registerBO.getEmail());
        if (user != null) {
            map.put("emailMsg", "该邮箱已被注册!");
        }

        // 注册用户
        user = new User();
        user.setSalt(CommonUtils.generateSalt());
        user.setUsername(registerBO.getUsername());
        user.setPassword(CommonUtils.md5(user.getPassword() + user.getSalt()));
        user.setType(0);
        user.setStatus(1);
        user.setActivationCode(CommonUtils.generateUUID());
        user.setHeaderUrl("");
        user.setCreateTime(new Date());

        userMapper.insert(user);

        //  激活邮件
        Context context = new Context();
        context.setVariable("email", user.getEmail());
        // http://localhost:8080/community/activation/101/code
        String url = domain + contextPath + "/activation/" + user.getId() + "/" + user.getActivationCode();
        context.setVariable("url", url);
        String content = templateEngine.process("/mail/activation", context);
        mailClient.sendMail(user.getEmail(), "激活账号", content);

        response.setData(map);


        return map;
    }

    public void login(LoginBO loginBO) {
        User user = selectByEmail(loginBO.getEmail());
        User u = selectByName(loginBO.getEmail());
        if (ObjectUtils.isEmpty(user)) {
            LOG.info("用户不存在, {}", loginBO.getEmail());
            throw new CommonException(CommonExceptionCode.LOGIN_USER_ERROR);
        } else {
            if (StringUtils.equals(loginBO.getPassword(), user.getPassword())) {
                return;
            } else {
                // 密码不对
                //LOG.info("密码不对, 输入密码：{}, 数据库密码：{}", req.getPassword(), userDb.getPassword());
                throw new CommonException(CommonExceptionCode.LOGIN_USER_ERROR);
            }
        }
    }

    public int activation(int userId, String code) {
        User user = selectById(userId);
//        if (user.getStatus() == 1) {
//            return ACTIVATION_REPEAT;
//        } else if (user.getActivationCode().equals(code)) {
//            userMapper.updateStatus(userId, 1);
//            clearCache(userId);
//            return ACTIVATION_SUCCESS;
//        } else {
//            return ACTIVATION_FAILURE;
//        }

        return 0;
    }

    public User selectByEmail(String email) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        } else {
            return userList.get(0);
        }
    }

    public User selectByName(String name) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        } else {
            return userList.get(0);
        }
    }

    public User selectById(int userId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(userId);
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        } else {
            return userList.get(0);
        }
    }



    // 1.优先从缓存中取值
    private User getCache(int userId) {
        String redisKey = RedisKeyUtils.getUserKey(userId);
        return (User) redisTemplate.opsForValue().get(redisKey);
    }

    // 2.取不到时初始化缓存数据
    private User initCache(int userId) {
        User user = selectById(userId);
        String redisKey = RedisKeyUtils.getUserKey(userId);
        redisTemplate.opsForValue().set(redisKey, user, 3600, TimeUnit.SECONDS);
        return user;
    }

    // 3.数据变更时清除缓存数据
    private void clearCache(int userId) {
        String redisKey = RedisKeyUtils.getUserKey(userId);
        redisTemplate.delete(redisKey);
    }
}
