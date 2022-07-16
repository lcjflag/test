package com.lcj.smartclub.pojo;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {
    private int permissionId;
    private String permissionName;
    private String url;

    private List<SysRole> sysRoles;
}