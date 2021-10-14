package cn.myt.controller;

import cn.myt.pojo.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mayating
 * @date 2021/10/13 2:47 下午
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping("/info")
    //@Cacheable(value = "user", key = "#id") //开启注解，接口返回数据被缓存，value 是缓存的名称，key 是缓存的键
    @Cacheable(value = "1min", key = "#id")
    public User getUser(@RequestParam(value = "id") String id) {
        System.out.println("getUser===>" + id);
        User user = new User();
        user.setId(id);
        user.setEmail(id + "@qq.com");
        user.setName(id + ":" + System.currentTimeMillis());
        return user;
    }
}
