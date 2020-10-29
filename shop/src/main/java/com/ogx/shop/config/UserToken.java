package com.ogx.shop.config;

import org.apache.shiro.authc.UsernamePasswordToken;


/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: UserToken
 **/

public class UserToken extends UsernamePasswordToken {
    /**
     * 登录类型，判断是客户登录，还是管理员登录
     * */
    private String loginType;

    public UserToken(final String username, final String password,String loginType) {
        super(username,password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
