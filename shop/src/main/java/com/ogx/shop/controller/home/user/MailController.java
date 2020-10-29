package com.ogx.shop.controller.home.user;

import com.ogx.shop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: MailController
 **/
@Controller
@RequestMapping(value = "${frontPath}")
public class MailController {
    @Autowired
    private MailService mailService;

    /**
     * 邮箱注册
     * @param email
     * @return
     */
    @RequestMapping("getCheckCode")
    @ResponseBody
    public String getCheckCode(String email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
        return checkCode;
    }
}
