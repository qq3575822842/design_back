package com.zyse.design.controller;


import com.zyse.design.system.enums.ResultStatusCode;
import com.zyse.design.untils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/common")
@RestController
/**
 * 判断是不是登陆后的信息
 * @description:功能描述
 * @ClassName:CommonController.java
 * @Author: yc
 * @date: 2019/3/28 11:25
 * @Version:1.0
 */
public class CommonController {

    /**
     * 未授权跳转方法
     * @return
     */
    @RequestMapping("/unauth")
    public ResultUtil unauth(){
        SecurityUtils.getSubject().logout();
        return new ResultUtil(ResultStatusCode.UNAUTHO_ERROR);
    }

    /**
     * 被踢出后跳转方法
     * @return
     */
    @RequestMapping("/kickout")
    public ResultUtil kickout(){
        return new ResultUtil(ResultStatusCode.INVALID_TOKEN);
    }

}
