package cn.myt.config.shiro;

import lombok.NoArgsConstructor;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Set;

/**
 * 真实场景下，还需要考虑过期时间的设置
 *
 * @author mayating
 * @date 2021/10/18 3:50 下午
 */
@NoArgsConstructor
public class RedisCache<k, v> implements Cache<k, v> {

    private String cacheName;

    @Autowired
    public RedisTemplate redisTemplate;

    public static RedisTemplate redisTemplateSelf;

    @PostConstruct
    public void getRedisTemplate() {
        redisTemplateSelf = redisTemplate;
    }

    public RedisCache(String cacheName1) {
        this.cacheName = cacheName1;
    }

    /**
     * 获取缓存
     *
     * @param k
     * @return
     * @throws CacheException
     */
    @Override
    public v get(k k) throws CacheException {
        System.out.println(cacheName + ":获取缓存方法，传入参数：" + k + ",此时的redisTemplate:" + redisTemplateSelf);
        //获取缓存中数据时一定要为k加toStirng方法，否则会报错序列化的错
        if (null != redisTemplateSelf.opsForHash().get(cacheName.toString(), k.toString())) {
            return (v) redisTemplateSelf.opsForHash().get(cacheName.toString(), k.toString());
        }
        return null;
    }

    /**
     * 设置缓存
     *
     * @param k
     * @param v
     * @return
     * @throws CacheException
     */
    @Override
    public v put(k k, v v) throws CacheException {
        System.out.println("加入缓存方法，传入参数 K:" + k + ",V:" + v);
        //放入redis中的值，一定要是序列化的对象
        redisTemplateSelf.opsForHash().put(cacheName.toString(), k.toString(), v);
        return null;
    }

    /**
     * 移除缓存
     *
     * @param k
     * @return
     * @throws CacheException
     */
    @Override
    public v remove(k k) throws CacheException {
        System.out.println("调用了remove方法,传入参数：" + k.toString());
        redisTemplateSelf.opsForHash().delete(cacheName.toString(), k.toString());
        return null;
    }

    /**
     * 清除缓存
     *
     * @throws CacheException
     */
    @Override
    public void clear() throws CacheException {
        System.out.println("调用了clear方法");
        redisTemplateSelf.delete(cacheName);
    }

    @Override
    public int size() {
        return redisTemplateSelf.opsForHash().size(cacheName).intValue();
    }

    @Override
    public Set<k> keys() {
        return redisTemplateSelf.opsForHash().keys(cacheName);
    }

    @Override
    public Collection<v> values() {
        return redisTemplateSelf.opsForHash().values(cacheName);
    }
}

