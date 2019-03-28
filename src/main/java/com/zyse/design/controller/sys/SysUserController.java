package com.zyse.design.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.zyse.design.pojo.sys.SysUser;
import com.zyse.design.service.sys.SysUserService;
import com.zyse.design.system.enums.ResultStatusCode;
import com.zyse.design.system.shior.LoginType;
import com.zyse.design.system.shior.UserToken;
import com.zyse.design.untils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * 用户登录插入方法
 * @description:功能描述
 * @ClassName:SysUserController.java
 * @Author: yc
 * @date: 2019/3/27 13:26
 * @Version:1.0
 */
@RestController
@RequestMapping("SysUserController")
public class SysUserController {


    private static Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    SysUserService sysUserService;
    /**
     * 定义返回参数
     */
    private String result = null;

//    @PostMapping(value = ("PostSelectSysUser"))
//    @CrossOrigin
//    public String selectSysUserController(SysUser sysUser) {
//
//        List<SysUser> selectByLogin = sysUserService.selectByLogin(sysUser);
//        result = JSON.toJSONString(new ResultUtil(-1, "账号不存在"));
//        if (selectByLogin.size() > 0) {
//            List<SysUser> selectByUser = sysUserService.selectByUser(sysUser);
//            if (selectByUser.size() > 0) {
//                return result = JSON.toJSONString(new ResultUtil(0, "登陆成功"));
//            }
//        }
//
//        result = JSON.toJSONString(new ResultUtil(0, "密码错误"));
//        return result;
//    }

    @PostMapping(value = ("PostInsertSysUser"))
    @CrossOrigin
    public String insertSysUser(SysUser sysUser) {

        try {
            SysUser sysUser1 = sysUserService.selectByLogin(sysUser.getUserLogin());
            if (sysUser1 != null) {
                return result = JSON.toJSONString(new ResultUtil(-1, "手机已经被注册"));
            }
            sysUserService.insertSysUser(sysUser);
            result = JSON.toJSONString(new ResultUtil(0, "插入成功"));
        } catch (Exception e) {
            e.printStackTrace();
            result = JSON.toJSONString(new ResultUtil(0, "插入失败"+ e ));
        }
        return result;
    }
    /**
     * 用户密码登录
     * @param loginName
     * @param pwd
     * @return
     */
    @RequestMapping("/login")
    public ResultUtil login(@Param("loginName")String loginName, @Param("pwd")String pwd){
        UserToken token = new UserToken(LoginType.USER_PASSWORD, loginName, pwd);
        return shiroLogin(token);
    }

    public ResultUtil shiroLogin(UserToken token){
        try {
            //登录不在该处处理，交由shiro处理
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);

            if (subject.isAuthenticated()) {
                JSON json = new JSONObject();
                ((JSONObject) json).put("token", subject.getSession().getId());

                return new ResultUtil(ResultStatusCode.OK, json);
            }else{
                return new ResultUtil(ResultStatusCode.SHIRO_ERROR);
            }
        }catch (IncorrectCredentialsException | UnknownAccountException e){
            e.printStackTrace();
            return new ResultUtil(ResultStatusCode.NOT_EXIST_USER_OR_ERROR_PWD);
        }catch (LockedAccountException e){
            System.out.println(e);
            return new ResultUtil(ResultStatusCode.USER_FROZEN);
        }catch (Exception e){
            System.out.println(e);
            return new ResultUtil(ResultStatusCode.SYSTEM_ERR);
        }
    }
    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public ResultUtil logout(){
        SecurityUtils.getSubject().logout();
        return new ResultUtil(ResultStatusCode.OK);
    }
}