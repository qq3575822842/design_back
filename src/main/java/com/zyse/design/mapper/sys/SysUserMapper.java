package com.zyse.design.mapper.sys;

import com.zyse.design.pojo.sys.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {

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
    List<SysUser> selectByLogin(SysUser sysUser);

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