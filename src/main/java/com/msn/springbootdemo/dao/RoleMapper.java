package com.msn.springbootdemo.dao;

import com.msn.springbootdemo.domain.Permission;
import com.msn.springbootdemo.domain.Role;
import com.msn.springbootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    boolean addRole (Role role);
    boolean delRole(Integer id);
    boolean updRole(Role role);
    Role getRole(Integer id);
    List<Permission> getPermissionByRoleId(int role_id);
}
