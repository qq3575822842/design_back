package com.zyse.design.pojo.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 * @description:功能描述
 * @ClassName:SysUser.java
 * @Author: yc
 * @date: 2019/3/27 14:08
 * @Version:1.0
 */
public class SysUser implements Serializable {
    /**
     *登陆用户key
     */
    private String userKey;
    /**
     *登陆用户权限
     */
    private String userRole;
    /**
     *登陆用户名称
     */
    private String userName;
    /**
     *登陆用户账号
     */
    private String userLogin;
    /**
     *登陆用户密码
     */
    private String password;
    /**
     *用户手机号
     */
    private String userPhone;
    /**
     *用户创建时间
     */
    private Date createTime;

    private String  loginFlag;

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey == null ? null : userKey.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin == null ? null : userLogin.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }
}