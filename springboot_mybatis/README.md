##操作指南   
一、准备工作：  
1.创建数据库   
2.创建表并构造表数据   
3.添加数据库驱动和数据库连接池依赖
4.添加 mybatis 依赖  
5.配置文件：数据源和 mybatis 的配置   
6.主启动类加注解@MapperScan   
7.在 pojo 下创建实体类Xxx.java，需实现序列化接口   
8.在 mapper 下创建  XxxMapper.java 接口，在 resource 下创建 XxxMapper.xml文件   
9.编写controller，注入 mapper 接口（实际注入的是代理对象）测试   

二、pom.xml 依赖：   
1.数据库驱动： 版本8.0+，注意驱动类是 com.mysql.cj.jdbc.Driver   
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.26</version>
</dependency>
```
2.数据库连接池依赖：选择 Druid，与 spring boot 集成的依赖   
```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.2.8</version>
</dependency>
```
3.mybatis 依赖：与 spring boot 集成的依赖   
```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.2.0</version>
</dependency>
```
   
三、配置文件application.properties：配置数据源和 MyBatis：
```properties
# 端口号
server.port=8080
#mapper xml 文件地址
mybatis.mapper-locations=classpath*:mapper/*Mapper.xml
# 数据库url
spring.datasource.url=jdbc:mysql://110.40.237.100:3306/test?characterEncoding=utf8&serverTimezone=UTC
# 数据库用户名
spring.datasource.username=root
# 数据库密码
spring.datasource.password=123456
# 数据库驱动
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
四、@MapperScan：指扫描 mapper 包下的 Mapper 接口并创建代理对象，可指定扫描包，也可不指定，默认扫描启动类下的包   
```java
@MapperScan(basePackages = {"cn.myt.mapper","cn.myt.mapper2"})
```
注：@Mapper是对单个接口类的注解，@MapperScan 是对整个包下所有接口类的注解的。