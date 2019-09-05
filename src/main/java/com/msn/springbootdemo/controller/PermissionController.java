package com.msn.springbootdemo.controller;

import com.msn.springbootdemo.domain.Permission;
import com.msn.springbootdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/addPermission/{permission}/{role_id}")
    public Object addPermission(@PathVariable String permission,@PathVariable Integer role_id){
        Permission r=new Permission();
        r.setPermission(permission);
        r.setRole_id(role_id);
        boolean flag=permissionService.addPermission(r);
        return flag;
    }

    @RequestMapping("/delPermission/{id}")
    public Object delPermission(@PathVariable Integer id){
        boolean flag=permissionService.delPermission(id);
        return  flag;
    }

    @RequestMapping("/updPermission/{id}/{permission}/{role_id}")
    public  Object updPermission(@PathVariable Integer id,@PathVariable String permission,@PathVariable Integer role_id){
        Permission u=new Permission();
        u.setId(id);
        u.setRole_id(role_id);
        u.setPermission(permission);
        boolean flag=permissionService.updPermission(u);
        return flag;
    }
    @RequestMapping("/getPermission/{id}")
    public  Object getPermission(@PathVariable Integer id){
        Permission flag=permissionService.getPermission(id);
        return flag.getPermission();
    }

}
