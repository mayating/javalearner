package cn.myt.util;

import jdk.internal.joptsimple.internal.Strings;
import jdk.internal.org.jline.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author mayating
 * @date 2021/10/14 4:32 下午
 */
@Component
public class RedisLockUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    private long timeout = 3000;

    /**
     * 上锁
     *
     * @param key   锁标识
     * @param value 线程标识
     * @return 上锁状态
     */
    public boolean lock(String key, String value) {
        long start = System.currentTimeMillis();
        while (true) {
            // 检测是否超时
            if (System.currentTimeMillis() - start > timeout) {
                return false;
            }
            // 执行命令
            Boolean absent = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.MILLISECONDS);
            // 是否成功获取锁
            if (absent) {
                return true;
            }
            return false;
        }
    }

    /**
     * 解锁
     *
     * @param target
     * @param timeStamp
     */
    public void unlock(String target, String timeStamp) {
        try {
            String currentValue = (String) redisTemplate.opsForValue().get(target);
            if (!Strings.isNullOrEmpty(currentValue) && currentValue.equals(timeStamp)) {
                //删除锁状态
                redisTemplate.opsForValue().getOperations().delete(target);
            }
        } catch (Exception e) {
            Log.error("解锁异常{}", e);
        }
    }
}
