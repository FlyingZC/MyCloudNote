package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.service.UserService;

public class T03Service {
	ApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml");
	}
	@Test
	public void testLogin(){
		UserService service=(UserService) ctx.getBean("userService");
		String name="ZCCX";
		String password="123";
		service.login(name, password);
	}
}
