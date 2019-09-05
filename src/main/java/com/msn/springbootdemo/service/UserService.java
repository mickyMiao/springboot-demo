package com.msn.springbootdemo.service;

import com.msn.springbootdemo.domain.Role;
import com.msn.springbootdemo.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean addUser (User user);
    boolean delUser(Integer id);
    boolean updUser(User user);
    User getUser(Integer id);
    List<Role> getRoleByUserName(String username);
    User selectByName(String  name);
    Map<String,Object> getAllQXByUserName(String username);
}
