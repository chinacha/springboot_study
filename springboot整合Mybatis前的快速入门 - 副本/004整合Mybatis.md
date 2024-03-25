SpringBoot 整合 Mybatis 只需要两步：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710920018829-34565c62-5681-4c7a-8e12-435a8bb99414.png#averageHue=%23dee1e5&clientId=ucc40c13f-da1d-4&from=paste&height=374&id=ub33aad7d&originHeight=468&originWidth=590&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=170346&status=done&style=none&taskId=u7e8f71a7-8838-4609-b070-78b155de2bf&title=&width=472)
# 案例：
## 创建数据库
在 IDEA 提供的插件的内置的数据库图形化界面(其他图形化界面软件也可以，都一样） 中创建以下数据库：
```sql
create database if not exists mybatis;

use mybatis;

create table user(
    id int unsigned primary key auto_increment comment 'ID',
    name varchar(100) comment '姓名',
    age tinyint unsigned comment '年龄',
    gender tinyint unsigned comment '性别, 1:男, 2:女',
    phone varchar(11) comment '手机号'
) comment '用户表';

insert into user(id, name, age, gender, phone) VALUES (null,'白眉鹰王',55,'1','18800000000');
insert into user(id, name, age, gender, phone) VALUES (null,'金毛狮王',45,'1','18800000001');
insert into user(id, name, age, gender, phone) VALUES (null,'青翼蝠王',38,'1','18800000002');
insert into user(id, name, age, gender, phone) VALUES (null,'紫衫龙王',42,'2','18800000003');
insert into user(id, name, age, gender, phone) VALUES (null,'光明左使',37,'1','18800000004');
insert into user(id, name, age, gender, phone) VALUES (null,'光明右使',48,'1','18800000005');
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710920323720-baf79e9f-717d-4d6d-942f-58f49c17a1eb.png#averageHue=%232f343b&clientId=ucc40c13f-da1d-4&from=paste&height=200&id=u98c9c3be&originHeight=250&originWidth=695&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=42761&status=done&style=none&taskId=u19155304-0638-4ba8-9783-a9512716865&title=&width=556)
复制后，执行 SQL 代码
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710920486632-55c0cd84-f172-4049-af28-43470f5dfb5a.png#averageHue=%23263044&clientId=ucc40c13f-da1d-4&from=paste&height=718&id=u1a2ba9c6&originHeight=898&originWidth=1674&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=225024&status=done&style=none&taskId=uae466858-3772-4037-a05f-780196d2955&title=&width=1339.2)
创建好了 user 表：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710920597299-ddf8c761-d6d1-40d2-8a24-d7021d03525c.png#averageHue=%2326282d&clientId=ucc40c13f-da1d-4&from=paste&height=450&id=u10b6424e&originHeight=562&originWidth=1325&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=92454&status=done&style=none&taskId=u006ee724-4099-4bf2-8e7b-29725fe12ad&title=&width=1060)
## 创建 SpringBoot 工程
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710925381354-636bf9ea-04d0-40b8-a84e-ec1658114662.png#averageHue=%232d3034&clientId=ufe35939a-c139-4&from=paste&height=698&id=u22989c1d&originHeight=873&originWidth=982&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=111913&status=done&style=none&taskId=ub2f410c8-3bc9-44ba-a5af-5aac498699e&title=&width=785.6)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710925409858-64367cd6-fbda-4237-8f36-d5ec72f37281.png#averageHue=%232c2f32&clientId=ufe35939a-c139-4&from=paste&height=698&id=udb4a009f&originHeight=873&originWidth=982&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=84694&status=done&style=none&taskId=u77634400-7df4-415d-a66f-0e1369dcbc3&title=&width=785.6)
## yml 配置
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710925599728-1ac416fc-fa44-4071-9859-d8f3a4d88e57.png#averageHue=%2327282c&clientId=ufe35939a-c139-4&from=paste&height=390&id=u3cc4a56a&originHeight=488&originWidth=1637&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=98370&status=done&style=none&taskId=ud0b462a4-7771-49c9-b6b7-dd67afe3375&title=&width=1309.6)
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mybatis
    username: root
    password: 123456
```
## 创建 pojo 实体类
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710925693270-13577a59-ae39-429d-a29f-d00789575497.png#averageHue=%232d3137&clientId=ufe35939a-c139-4&from=paste&height=339&id=u93da4bb7&originHeight=424&originWidth=367&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=28937&status=done&style=none&taskId=uf7239a81-2f9a-4ada-aba7-57e3a8915e1&title=&width=293.6)
```java
package com.itheima.mybatis.pojo;

public class User {
    
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;

    public User() {
    }

    public User(Integer id, String name, Short age, Short gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
    }
}
```
## 创建 mapper 接口
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710925809547-00b7c12d-743b-47c2-8b22-2c5b8b135370.png#averageHue=%2326282b&clientId=ufe35939a-c139-4&from=paste&height=398&id=u3735a7ae&originHeight=497&originWidth=961&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=57915&status=done&style=none&taskId=ub1258929-49b2-4616-ae4a-0742dce2388&title=&width=768.8)
编写 UserMapper.java 代码
```java
package com.itheima.mybatis.mapper;
import com.itheima.mybatis.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where id= #{id}")
    public User findById(Integer id);
}
```
## 创建 service 接口
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710926141832-aadf6c25-c3e8-4219-8096-9d1e91ab6c2c.png#averageHue=%2325272b&clientId=ufe35939a-c139-4&from=paste&height=427&id=udefd9642&originHeight=534&originWidth=1014&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=63397&status=done&style=none&taskId=ub70bbf22-eee6-4801-98d7-c3f74ce1e03&title=&width=811.2)
```java
package com.itheima.mybatis.service;

import com.itheima.mybatis.pojo.User;

public interface UserService {
    public User findById(Integer id);
}
```
创建接口的实现类
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710926262670-f68c4960-31bc-42c4-a149-8daa45802ebe.png#averageHue=%23242629&clientId=ufe35939a-c139-4&from=paste&height=460&id=u9da12ce9&originHeight=575&originWidth=1338&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=73869&status=done&style=none&taskId=uc16fc31f-0212-44f4-b1b0-000e101bd88&title=&width=1070.4)
```java
package com.itheima.mybatis.service.impl;

import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;
import com.itheima.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
```
## 创建 controller 类
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710926535607-7affe48c-6c51-466a-a75c-cfecb52f9141.png#averageHue=%2325272b&clientId=ufe35939a-c139-4&from=paste&height=342&id=ub1114feb&originHeight=427&originWidth=1171&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=57055&status=done&style=none&taskId=ueac03648-df4f-40ff-bcb7-49ccf197c66&title=&width=936.8)
```java
package com.itheima.mybatis.controller;

import com.itheima.mybatis.pojo.User;
import com.itheima.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/findById")
    public User findById(Integer id) {
        return userService.findById(id);
    }
}
```
# 启动与测试
## 启动 springboot 工程
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710926789005-2a4317bb-3928-4f3f-bd9a-d414c247fa42.png#averageHue=%2324272b&clientId=ufe35939a-c139-4&from=paste&height=738&id=ua9f8a354&originHeight=922&originWidth=1894&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=288268&status=done&style=none&taskId=u78f89dd4-5f1a-44b9-975e-bd2440e5413&title=&width=1515.2)
## 测试
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710928326619-f9c0f73f-6a98-41cf-8735-0db82586f05a.png#averageHue=%23cec8c3&clientId=ufe35939a-c139-4&from=paste&height=254&id=ubcc8f594&originHeight=317&originWidth=763&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=33355&status=done&style=none&taskId=ue06a36bc-da6a-49a4-ac98-7ddfa6676d5&title=&width=610.4)
