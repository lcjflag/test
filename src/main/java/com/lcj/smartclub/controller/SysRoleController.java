package com.lcj.smartclub.controller;

import com.lcj.smartclub.pojo.SysPermission;
import com.lcj.smartclub.pojo.SysRole;
import com.lcj.smartclub.pojo.SysUser;
import com.lcj.smartclub.result.Result;
import com.lcj.smartclub.service.SysPermissionService;
import com.lcj.smartclub.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询所有角色信息
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(){
        List<SysRole> lists = sysRoleService.findAll();


        return Result.success(lists);
    }

    /**
     * 插入一条用户信息
     * @param sysRole
     * @return
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SysRole sysRole){
        int count = sysRoleService.insert(sysRole);
        if(count==0){
            return Result.fail();
        }
        return Result.success(count);
    }


    /**
     * 根据userId删除用户
     * @param roleId
     * @return
     */
    @RequestMapping("/deleteById")
    public Result deleteById(int roleId){
        int count = sysRoleService.deleteById(roleId);
        return Result.success(count);
    }

    /**
     * 根据permissionId和roleId,给角色添加权限
     * @param roleId
     * @param permissionId
     * @return
     */
    @RequestMapping("/addPermissionToRole")
    public Result addPermissionToRole(int roleId,int permissionId){
        int count = sysRoleService.addPermissionToRole(roleId,permissionId);
        if(count==0){
            return Result.fail();
        }
        return Result.success(count);
    }


    /**
     * 根据roleId查询角色权限信息
     * @return
     */
    @RequestMapping("/findPermissionByRoleId")
    public Result findPermissionByRoleId(int roleId){
        List<SysPermission> lists = sysRoleService.findPermissionByRoleId(roleId);
        if(lists.isEmpty()){
            return Result.fail();
        }
        return Result.success(lists);
    }

    /**
     * 查找出角色所不拥有的权限
     * @param roleId
     * @return
     */
    @RequestMapping("/findOtherPermissionByRoleId")
    public Result findOtherPermissionByRoleId(int roleId){
        List<SysPermission> lists = sysRoleService.findOtherPermissionByRoleId(roleId);
        if(lists.isEmpty()){
            return Result.fail();
        }
        return Result.success(lists);
    }

    /**
     * 删除角色的权限
     *
     * @param roleId
     * @param permissionId
     */
    @RequestMapping("/deletePermissionFromRole")
    public Result deletePermissionFromRole(int roleId, int permissionId) {
        int count = sysRoleService.deletePermissionFromRole(roleId, permissionId);
        if(count==0){
            return Result.fail();
        }
        return Result.success(count);
    }
}
