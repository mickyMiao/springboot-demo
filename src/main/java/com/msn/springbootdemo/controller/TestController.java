package com.msn.springbootdemo.controller;

import com.msn.springbootdemo.config.jedis.JedisConfig;
import com.msn.springbootdemo.config.jedis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

public class TestController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public Object test(){
        return "hello world!";
    }
    //restful风格
    @RequestMapping(value = "/test2/{name}",method = RequestMethod.GET)
    @ResponseBody
    public Object test2(@PathVariable String name){
        String result="name:"+name;
        return result;
}

@Autowired
private JedisUtil jedis;
@RequestMapping("/restJedis/{val}")
    public Object restJedis(@PathVariable String val){
        jedis.set("key"+val,val);
        return "testValue";
}
@Autowired
    private JdbcTemplate jdbcTemplate;
@RequestMapping("/getJDBC/{id}")
    public Object getJDBC(@PathVariable Integer id){
    String sql="select * from exercise where id="+id;
    Map<String,Object> data=jdbcTemplate.queryForMap(sql);
    return data;
}
}
