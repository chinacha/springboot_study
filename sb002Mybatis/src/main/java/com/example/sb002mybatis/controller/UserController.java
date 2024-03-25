package com.example.sb002mybatis.controller;


import com.example.sb002mybatis.pojo.User;
import com.example.sb002mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public User findById(Integer id) {
        return userService.findById(id);
    }

    @RequestMapping("/queryAll")
    public List<User> queryAll() {
        return userService.queryAll();
    }

    @RequestMapping("/insert")
    public int insert(User user) {
        return userService.insert(user);
    }

    @RequestMapping("/delete")
    public int delete(Integer id){
        return userService.delete(id);
    }

    @RequestMapping("/update")
    public int update(User user){
        return userService.update(user);
    }
}