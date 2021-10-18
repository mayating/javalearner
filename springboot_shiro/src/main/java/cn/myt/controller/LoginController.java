package cn.myt.controller;

import cn.myt.pojo.ShiroUser;
import cn.myt.service.IShiroUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author mayating
 * @date 2021/10/14 6:34 下午
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Resource
    private IShiroUserService shiroUserService;

    @PostMapping("/register")
    public String register(ShiroUser shiroUser) {

        try {
            shiroUserService.addUser(shiroUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/jsp/register.jsp";
        }
        return "/jsp/login.jsp";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject);
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
            return "/jsp/login.jsp";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
            return "/jsp/login.jsp";
        }
        // 获取 token，返回
        System.out.println("认证通过");
        return "redirect:/jsp/index.jsp";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        System.out.println("退出登录成功");
        return "redirect:/jsp/login.jsp";
    }
}
