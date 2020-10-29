package com.ogx.shop.controller.admin.index;

import cn.hutool.captcha.CircleCaptcha;
import com.ogx.shop.config.Constants;
import com.ogx.shop.config.UserToken;
import com.ogx.shop.dao.RoleMapper;
import com.ogx.shop.entity.Role;
import com.ogx.shop.entity.SysAuthority;
import com.ogx.shop.service.CustomerService;
import com.ogx.shop.service.SysAuthorityService;
import com.ogx.shop.vo.ResultVo;
import com.ogx.shop.vo.enums.LoginType;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @program: shop
 * @description:后台登录,登出
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title: AdminLoginController
 **/

@Controller
@RequestMapping(value = "${adminPath}")
public class AdminLoginController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SysAuthorityService sysAuthorityService;

    @Resource
    private RoleMapper roleMapper;

    private static final String ADMIN_LOGIN_TYPE = LoginType.ADMIN.toString();

    /**
     * 登录
     *
     * @param
     * @param
     * @param request
     * @param response
     * @return
     */
    /*@RequestMapping("/doLogin1")
    @ResponseBody
    public ResultVo doLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("vercode") String vercode,
                            HttpServletRequest request, HttpServletResponse response) {
        String error = null;
        HttpSession session = request.getSession();

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return null;
        }
        if (StringUtils.isBlank(vercode)) {
            return null;
        }
        if (session == null) {
            return null;
        }
        // 从Session中获取验证码 判断验证码是否已过期（验证码是放在session中，过期后页面会报500）
        if ((CircleCaptcha) session.getAttribute(Constants.VALIDATE_CODE) == null) {
            return null;
        }
        CircleCaptcha captcha = (CircleCaptcha) session.getAttribute(Constants.VALIDATE_CODE);
        if (StringUtils.isBlank(captcha.getCode())) {
            return null;
        }
        else {
            // 创建Subject实例
            Subject subject = SecurityUtils.getSubject();

            SysAuthority sysAuthority = sysAuthorityService.selectByName(username);

            *//*String newPassword;

            if (sysAuthority.getUsername() != "admin"){
                //获取盐值
                ByteSource salt = ByteSource.Util.bytes(username);
                newPassword = new SimpleHash("MD5", password, salt, 1).toHex();
                System.out.println(newPassword);
            }
            else {
                newPassword = password;
            }*//*

 //           ByteSource salt = ByteSource.Util.bytes(username);
//           String salt1 = String.valueOf(salt);
//          System.out.println(salt);
//
//           //加密明文密码
//           String newPassword = new SimpleHash("MD5", password, salt, 1024).toHex();


            System.out.println(password);
            // 将用户名及密码封装到UsernamePasswordToken
           *//* UserToken token = new UserToken(username, password,ADMIN_LOGIN_TYPE);*//*
            UserToken token = new UserToken(username, password ,ADMIN_LOGIN_TYPE);

            try {
                subject.login(token);
                // 判断当前用户是否登录
                if (subject.isAuthenticated() == true) {
                    //获取session
                    int roleno = Integer.parseInt(sysAuthority.getRoleNo());
                    //获得该用户角色
                    Role role = roleMapper.selectRoleNameByRoleNo(roleno);
                    session.setAttribute("sysAuthority", sysAuthority);
                    session.setAttribute("role",role);
                    return new ResultVo(1, "登陆成功", null);
                }
            } catch (IncorrectCredentialsException e) {
                error = "登录密码错误.";
            } catch (ExcessiveAttemptsException e) {
                error = "登录失败次数过多";
            } catch (LockedAccountException e) {
                error = "帐号已被锁定.";
            } catch (DisabledAccountException e) {
                error = "帐号已被禁用.";
            } catch (ExpiredCredentialsException e) {
                error = "帐号已过期.";
            } catch (UnknownAccountException e) {
                error = "帐号不存在";
            } catch (UnauthorizedException e) {
                error = "您没有得到相应的授权！";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResultVo(0, error, null);
    }*/
    @RequestMapping("/doLogin2")
    @ResponseBody
    public ResultVo doLogin2(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("vercode") String vercode,
                             HttpServletRequest request, HttpServletResponse response) {

        String error = null;
        HttpSession session = request.getSession();

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return null;
        }
        if (StringUtils.isBlank(vercode)) {
            return null;
        }
        if (session == null) {
            return null;
        }
        // 从Session中获取验证码 判断验证码是否已过期（验证码是放在session中，过期后页面会报500）
        if ((CircleCaptcha) session.getAttribute(Constants.VALIDATE_CODE) == null) {
            return null;
        }
        CircleCaptcha captcha = (CircleCaptcha) session.getAttribute(Constants.VALIDATE_CODE);
        if (StringUtils.isBlank(captcha.getCode())) {
            return null;
        }
        else {
            // 创建Subject实例
            Subject subject = SecurityUtils.getSubject();

            SysAuthority sysAuthority = sysAuthorityService.selectByName(username);
            //获取盐值
            ByteSource salt = ByteSource.Util.bytes(username);
            //加密
            String newPs = new SimpleHash("MD5", password, salt, 1024).toHex();
            /*if (str.equals("admin")){
                newPs = password;
                System.out.println("11111");
            } else {
                ByteSource salt = ByteSource.Util.bytes(str);
                newPs = new SimpleHash("MD5", password, salt, 1024).toHex();
                System.out.println(newPs);
            }*/
            // 将用户名及密码封装到UsernamePasswordToken
            /* UserToken token = new UserToken(username, password,ADMIN_LOGIN_TYPE);*/
            UserToken token = new UserToken(username, newPs ,ADMIN_LOGIN_TYPE);

            try {
                subject.login(token);
                // 判断当前用户是否登录
                if (subject.isAuthenticated() == true) {
                    //获取session
                    int roleno = Integer.parseInt(sysAuthority.getRoleNo());
                    //获得该用户角色
                    Role role = roleMapper.selectRoleNameByRoleNo(roleno);
                    session.setAttribute("sysAuthority", sysAuthority);
                    session.setAttribute("role",role);
                    return new ResultVo(1, "登陆成功", null);
                }
            } catch (IncorrectCredentialsException e) {
                error = "登录密码错误.";
            } catch (ExcessiveAttemptsException e) {
                error = "登录失败次数过多";
            } catch (LockedAccountException e) {
                error = "帐号已被锁定.";
            } catch (DisabledAccountException e) {
                error = "帐号已被禁用.";
            } catch (ExpiredCredentialsException e) {
                error = "帐号已过期.";
            } catch (UnknownAccountException e) {
                error = "帐号不存在";
            } catch (UnauthorizedException e) {
                error = "您没有得到相应的授权！";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResultVo(0, error, null);
    }


    /**
     * 登出
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/logout1")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("sysAuthority");
        return "admin/login";
    }

    /**
     * 重置密码
     *
     * @param request
     * @return
     */
    @RequestMapping("/repassword1")
    public String repassword1(HttpServletRequest request) {
        String repassword = request.getParameter("repassword");
        return "admin/login";
    }

    /**
     * 注册
     * @param request
     * @return
     */
    /*@RequestMapping("/register2")
    @ResponseBody
    public ResultVo register2(HttpServletRequest request) {
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        SysAuthority sysAuthority=new SysAuthority();
        sysAuthority.setUsername(username);
        sysAuthority.setPassword(password);
        int flag = sysAuthorityService.registerData1(sysAuthority);
        if (flag == 1) {
            return new ResultVo(1,"注册成功",null);
        }
        return new ResultVo(2,"该账号已被注册",null);
    }*/

    /**
     * 注册功能
     */
//    public int registerData(Customer customer) {
//        // 将用户名作为盐值
//        ByteSource salt = ByteSource.Util.bytes(customer.getCustName());
//        /*
//         * MD5加密：
//         * 使用SimpleHash类对原始密码进行加密。
//         * 第一个参数代表使用MD5方式加密
//         * 第二个参数为原始密码
//         * 第三个参数为盐值，即用户名
//         * 第四个参数为加密次数
//         * 最后用toHex()方法将加密后的密码转成String
//         * */
//        String newPs = new SimpleHash("MD5", customer.getCustCode(), salt, 1024).toHex();
//        customer.setCustCode(newPs);
//        // 看数据库中是否存在该账户
//        Customer customer1 = customerMapper.selectByName(customer.getCustName());
//        if(customer1 == null) {
//            customerMapper.insertSelective(customer);
//            return 1;
//        }else {
//            return 0;
//        }
//    }




}

