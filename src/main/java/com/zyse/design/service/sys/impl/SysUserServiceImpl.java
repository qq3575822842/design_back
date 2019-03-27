package com.zyse.design.service.sys.impl;

import com.zyse.design.mapper.sys.SysUserMapper;
import com.zyse.design.pojo.sys.SysUser;
import com.zyse.design.service.sys.SysUserService;
import com.zyse.design.untils.CryptorgaphyUtil;
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
    public List<SysUser> selectByLogin(SysUser sysUser) {
        sysUser.setUserPasword(CryptorgaphyUtil.encBase64(sysUser.getUserPasword()));
        List<SysUser> selectByLogin=  sysUserMapper.selectByLogin(sysUser);
        return selectByLogin;
    }

    @Override
    public int insertSysUser(SysUser sysUser) {
        sysUser.setUserKey(UUIDKeyUtil.uuIdKey());
        sysUser.setUserPasword(CryptorgaphyUtil.encBase64(sysUser.getUserPasword()));
        return sysUserMapper.insertSysUser(sysUser);
    }
}