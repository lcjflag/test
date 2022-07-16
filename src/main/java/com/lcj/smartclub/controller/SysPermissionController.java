package com.lcj.smartclub.controller;

import com.lcj.smartclub.pojo.SysPermission;
import com.lcj.smartclub.pojo.SysUser;
import com.lcj.smartclub.result.Result;
import com.lcj.smartclub.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 查询所有权限信息
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(){
        List<SysPermission> lists = sysPermissionService.findAll();

        return Result.success(lists);
    }


    /**
     * 插入一条权限信息
     * @param sysPermission
     * @return
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SysPermission sysPermission){
        int count = sysPermissionService.insert(sysPermission);
        if(count==0){
            return Result.fail();
        }
        return Result.success(count);
    }


    /**
     * 根据permissionId删除权限
     * @param permissionId
     * @return
     */
    @RequestMapping("/deleteById")
    public Result deleteById(int permissionId){
        int count = sysPermissionService.deleteById(permissionId);
        return Result.success(count);
    }
}