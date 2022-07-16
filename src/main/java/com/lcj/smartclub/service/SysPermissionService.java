package com.lcj.smartclub.service;

import com.lcj.smartclub.pojo.SysPermission;

import java.util.List;

public interface SysPermissionService {

    /**
     * 查找出所有权限
     */
    List<SysPermission> findAll();

    /**
     * 添加权限
     */
    int insert(SysPermission sysPermission);

    /**
     * 根据PermissionId删除权限
     */
    int deleteById(int permissionId);
}
