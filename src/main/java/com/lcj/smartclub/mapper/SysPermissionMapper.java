package com.lcj.smartclub.mapper;

import com.lcj.smartclub.pojo.SysPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPermissionMapper {

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
