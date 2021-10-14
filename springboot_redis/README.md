

>参考文档：https://www.jianshu.com/p/5b7296445a0e   
   
## 纯注解使用
1.pom.xml ：引入依赖   
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
2.修改主配置文件：添加 redis相关配置   
```properties
spring.redis.host=127.0.0.1
spring.redis.port=6379
#客户端超时
spring.redis.timeout=10000
#最大连接数
spring.redis.lettuce.pool.max-active=20
#最小空闲
spring.redis.lettuce.pool.min-idle=5
#连接超时
spring.redis.lettuce.pool.max-wait=5000ms
#最大空闲
spring.redis.lettuce.pool.max-idle=20
```
3.Redis 配置
- redisTemplate 相关配置
- 选择 redis 作为默认缓存工具  

4.实体类序列化

5.controller注解开发   
```java
@CacheEvict(value="realTimeCache", allEntries=true)：删除缓存中的数据

@Cacheable(value="realTimeCache", key="'student_'+#id") ：在方法执行前 Spring 先查看缓存中是否有数据，
如果有数据，则直接返回缓存数据；没有则调用方法并将方法返回值放进缓存

@CachePut：将方法中的返回值放到缓存中
```

## 注解+代码混合使用   
前4个步骤同上

5.redis 操作类封装   
RedisUtils

6.service 开发   
使用 RedisUtils 操作 redis

## 分布式锁简单实现
利用 setnx 机制实现简单的分布式锁   
> 只有当锁定资源不存在的时候才能 SET 成功。利用 Redis 的原子性，Redis 保证在同一时间，多个请求写入相同 key 的数据，只有一个请求可以成功
> 写入，而之后的所有线程在锁定资源被释放之前都不能获得锁。

RedisLockUtils


## 其他说明

1.springboot2.x 使用客户端 lettuce 代替 jedis，原因如下：   
- jedis：采用直连，在多线程环境下是非线程安全的，此时只有使用连接池，为每个 redis 实例增加物理连接
- lettuce：采用 netty，实例可以在多个线程中共享，线程安全，可减少线程数量   

2.1个自动配置类绑定1个 Properties。   
redis 的自动配置类为 `RedisAutoConfiguration`，对应的 properties 为 `RedisProperties`   

3.为什么重写 RedisTemplate，来代替 spring 提供的模板呢？   
RedisTemplate默认使用 JdkSerializationRedisSerializer 序列化，会使我们的部分字符转义，使用stringRedisTemplate会存在同样的问题，需要手动将实体类转成json字符串；
Spring配置的两个RedisTemplate都不太方便使用。  
 
4.为什么自己实现一个 RedisTemplate 就可以代替 spring 提供的？   
spring提供的 RedisTemplate 这个bean有个注解 @ConditionalOnMissingBean(name = {"redisTemplate"}) 当name里面的bean不存在才会生效，意味着我们可以自己实现

