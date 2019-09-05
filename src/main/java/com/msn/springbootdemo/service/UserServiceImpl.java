package com.msn.springbootdemo.service;

import com.msn.springbootdemo.dao.PermissionMapper;
import com.msn.springbootdemo.dao.RoleMapper;
import com.msn.springbootdemo.dao.UserMapper;
import com.msn.springbootdemo.domain.Role;
import com.msn.springbootdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class UserServiceImpl implements UserService {
  @Autowired
    private UserMapper dao;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public boolean addUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public boolean delUser(Integer id) {
        return dao.delUser(id);
    }

    @Override
    public boolean updUser(User user) {
        return dao.updUser(user);
    }

    @Override
    public User getUser(Integer id) {
        return dao.getUser(id);
    }

    @Override
    public List<Role> getRoleByUserName(String username) {
        return dao.getRoleByUserName(username);
    }

    @Override
    public User selectByName(String name) {
        return dao.selectByName(name);
    }

    @Override
    public Map<String, Object> getAllQXByUserName(String username) {
        List<Role> roles = dao.getRoleByUserName(username);
        Map<String, Object> role_map = new HashMap<>();
        for (Role r : roles) {
            role_map.put(r.getRole_name(),roleMapper.getPermissionByRoleId(r.getId()));
        }
        return role_map;
    }
}
