package com.ogx.shop.shiro;

import com.ogx.shop.config.UserToken;
import com.ogx.shop.entity.SysAuthority;
import com.ogx.shop.service.SysAuthorityService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
@Component
public class AdminRealm  extends AuthorizingRealm {

    @Autowired
    private SysAuthorityService sysAuthorityService;

/*    @Autowired
    private RoleMapper roleMapper;*/


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 将token装换成UsernamePasswordToken
        UsernamePasswordToken upToken = (UserToken) authenticationToken;
        // 获取用户名即可
        String username = upToken.getUsername();
        // 查询数据库，是否查询到用户名和密码的用户
        SysAuthority sysAuthority = sysAuthorityService.selectByName(username);
        System.out.println(sysAuthority.toString());
        SimpleAuthenticationInfo info;
        if (sysAuthority != null) {
            // 如果查询到了，封装查询结果，返回给我们的调用
            Object principal = sysAuthority.getUsername();
            Object credentials = sysAuthority.getPassword();

            // 获取盐值，即用户名
            ByteSource salt = ByteSource.Util.bytes(username);

            String realmName = this.getName();
            // 将账户名，密码，盐值，realmName实例化到SimpleAuthenticationInfo中交给Shiro来管理
            info = new SimpleAuthenticationInfo(principal, credentials, salt, realmName);
        } else if ( null==sysAuthority) {
            // 帐号不存在 添加判断，解决数据库不区分用户名大小写
            throw new UnknownAccountException();
            // 如果没有查询到，抛出一个异常
        } else {
            throw new AuthenticationException();
        }
        return info;
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*System.out.println("————权限认证————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        System.out.println(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo( );
        //查询roleNo
        SysAuthority sysAuthority = sysAuthorityService.selectByName(username);
        int roleno = Integer.parseInt(sysAuthority.getRoleNo());
        //获得该用户角色
        Role role = roleMapper.selectRoleNameByRoleNo(roleno);
        info.addRole(role.getRoleName());
        System.out.println(info);

        return info;*/
        return null;
    }
}
