package cn.myt.demo;

import cn.myt.demo.mapper.UserMapper;
import cn.myt.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisplusDemo1ApplicationTests {

	//@Autowired
	@Resource
	private UserMapper userMapper;

	@Test
	void contextLoads() {
		// CRUD

		// 1.查询所有的数据
		List<User> users = userMapper.selectList(null);
		System.out.println(users);

		// 2.根据 ID 删除
		userMapper.deleteById(1);

		//// 3.添加数据
		User user = new User();
		user.setName("老王");
		user.setEmail("laowang@qq.com");
		user.setAge(18);
		userMapper.insert(user);

		System.out.println(user);

		// 4.更新数据
		user.setName("老王王");
		user.setEmail("lanwangwang@qq.com");
		userMapper.updateById(user);
	}

}
