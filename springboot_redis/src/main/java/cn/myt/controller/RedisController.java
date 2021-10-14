package cn.myt.controller;

import cn.myt.mapper.UserMapper;
import cn.myt.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * 一个完整的增删改查例子
 *
 * @author mayating
 * @date 2021/10/14 10:47 上午
 */
@RestController
@RequestMapping("/test")
public class RedisController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/add")
    @CachePut(value = "neverExpire", key = "#user.id")
    public User add(@RequestBody User user) {
        userMapper.insert(user);
        return user;
    }

    @PostMapping("/update")
    @CachePut(value = "neverExpire", key = "#user.id")
    public User update(@RequestBody User user) {
        userMapper.update(user, null);
        return user;
    }

    @GetMapping("/delete")
    @CacheEvict(value = "neverExpire", key = "#uid")
    public String delete(@RequestParam(value = "uid") String uid) {
        userMapper.deleteById(uid);
        return uid;
    }

    @GetMapping("/detail")
    @Cacheable(value = "neverExpire")
    public User detail(@RequestParam(value = "uid") String uid) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        return userMapper.selectOne(queryWrapper);
    }
}
