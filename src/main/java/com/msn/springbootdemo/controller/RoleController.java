package com.msn.springbootdemo.controller;

import com.msn.springbootdemo.domain.Permission;
import com.msn.springbootdemo.domain.Role;
import com.msn.springbootdemo.domain.User;
import com.msn.springbootdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/addRole/{user_id}/{role_name}")
    public Object addRole(@PathVariable Integer id,@PathVariable String role_name){
        Role r=new Role();
        r.setUser_id(id);
        r.setRole_name(role_name);
        boolean flag=roleService.addRole(r);
        return flag;
    }

    @RequestMapping("/delRole/{id}")
    public Object delRole(@PathVariable Integer id){
        boolean flag=roleService.delRole(id);
        return  flag;
    }

    @RequestMapping("/updRole/{id}/{role_name}/{user_id}")
    public  Object updRole(@PathVariable Integer id,@PathVariable String role_name,@PathVariable Integer user_id){
        Role u=new Role();
        u.setId(id);
        u.setRole_name(role_name);
        u.setUser_id(user_id);
        boolean flag=roleService.updRole(u);
        return flag;
    }
    @RequestMapping("/getRole/{id}")
    public  Object getRole(@PathVariable Integer id){
        Role flag=roleService.getRole(id);
        return flag.getRole_name();
    }

    @RequestMapping("/getPermissionByRoleId/{role_id}")
    public  Object getPermissionByRoleId(@PathVariable Integer role_id){
        List<Permission> flag=roleService.getPermissionByRoleId(role_id);
        return flag.size();
    }

}
