package cn.myt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mayating
 * @date 2021/10/11 9:27 上午
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping
    public String testErrorPage() {
        // 手动抛出异常
        int i = 3 / 0;
        return "Hello Spring Boot World!";
    }
}
