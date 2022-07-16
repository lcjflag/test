package com.lcj.smartclub.mapper;

import com.lcj.smartclub.pojo.SysPermission;
import com.lcj.smartclub.pojo.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMapper {

    /**
     * 查找出角色所拥有的权限
     */
    List<SysPermission> findPermissionByRoleId(int roleId);

    /**
     * 查找出角色所不拥有的权限
     */
    List<SysPermission> findOtherPermissionByRoleId(int roleId);

    /**
     * 查询所有角色
     */
    List<SysRole> findAll();

    /**
     * 添加角色
     */
    int insert(SysRole sysRole);

    /**
     * 根据角色roleId删除角色
     */
    int deleteById(int roleId);

    /**
     * 根据permissionId和roleId,给角色添加权限
     */
    int addPermissionToRole(int roleId,int permissionId);

    /**
     * 删除角色的权限
     */
    int deletePermissionFromRole(int roleId,int permissionId);
}
