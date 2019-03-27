package com.zyse.design.controller.sys;

import com.zyse.design.pojo.sys.SysUser;
import com.zyse.design.service.sys.SysUserService;
import com.zyse.design.untils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.util.List;

/**
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

    @PostMapping(value = ("PostSelectSysUser"))
    @CrossOrigin
    public String selectSysUserController(SysUser sysUser) {

        List<SysUser> selectByLogin = sysUserService.selectByLogin(sysUser);
        result = JSON.toJSONString(new ResultUtil(-1, true, "账号不存在"));
        if (selectByLogin.size() > 0) {
            List<SysUser> selectByUser = sysUserService.selectByUser(sysUser);
            if (selectByUser.size() > 0) {
                return result = JSON.toJSONString(new ResultUtil(0, true, "登陆成功"));
            }
        }

        result = JSON.toJSONString(new ResultUtil(0, true, "密码错误"));
        return result;
    }

    @PostMapping(value = ("PostInsertSysUser"))
    @CrossOrigin
    public String insertSysUser(SysUser sysUser) {

        try {
            List<SysUser> selectByLogin = sysUserService.selectByLogin(sysUser);
            if (selectByLogin.size() > 0) {
                return result = JSON.toJSONString(new ResultUtil(-1, true, "手机已经被注册"));
            }
            sysUserService.insertSysUser(sysUser);
            result = JSON.toJSONString(new ResultUtil(0, true, "插入成功"));
        } catch (Exception e) {
            e.printStackTrace();
            result = JSON.toJSONString(new ResultUtil(0, true, "插入失败" + e));
        }
        return result;
    }
}