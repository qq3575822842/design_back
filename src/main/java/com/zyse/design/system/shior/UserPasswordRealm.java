package com.zyse.design.system.shior;


import com.zyse.design.controller.sys.SysUserController;
import com.zyse.design.pojo.sys.SysUser;
import com.zyse.design.service.sys.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 用户密码登录realm
 */

public class UserPasswordRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(UserPasswordRealm.class);
    @Autowired
    private SysUserService sysUserService;;


    @Override
    public String getName() {
        return LoginType.USER_PASSWORD.getType();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        if (token instanceof UserToken) {
            return ((UserToken) token).getLoginType() == LoginType.USER_PASSWORD;
        } else {
            return false;
        }
    }

    @Override
    public void setAuthorizationCacheName(String authorizationCacheName) {
        super.setAuthorizationCacheName(authorizationCacheName);
    }

    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("---------------- 用户密码登录 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String userLogin = token.getUsername();
        // 从数据库获取对应用户名密码的用户
        SysUser sysUser = sysUserService.selectByLogin(userLogin);
        if (sysUser != null) {
            // 用户为禁用状态
            if (!sysUser.getLoginFlag().equals("1")) {
                throw new DisabledAccountException();
            }
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    /**
                     *  用户
                     */
                    sysUser,
                    /**
                     *  密码
                     */
                    sysUser.getPassword(),
                    /**
                     * realm name
                     */
                    getName()
            );
            System.out.println( sysUser.getPassword());
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
