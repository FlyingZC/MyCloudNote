package test;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01DataSource {
	ApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	@Test
	public void test01(){//测试dataSource
		DataSource ds=(DataSource) ctx.getBean("dataSource");
		System.out.println(ds);
	}
	@Test
	public void testSqlSessionFactoryBean(){//测试SqlSessionFactoryBean
		//SqlSessionFactoryBean工厂类返回的是不是SqlSessionFactoryBean类型
		SqlSessionFactory factory=ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(factory);
	}
	@Test
	public void testMapperScanner(){
		MapperScannerConfigurer scanner=(MapperScannerConfigurer) ctx.getBean("mapperScannerConfigurer");
		System.out.println(scanner);
	}
}
