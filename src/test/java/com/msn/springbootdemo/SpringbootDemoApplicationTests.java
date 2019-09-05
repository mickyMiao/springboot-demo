package com.msn.springbootdemo;

import com.msn.springbootdemo.domain.Permission;
import com.msn.springbootdemo.domain.User;
import com.msn.springbootdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {
@Autowired
private UserService userService;
//    @Test
    public void contextLoads() {
        User user=userService.selectByName("hello");
       System.out.print(user.getPassword());
    }
    @Test
    public void getAllQXByUserName(){
        Map<String,Object> all=userService.getAllQXByUserName("hello");
        for (String key:all.keySet()){
            String row="role_name"+key;
            List<Permission> obj=(List) all.get(key);
            row+=",permission:";
            for (Permission p:obj){
                row+=p.getPermission()+",";
            }
           // System.out.print(row);
        }
    }

}
