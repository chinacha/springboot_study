SpringBoot 提供了 `properties`和 `yaml`两种配置文件
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710916674189-76c3ab1f-d9f5-46bd-9e00-06808ccf00cb.png#averageHue=%23fdfcf5&clientId=u577ddaf1-a30f-4&from=paste&height=402&id=u0d257277&originHeight=502&originWidth=796&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=116050&status=done&style=none&taskId=u2600a82d-c091-43df-9dc9-aeaa6155b14&title=&width=636.8)
# properties 配置文件
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710915602412-e3c3b380-3312-4f37-9a71-71eee97cac85.png#averageHue=%23edeceb&clientId=u577ddaf1-a30f-4&from=paste&height=386&id=uecb8a6e7&originHeight=482&originWidth=502&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=22270&status=done&style=none&taskId=ucf597d8c-179b-48e4-9cf2-18017a9940b&title=&width=401.6)
使用 IDEA 创建的 SpringBoot 会自动生成一个 `applocation.properties`配置文件，在这个文件中可以配置一些信息，并且 SpringBoot 可以自动识别。
成功运行 springboot 后控制台会有如下显示：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710916032780-1227b79c-18fe-4429-a581-80c24c9f2725.png#averageHue=%2324262b&clientId=u577ddaf1-a30f-4&from=paste&height=272&id=u82fd57fe&originHeight=340&originWidth=854&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=63071&status=done&style=none&taskId=udd0ebed8-f9c3-422b-9727-b37115126c3&title=&width=683.2)
当你看到Spring Boot应用启动后显示“Tomcat started on port 8080 (http) with context path ''”这样的信息时，它意味着你的Spring Boot应用已经成功地将内嵌的Tomcat服务器启动在了8080端口上，并且该应用的上下文路径（context path）为空。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710916151342-bff0b81c-75c1-47b1-8b60-6f1e2c05e314.png#averageHue=%23292c30&clientId=u577ddaf1-a30f-4&from=paste&height=506&id=udd7fbfc4&originHeight=632&originWidth=955&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=69643&status=done&style=none&taskId=uf7da424e-9da6-4b51-a1c1-abd460c4151&title=&width=764)
在 `applocation.properties`配置文件中进行以上配置，再次启动 springboot：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710916215049-1f503ab4-4c74-4c96-bcbe-40ae585de43d.png#averageHue=%2324272b&clientId=u577ddaf1-a30f-4&from=paste&height=325&id=uf6869150&originHeight=406&originWidth=953&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=82651&status=done&style=none&taskId=u22f0286e-c50f-46f2-ae98-1b2332c6cb1&title=&width=762.4)
可以发现 tomcat 的端口号已经被改成了`9090`
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710916326541-aa2c030e-e3fe-407e-b1a7-c2118c46fbd1.png#averageHue=%23232529&clientId=u577ddaf1-a30f-4&from=paste&height=141&id=u1932422f&originHeight=176&originWidth=548&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=13171&status=done&style=none&taskId=u7e0dda89-7cb7-491f-88b5-88cbf202df0&title=&width=438.4)
再次进行以上修改，再次启动 springboot
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710916375938-c42b8d94-ee38-456c-a6dc-f06a40ef3d88.png#averageHue=%2323262b&clientId=u577ddaf1-a30f-4&from=paste&height=333&id=ude186906&originHeight=416&originWidth=999&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=85970&status=done&style=none&taskId=ub1151799-b90f-47ee-8000-8ab64d5c48c&title=&width=799.2)
可以发现，虚拟目录也已经被修改成 `/start`了

在浏览器输入地址进行访问的时候也应该进行地址的修改：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710916541513-cbb9fafb-f7d5-4881-af3e-8f821b56997d.png#averageHue=%23f3f3f2&clientId=u577ddaf1-a30f-4&from=paste&height=137&id=ubc1c5868&originHeight=171&originWidth=1015&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=19371&status=done&style=none&taskId=u58eee054-ca51-47e7-ae5e-8e9f6a0cc52&title=&width=812)
从原先的 `localhost:8080/hello`变为 `localhost:9090/start/hello`
# yaml 配置文件
`.yaml`文件和 `.yml`文件知识后缀名不一样，其他的都是一模一样的
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710917079258-82b15ce1-3c67-4edc-a868-845eb72d39eb.png#averageHue=%23fdfcf7&clientId=u577ddaf1-a30f-4&from=paste&height=522&id=ue4c67cf1&originHeight=653&originWidth=1053&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=111414&status=done&style=none&taskId=u1d3d2e9c-6bca-43c2-94b1-25dae039ac1&title=&width=842.4)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710917261121-76e36d93-e2cc-4d7c-8920-a94d8701cf35.png#averageHue=%2324272b&clientId=u577ddaf1-a30f-4&from=paste&height=726&id=u3c5d98a8&originHeight=908&originWidth=1679&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=228585&status=done&style=none&taskId=ub564feca-7696-49b3-a147-503c9850c7b&title=&width=1343.2)
启动 springboot 后端口号和虚拟地址也得到了同样的修改：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/28695155/1710917318060-e08e30bc-c36f-4534-adc4-cd8d789715de.png#averageHue=%23f9f9f8&clientId=u577ddaf1-a30f-4&from=paste&height=252&id=u2ec748b7&originHeight=315&originWidth=792&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=15062&status=done&style=none&taskId=u72bfe0b2-fe77-470e-ba7d-714e121c36b&title=&width=633.6)
# 小结
这两种配置文件更长用的是`yaml`/`yml`，因为相比于 `properties`，它更加层次清晰、更加关注数据
