package com.lcj.smartclub.service.impl;

import com.lcj.smartclub.mapper.SysRoleMapper;
import com.lcj.smartclub.pojo.SysPermission;
import com.lcj.smartclub.pojo.SysRole;
import com.lcj.smartclub.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查找出角色所拥有的权限
     *
     * @param roleId
     */
    @Override
    public List<SysPermission> findPermissionByRoleId(int roleId) {
        return sysRoleMapper.findPermissionByRoleId(roleId);
    }

    /**
     * 查找出角色所不拥有的权限
     *
     * @param roleId
     */
    @Override
    public List<SysPermission> findOtherPermissionByRoleId(int roleId) {
        return sysRoleMapper.findOtherPermissionByRoleId(roleId);
    }

    /**
     * 查询所有角色
     */
    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.findAll();
    }

    /**
     * 添加角色
     *
     * @param sysRole
     */
    @Override
    public int insert(SysRole sysRole) {
        return sysRoleMapper.insert(sysRole);
    }

    /**
     * 根据角色roleId删除角色
     *
     * @param roleId
     */
    @Override
    public int deleteById(int roleId) {
        return sysRoleMapper.deleteById(roleId);
    }

    /**
     * 根据permissionId和roleId,给角色添加权限
     *
     * @param roleId
     * @param permissionId
     */
    @Override
    public int addPermissionToRole(int roleId, int permissionId) {
        return sysRoleMapper.addPermissionToRole(roleId, permissionId);
    }

    /**
     * 删除角色的权限
     *
     * @param roleId
     * @param permissionId
     */
    @Override
    public int deletePermissionFromRole(int roleId, int permissionId) {
        return sysRoleMapper.deletePermissionFromRole(roleId, permissionId);
    }
}
