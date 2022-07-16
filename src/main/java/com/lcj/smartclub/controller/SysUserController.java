package com.lcj.smartclub.controller;

import com.lcj.smartclub.pojo.SysPermission;
import com.lcj.smartclub.pojo.SysRole;
import com.lcj.smartclub.pojo.SysUser;
import com.lcj.smartclub.result.Result;
import com.lcj.smartclub.service.SysUserService;
import com.lcj.smartclub.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 查询所有用户信息
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(){
        List<SysUser> lists = sysUserService.findAll();

        return Result.success(lists);
    }

    /**
     * 插入一条用户信息
     * @param sysUser
     * @return
     */
    @RequestMapping("/insert")
    @PreAuthorize("hasRole('admin')")
    public Result insert1(@RequestBody SysUser sysUser){
        String password = sysUser.getPassword().trim();
        sysUser.setPassword(bCryptPasswordEncoder.encode(password));
        sysUser.setSalt("0");
        int count = sysUserService.insert(sysUser);
        if(count==0){
            return Result.fail();
        }
        return Result.success(count);
    }
    /**
     * 根据userId删除用户
     * @param userId
     * @return
     */
    @RequestMapping("/deleteById")
    public Result deleteById(int userId){
        int count = sysUserService.deleteById(userId);
        return Result.success(count);
    }

    /**
     * 根据permissionId和roleId,给角色添加权限
     * @param userId
     * @param roleId
     * @return
     */
    @RequestMapping("/addRoleToUser")
    public Result addRoleToUser(int userId,int roleId){
        int count = sysUserService.addRoleToUser(userId, roleId);
        if(count==0){
            return Result.fail();
        }
        return Result.success(count);
    }

    /**
     * 根据userId查询用户角色信息
     * @return
     */
    @RequestMapping("/findRoleByUserId")
    public Result findRoleByUserId(int userId){
        List<SysRole> lists = sysUserService.findRoleByUserId(userId);
        if(lists.isEmpty()){
            return Result.fail();
        }
        return Result.success(lists);
    }

    /**
     * 查找出用户所不拥有的角色
     * @param userId
     * @return
     */
    @RequestMapping("/findOtherRoleByUserId")
    public Result findOtherRoleByUserId(int userId){
        List<SysRole> lists = sysUserService.findOtherRoleByUserId(userId);
        if(lists.isEmpty()){
            return Result.fail();
        }
        return Result.success(lists);
    }

    /**
     * 删除用户的角色
     *
     * @param userId
     * @param roleId
     */
    @RequestMapping("/deleteRoleFromUser")
    public Result deleteRoleFromUser(int userId, int roleId) {
        int count = sysUserService.deleteRoleFromUser(userId, roleId);
        if(count==0){
            return Result.fail();
        }
        return Result.success(count);
    }

    /**
     * 根据username查找user
     * @param request
     * @return
     */
    @RequestMapping("/findUserByUsername")
    public Result findUserByUsername(HttpServletRequest request){
        String jwt = request.getHeader(jwtUtils.getHeader());
        Claims claim = jwtUtils.getClaimByToken(jwt);
        String username = claim.getSubject();
        SysUser sysUser = sysUserService.findUserByUsername(username);
        sysUser.setPassword("");
        return Result.success(sysUser);
    }

    /**
     * 更改user
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public Result update(HttpServletRequest request){
        String rePassword = request.getParameter("rePassword").trim();
        String jwt = request.getHeader(jwtUtils.getHeader());
        Claims claim = jwtUtils.getClaimByToken(jwt);
        String username = claim.getSubject();
        SysUser sysUser = sysUserService.findUserByUsername(username);
        boolean flag = bCryptPasswordEncoder.matches(rePassword,sysUser.getPassword());
        if(flag){
            String name = request.getParameter("username").trim();
            String email = request.getParameter("email").trim();
            String phoneNum = request.getParameter("phoneNum").trim();
            String newPassword = request.getParameter("newPassword").trim();


            sysUser.setUsername(name);
            sysUser.setEmail(email);
            sysUser.setPhoneNum(phoneNum);
            if(!newPassword.isEmpty()){
                newPassword = bCryptPasswordEncoder.encode(newPassword);
                sysUser.setPassword(newPassword);
            }else {
                sysUser.setPassword(null);
            }
            int count = sysUserService.update(sysUser);
            if(count==0){
                return Result.fail();
            }
            return Result.success(count);
        }
        return Result.fail();
    }
}