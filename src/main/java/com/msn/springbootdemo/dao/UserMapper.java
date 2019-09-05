package com.msn.springbootdemo.dao;

import com.msn.springbootdemo.domain.Role;
import com.msn.springbootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    boolean addUser (User user);
    boolean delUser(Integer id);
    boolean updUser(User user);
    User getUser(Integer id);
    List<Role> getRoleByUserName(String username);
    User selectByName(String  name);

}
