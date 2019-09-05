package com.msn.springbootdemo.service;

import com.msn.springbootdemo.dao.RoleMapper;
import com.msn.springbootdemo.dao.UserMapper;
import com.msn.springbootdemo.domain.Permission;
import com.msn.springbootdemo.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper dao;

    @Override
    public boolean addRole(Role role) {
        return dao.addRole(role);
    }

    @Override
    public boolean delRole(Integer id) {
        return dao.delRole(id);
    }

    @Override
    public boolean updRole(Role role) {
        return dao.updRole(role);
    }

    @Override
    public Role getRole(Integer id) {
        return dao.getRole(id);
    }

    @Override
    public List<Permission> getPermissionByRoleId(int role_id) {
        return dao.getPermissionByRoleId(role_id);
    }
}
