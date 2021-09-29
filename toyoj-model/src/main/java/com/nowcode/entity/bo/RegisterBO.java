package com.nowcode.entity.bo;

import javax.validation.constraints.NotNull;

/**
 * @Title: RegisterBO
 * @Package: com.nowcode.entity.bo
 * @description:
 * @author: Stackingrule
 * @created: 2021/08/20 23:04
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
public class RegisterBO {

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;

    @NotNull(message = "邮箱不能为空")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
