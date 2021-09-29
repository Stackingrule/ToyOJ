package com.nowcode.user;

import com.nowcode.entity.User;
import com.nowcode.user.service.PassportService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title: UserTests
 * @Package: com.nowcode.user
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/22 21:39
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ToyojUserApplication.class)
public class UserTests {

    @Autowired
    private PassportService passportService;

    @Test
    public void testSelectByName() {
        User u = passportService.selectByName("TestName00");
        System.out.println(u.getEmail());
        System.out.println(u.getId());
        Assert.assertEquals("123456@123.com", u.getEmail());
        Assert.assertEquals("1234567890", u.getPassword());
    }
}
