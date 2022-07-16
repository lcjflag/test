package com.lcj.smartclub.pojo;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    private int roleId;
    private String roleName;
    private String Desc;

    private List<SysUser> sysUsers;
    private List<SysPermission> sysPermissions;
}
