package com.zyse.design.service.sys;

import com.zyse.design.pojo.sys.SysUser;

import java.util.List;

public interface SysUserService {

    /**查询登陆人员账号和密码是不是正确
     * @description:功能描述
     * @param:
     * @return:
     * @Author: yc
     * @date: 2019/3/27 13:01
     */

    List<SysUser> selectByUser(SysUser sysUser);
    /**查询登陆人员账号是不是正确
     * @description:功能描述
     * @param:
     * @return:
     * @Author: yc
     * @date: 2019/3/27 13:01
     */
    SysUser selectByLogin(String name);

    /**
     * 用户新的插入
     * @description:功能描述
     * @param:
     * @return:
     * @Author: yc
     * @date: 2019/3/27 13:10
     */
    int insertSysUser(SysUser sysUser);

}