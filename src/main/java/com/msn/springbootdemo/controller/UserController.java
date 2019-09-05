package com.msn.springbootdemo.controller;

import com.msn.springbootdemo.domain.Role;
import com.msn.springbootdemo.domain.User;
import com.msn.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/addUser/{name}/{password}/{sal}")
    public  Object addUser(@PathVariable String name,@PathVariable String password,@PathVariable double sal){
        User u=new User();
        u.setName(name);
        u.setPassword(password);
        u.setSal(sal);
        boolean flag=userService.addUser(u);
        return flag;
    }

    @RequestMapping("/delUser/{id}")
    public  Object delUser(@PathVariable Integer id){
        boolean flag=userService.delUser(id);
        return flag;
    }

    @RequestMapping("/updUser/{id}/{sal}/{password}/{name}")
    public  Object updUser(@PathVariable Integer id,@PathVariable double sal,@PathVariable String password,@PathVariable String name){
        User u=new User();
        u.setId(id);
        u.setSal(sal);
        u.setPassword(password);
        u.setName(name);
        boolean flag=userService.updUser(u);
        return flag;
    }
    @RequestMapping("/getUser/{id}")
    public  Object getUser(@PathVariable Integer id){
        User flag=userService.getUser(id);
        return flag.getName();
    }

    @RequestMapping("/selectByName/{name}")
    public  Object selectByName(@PathVariable String name){
        User flag=userService.selectByName(name);
        return flag.getPassword();
    }
    @RequestMapping("/getRoleByUserName/{username}")
    public  Object getRoleByUserName(@PathVariable String username){
        List<Role> flag=userService.getRoleByUserName(username);
        return flag.size();
    }

}
