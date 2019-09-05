package com.msn.springbootdemo.service;

import com.msn.springbootdemo.dao.PermissionMapper;
import com.msn.springbootdemo.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper dao;
    @Override
    public boolean addPermission(Permission permission) {
        return dao.addPermission(permission);
    }

    @Override
    public boolean delPermission(Integer id) {
        return dao.delPermission(id);
    }

    @Override
    public boolean updPermission(Permission permission) {
        return dao.updPermission(permission);
    }

    @Override
    public Permission getPermission(Integer id) {
        return dao.getPermission(id);
    }
}
