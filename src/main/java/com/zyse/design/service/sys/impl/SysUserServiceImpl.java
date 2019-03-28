package com.zyse.design.service.sys.impl;

import com.zyse.design.mapper.sys.SysUserMapper;
import com.zyse.design.pojo.sys.SysUser;
import com.zyse.design.service.sys.SysUserService;
import com.zyse.design.untils.MD5Util;
import com.zyse.design.untils.UUIDKeyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> selectByUser(SysUser sysUser) {
       List<SysUser> selectByUser=  sysUserMapper.selectByUser(sysUser);
        return selectByUser;
    }

    @Override
    public SysUser selectByLogin(String name) {
        //sysUser.setUserPasword(CryptorgaphyUtil.encBase64(sysUser.getUserPasword()));
        SysUser selectByLogin=  sysUserMapper.selectByLogin(name);
        return selectByLogin;
    }

    @Override
    public int insertSysUser(SysUser sysUser) {
        sysUser.setUserKey(UUIDKeyUtil.uuIdKey());
        sysUser.setPassword(MD5Util.encrypt(sysUser.getPassword()));
        return sysUserMapper.insertSysUser(sysUser);
    }
}