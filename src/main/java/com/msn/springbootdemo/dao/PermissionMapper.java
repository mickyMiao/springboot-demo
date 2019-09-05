package com.msn.springbootdemo.dao;

import com.msn.springbootdemo.domain.Permission;
import com.msn.springbootdemo.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper {
    boolean addPermission(Permission permission);
    boolean delPermission(Integer id);
    boolean updPermission(Permission permission);
    Permission getPermission(Integer id);
}
