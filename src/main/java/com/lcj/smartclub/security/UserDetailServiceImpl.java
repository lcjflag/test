package com.lcj.smartclub.security;

import com.lcj.smartclub.pojo.SysPermission;
import com.lcj.smartclub.pojo.SysRole;
import com.lcj.smartclub.pojo.SysUser;
import com.lcj.smartclub.service.SysPermissionService;
import com.lcj.smartclub.service.SysRoleService;
import com.lcj.smartclub.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.findUserByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名或密码不正确");
        }
        User user = new User(
                sysUser.getUsername(),
                sysUser.getPassword(),
                sysUser.getStatus() == 0 ? true : false,
                true,
                true,
                true,
                getAuthority(sysUser.getUserId())
        );
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(Integer userId){
        List<SimpleGrantedAuthority> list = new ArrayList<>();

        //添加role角色和permission权限
        List<SysRole> sysRoles = sysUserService.findRoleByUserId(userId);
        if(sysRoles.size()>0) {
            for (SysRole sysRole : sysRoles) {
                list.add(new SimpleGrantedAuthority("ROLE_" + sysRole.getRoleName()));
                List<SysPermission> sysPermissions = sysRoleService.findPermissionByRoleId(sysRole.getRoleId());
                if(sysPermissions.size()>0){
                    for(SysPermission sysPermission : sysPermissions){
                        list.add(new SimpleGrantedAuthority(sysPermission.getUrl()));
                    }
                }
            }
        }
        return list;
    }
}
