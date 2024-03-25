package com.example.sb002mybatis.mapper;

import com.example.sb002mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where id= #{id}")
    public User findById(Integer id);

    @Select("select * from user")
    public List<User> queryAll();

    @Insert("insert into user (name,age,gender,phone) " +
            "values ('张超',22,1,123456789)")
    public int insert(User user);
    //返回的int类型的值是改变的行数，因为插入了一行，所以如果运行成功，会返回1

    @Delete("delete from user where id=#{id}")
    public int delete(Integer id);

    @Update("update user set name='武林盟主' where name = '张超'")
    public int update(User user);
}