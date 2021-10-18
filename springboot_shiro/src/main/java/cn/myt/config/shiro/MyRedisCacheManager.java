package cn.myt.config.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @author mayating
 * @date 2021/10/18 3:45 下午
 */
public class MyRedisCacheManager implements CacheManager {

    /**
     * 只要加入了缓存管理器，配置了缓存管理类，系统就会默认在查询完认证和授权后将信息放入到缓存中
     * 且下次需要认证和授权时，都是优先去查询缓存中的内容，查询不到，才会去查询数据库，这里也验证了这一点，
     * 与之前的画的加入缓存后的授权信息的获取图是一样的。
     *
     * @param cacheName
     * @param <K>
     * @param <V>
     * @return
     * @throws CacheException
     */
    @Override
    public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
        System.out.println("进入到了自定义缓存管理器,传入参数cacheName：" + cacheName);

        return new RedisCache<K, V>(cacheName);
    }
}
