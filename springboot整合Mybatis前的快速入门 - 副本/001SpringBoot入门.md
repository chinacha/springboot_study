要求：使用 Springboot 开发一个 web 程序，浏览器发起请求`/hello`后，给浏览器返回字符串 `hello springboot`
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710843206699-3f0fc5ca-f118-4a7f-9abf-1cbbfb879061.png#averageHue=%23fefcfa&clientId=ud2f8213d-b719-4&from=paste&height=159&id=u4b5c056a&originHeight=199&originWidth=1223&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=67639&status=done&style=none&taskId=u05054308-2f39-4eb6-ad69-a43090832a0&title=&width=978.4)
使用 springboot 只需要引入一个起步依赖
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
这个就包含了使用 SSM 完成此需求时所需要的所有依赖
然后再编写一个 controller 就可以了：
```java
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world~";
    }
}
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710843690677-864d19a2-ffad-4300-837c-20ed61a93d25.png#averageHue=%23fcfaf9&clientId=ud2f8213d-b719-4&from=paste&height=438&id=uac9c0064&originHeight=548&originWidth=1005&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=104764&status=done&style=none&taskId=u548a010e-e873-489b-bdf6-e990bc9f48b&title=&width=804)
# 创建项目模块
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710848144481-5829ab64-6956-403b-aada-39416a7463bc.png#averageHue=%232e3339&clientId=ud2f8213d-b719-4&from=paste&height=362&id=u9dad7a63&originHeight=453&originWidth=607&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=54225&status=done&style=none&taskId=u3d96af76-a771-4285-93fe-9c1cf1e20d2&title=&width=485.6)![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710848164320-a53366df-a64f-4a5b-a713-4fc1bbe3f4ef.png#averageHue=%232d2f33&clientId=ud2f8213d-b719-4&from=paste&height=448&id=u00b55276&originHeight=560&originWidth=1251&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=67061&status=done&style=none&taskId=u98692fe0-917c-4434-a1f1-b1a7ff0974d&title=&width=1000.8)![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710848190109-e9f1c967-1156-42f4-bd80-09fca60ebc5a.png#averageHue=%232d3035&clientId=ud2f8213d-b719-4&from=paste&height=422&id=u5ae04aca&originHeight=527&originWidth=890&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=82172&status=done&style=none&taskId=u7194be5d-898e-4cde-a4dd-a6e0c07350d&title=&width=712)![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710848225576-d8ff84a7-b602-449e-b26d-6cd5571e283e.png#averageHue=%232c3034&clientId=ud2f8213d-b719-4&from=paste&height=698&id=ua4e92936&originHeight=873&originWidth=982&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=102750&status=done&style=none&taskId=u1b60cec1-6638-471b-90df-007d5dc7f32&title=&width=785.6)![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710848262998-6d9a48e9-21d4-4ade-be5a-536e27a6d5be.png#averageHue=%232c2f34&clientId=ud2f8213d-b719-4&from=paste&height=698&id=u5c08fbf8&originHeight=873&originWidth=982&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=100076&status=done&style=none&taskId=ub8b2bc36-0dff-422a-9b66-528f94fb07a&title=&width=785.6)![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710848354965-c6ece9fa-993c-4304-8897-c395d701d277.png#averageHue=%2326282d&clientId=ud2f8213d-b719-4&from=paste&height=764&id=ua95a4882&originHeight=955&originWidth=1917&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=219344&status=done&style=none&taskId=u99c0f157-4a85-4089-b580-3ed9418bfe7&title=&width=1533.6)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710848645092-9b959b6c-57ef-40e1-ae60-24c886188a15.png#averageHue=%231e2023&clientId=ud2f8213d-b719-4&from=paste&height=464&id=ub3a08d81&originHeight=580&originWidth=982&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=176931&status=done&style=none&taskId=ufbc0fcf6-b99c-4d80-97ae-cfa6137284b&title=&width=785.6)

![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710848799048-795c1b4b-89dc-407e-a041-c50a9841bd42.png#averageHue=%23292c31&clientId=ud2f8213d-b719-4&from=paste&height=452&id=u6eecfa65&originHeight=565&originWidth=706&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=60667&status=done&style=none&taskId=u7b670430-0e20-4490-8cd2-ee8411a52f6&title=&width=564.8)
# 编写代码

1. 创建 controller 类

![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710848898101-4a40eb94-4d18-4069-b2c8-8a05931cf34b.png#averageHue=%2325272b&clientId=ud2f8213d-b719-4&from=paste&height=345&id=u774e08db&originHeight=431&originWidth=1295&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=57342&status=done&style=none&taskId=u9cbbd16f-e99b-49cd-a4ae-49b2cc81927&title=&width=1036)
```java
package com.itheima.springbootquickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello world~";
    }
}
```
启动 springboot
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710849072953-d7733431-75f7-4b00-89e9-93a92692255e.png#averageHue=%2324262a&clientId=ud2f8213d-b719-4&from=paste&height=370&id=u3662bb7a&originHeight=463&originWidth=1595&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=77254&status=done&style=none&taskId=u152f80e9-07b0-4484-b73d-b5ec006219e&title=&width=1276)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710849104357-22f88101-7255-4def-953c-b18e3c41defb.png#averageHue=%23222427&clientId=ud2f8213d-b719-4&from=paste&height=402&id=ua71e8781&originHeight=503&originWidth=1703&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=67283&status=done&style=none&taskId=ua9ba7e65-5e74-4041-a391-50336b327b4&title=&width=1362.4)
# 案例测试
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710849188774-9ee6a318-fe93-4189-a5b5-f8884aa32b25.png#averageHue=%23f6f6f6&clientId=ud2f8213d-b719-4&from=paste&height=185&id=udd9ba923&originHeight=231&originWidth=881&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=18640&status=done&style=none&taskId=u4a0cda6c-2a66-4114-87e5-c4aaf91f5a7&title=&width=704.8)
