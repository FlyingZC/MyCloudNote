package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.entity.User;
import com.zc.service.UserService;

public class T05RegistUser {
	static ApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	@Test
	public void test01(){
		UserService s=ctx.getBean("userService",UserService.class);
		User user=s.regist("Jerry","Mouse", "123","123");
		System.out.println(user);
	}
	public static void main(String[] args) {
		ctx=new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml","spring-service.xml");
		UserService s=ctx.getBean("userService",UserService.class);
		User user=s.regist("Jerry","Mouse", "123","123");
		System.out.println(user);
	}
}
