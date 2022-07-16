package com.lcj.smartclub.service.impl;

import com.lcj.smartclub.mapper.SysPermissionMapper;
import com.lcj.smartclub.pojo.SysPermission;
import com.lcj.smartclub.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 查找出所有权限
     */
    @Override
    public List<SysPermission> findAll() {
        return sysPermissionMapper.findAll();
    }

    /**
     * 添加权限
     *
     * @param sysPermission
     */
    @Override
    public int insert(SysPermission sysPermission) {
        return sysPermissionMapper.insert(sysPermission);
    }

    /**
     * 根据PermissionId删除权限
     *
     * @param permissionId
     */
    @Override
    public int deleteById(int permissionId) {
        return sysPermissionMapper.deleteById(permissionId);
    }
}
