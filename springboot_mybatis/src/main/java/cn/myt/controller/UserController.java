package cn.myt.controller;

import cn.myt.mapper.UserMapper;
import cn.myt.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mayating
 * @date 2021/10/10 10:10 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping
    public List<User> findUserList() {
        List<User> users = userMapper.selectUserList();
        return users;
    }
}
