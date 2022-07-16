package com.lcj.smartclub.service.impl;

import com.lcj.smartclub.mapper.SysUserMapper;
import com.lcj.smartclub.pojo.SysRole;
import com.lcj.smartclub.pojo.SysUser;
import com.lcj.smartclub.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    /**
     * 查找全部
     */
    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    /**
     * 通过用户名username查找用户
     *
     * @param username
     */
    @Override
    public SysUser findUserByUsername(String username) {
        return sysUserMapper.findUserByUsername(username);
    }

    /**
     * 通过电话号码查找用户
     *
     * @param phoneNum
     */
    @Override
    public SysUser findUserByPhoneNum(String phoneNum) {
        return sysUserMapper.findUserByPhoneNum(phoneNum);
    }

    /**
     * 查找出用户所拥有的角色
     *
     * @param userId
     */
    @Override
    public List<SysRole> findRoleByUserId(int userId) {
        return sysUserMapper.findRoleByUserId(userId);
    }

    /**
     * 查找出用户所不拥有的角色
     *
     * @param userId
     */
    @Override
    public List<SysRole> findOtherRoleByUserId(int userId) {
        return sysUserMapper.findOtherRoleByUserId(userId);
    }

    /**
     * 增加用户
     *
     * @param sysUser
     */
    @Override
    public int insert(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    /**
     * 删除用户
     *
     * @param userId
     */
    @Override
    public int deleteById(int userId) {
        return sysUserMapper.deleteById(userId);
    }

    /**
     * 给用户添加角色
     *
     * @param userId
     * @param roleId
     */
    @Override
    public int addRoleToUser(int userId, int roleId) {
        return sysUserMapper.addRoleToUser(userId, roleId);
    }

    /**
     * 删除用户的角色
     *
     * @param userId
     * @param roleId
     */
    @Override
    public int deleteRoleFromUser(int userId, int roleId) {
        return sysUserMapper.deleteRoleFromUser(userId, roleId);
    }

    @Override
    public int update(SysUser sysUser) {
        return sysUserMapper.update(sysUser);
    }
}