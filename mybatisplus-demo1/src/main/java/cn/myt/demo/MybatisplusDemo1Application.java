package cn.myt.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("cn.myt.demo.pharse1.mapper")
@MapperScan("cn.myt.demo.pharse2.mapper")
public class MybatisplusDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(MybatisplusDemo1Application.class, args);
	}

}
