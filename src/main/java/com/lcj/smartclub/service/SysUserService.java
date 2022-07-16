package com.lcj.smartclub.service;

import com.lcj.smartclub.pojo.SysRole;
import com.lcj.smartclub.pojo.SysUser;

import java.util.List;

public interface SysUserService {
    /**
     * 查找全部
     */
    List<SysUser> findAll();

    /**
     * 通过用户名username查找用户
     */
    SysUser findUserByUsername(String username);

    /**
     * 通过电话号码查找用户
     */
    SysUser findUserByPhoneNum(String phoneNum);

    /**
     * 查找出用户所拥有的角色
     */
    List<SysRole> findRoleByUserId(int userId);

    /**
     * 查找出用户所不拥有的角色
     */
    List<SysRole> findOtherRoleByUserId(int userId);

    /**
     * 增加用户
     */
    int insert(SysUser sysUser);

    /**
     * 删除用户
     */
    int deleteById(int userId);

    /**
     * 给用户添加角色
     */
    int addRoleToUser(int userId,int roleId);

    /**
     * 删除用户的角色
     */
    int deleteRoleFromUser(int userId,int roleId);

    int update(SysUser sysUser);
}
