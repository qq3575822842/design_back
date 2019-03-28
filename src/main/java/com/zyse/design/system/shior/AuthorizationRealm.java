package com.zyse.design.system.shior;


import com.zyse.design.controller.sys.SysUserController;
import com.zyse.design.pojo.sys.SysUser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 统一角色授权控制策略
 * @description:功能描述
 * @ClassName:AuthorizationRealm.java
 * @Author: yc
 * @date: 2019/3/28 10:46
 * @Version:1.0
 */

public class AuthorizationRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(AuthorizationRealm.class);

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (principal instanceof SysUser) {
            SysUser userLogin = (SysUser) principal;
//            if(userLogin != null){
//                List<Role> roleList = roleService.findByUserid(userLogin.getId());
//                if(CollectionUtils.isNotEmpty(roleList)){
//                    for(Role role : roleList){
//                        info.addRole(role.getEnname());
//
//                        List<Menu> menuList = menuService.getAllMenuByRoleId(role.getId());
//                        if(CollectionUtils.isNotEmpty(menuList)){
//                            for (Menu menu : menuList){
//                                if(StringUtils.isNoneBlank(menu.getPermission())){
//                                    info.addStringPermission(menu.getPermission());
//                                }
//                            }
//                        }
//                    }
//                }
//            }
        }
        logger.info("---------------- 获取到以下权限 ----------------");
        logger.info(info.getStringPermissions().toString());
        logger.info("---------------- Shiro 权限获取成功 ----------------------");
        return info;
    }

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException{
        return null;
    }
}
