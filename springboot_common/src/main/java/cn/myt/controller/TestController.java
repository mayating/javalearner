package cn.myt.controller;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${student.name}")
    private String name;

    @GetMapping
    public String testErrorPage() {
        // 手动抛出异常
        //int i = 3 / 0;
        //return "Hello Spring Boot World!";

        //String s = null;
        //s.equals("111");
        //return s;

        //String s = null;
        //if (s == null) {
        //    throw new BizException("-1", "字符串不能为空!");
        //}
        //return s;

        Integer.parseInt("abc123");
        return null;
    }

    @GetMapping(value = "/2")
    public String test2() {
        return name;
    }
}
