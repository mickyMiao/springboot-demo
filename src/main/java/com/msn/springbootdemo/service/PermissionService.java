package com.msn.springbootdemo.service;

import com.msn.springbootdemo.domain.Permission;
import com.msn.springbootdemo.domain.Role;

public interface PermissionService {
    boolean addPermission(Permission permission);
    boolean delPermission(Integer id);
    boolean updPermission(Permission permission);
    Permission getPermission(Integer id);
}
