package com.msn.springbootdemo.service;

import com.msn.springbootdemo.domain.Permission;
import com.msn.springbootdemo.domain.Role;
import com.msn.springbootdemo.domain.User;

import java.util.List;

public interface RoleService {
    boolean addRole (Role role);
    boolean delRole(Integer id);
    boolean updRole(Role role);
    Role getRole(Integer id);
    List<Permission> getPermissionByRoleId(int role_id);
}
