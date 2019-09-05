package com.msn.springbootdemo.controller;

import com.msn.springbootdemo.domain.User;
import com.msn.springbootdemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShiroController {
    @Autowired
    private UserService userService;

    @RequestMapping("/loginShiro/{username}/{password}")
    public Object loginShiro(@PathVariable String username,@PathVariable String password){
        if(username!=null){
            User user=userService.selectByName(username);
            if(user!=null && user.getPassword().equals(password)){
                //添加用户认证信息
                Subject subject=SecurityUtils.getSubject();
                UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
                //进行验证。这里可以捕捉异常，然后返回对应信息
                subject.login(usernamePasswordToken);
                System.out.println("loginShiro:"+usernamePasswordToken);
                return "loginShiro";
            }
        }
        //调用logout后通过setLoginUrl重新进入该方法
        return "It is logout!";
    }
    @RequestMapping("/logout")
    public Object logout(){
        return "logout!";
    }

    @RequestMapping("/index")
    public Object index(){
        return "It is index";
    }
    @RequestMapping("/errorpage")
    public  Object errorpage(){
        return "It is errorpage";
    }
    @RequestMapping("/testShiro")
    public  Object testShiro(){
        //业务省略。。
        return "testShiro:sucess!";
    }
    //认证角色
    @RequestMapping("/testAuthority")
    @RequiresRoles(value="user")
    public  Object  testAuthority(){
        return "testAuthority:sucess";
    }
    //认证权限
    @RequestMapping("/testPermission")
    @RequiresPermissions(value={"create","select"},logical = Logical.OR)
    public  Object  testPermission(){
        return "testPermission:sucess";
    }
    //角色 和 操作权限并存的接口
    @RequestMapping("/testAuthorityPermission")
    @RequiresRoles(value="user")
    @RequiresPermissions(value={"create","select"},logical = Logical.OR)
    public Object testAuthorityPermission(){
        return "testAuthorityPermission:success";
    }

}
