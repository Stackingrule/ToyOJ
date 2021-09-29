package com.nowcode.entity.bo;

/**
 * @Title: LoginBO
 * @Package: com.nowcode.entity.bo
 * @description:
 * @author: Stackingrule
 * @created: 2021/08/21 14:03
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class LoginBO {

    private String password;

    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
