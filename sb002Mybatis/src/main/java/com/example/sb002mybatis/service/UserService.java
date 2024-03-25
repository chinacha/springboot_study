package com.example.sb002mybatis.service;


import com.example.sb002mybatis.pojo.User;

import java.util.List;

public interface UserService {
    public User findById(Integer id);
    public List<User> queryAll();

    public int insert(User user);

    public int delete(Integer id);

    public int update(User user);
}