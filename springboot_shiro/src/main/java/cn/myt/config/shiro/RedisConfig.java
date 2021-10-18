package cn.myt.config.shiro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author mayating
 * @date 2021/10/18 3:58 下午
 */
@Configuration
public class RedisConfig {

    //注入自定义的RedisTemplate
    @Bean
    public RedisTemplate getRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    //注入Shiro的缓存对象
    @Bean
    public RedisCache getRedisCache() {
        RedisCache redisCache = new RedisCache();
        return redisCache;
    }


}
