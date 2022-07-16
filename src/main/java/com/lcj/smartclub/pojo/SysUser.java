package com.lcj.smartclub.pojo;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private int userId;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String phoneNum;
    private int status;

    //用户所拥有的角色
    private List<SysRole> sysRoles;
}