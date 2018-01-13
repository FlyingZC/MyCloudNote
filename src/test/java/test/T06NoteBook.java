package test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.dao.NoteBookDao;
import com.zc.exception.UserNotFoundException;
import com.zc.service.NoteBookService;

public class T06NoteBook {
	static ApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	@Test
	public void testFindNoteBookByUserId(){//dao层
		String userId="6576c6dd-f1c8-49ed-aabc-ff0fb8fc6866";
		NoteBookDao dao=ctx.getBean("noteBookDao",NoteBookDao.class);
		List<Map<String,Object>> list=dao.findNoteBookByUserId(userId);
		for(Map<String,Object> map:list){
			System.out.println(map);
			
		}
	}
	@Test
	public void testListNoteBooks() throws UserNotFoundException{
		String userId="03590914-a934-4da9-ba4d-b41799f917d1";
		NoteBookService s=ctx.getBean("noteBookService",NoteBookService.class);
		List<Map<String,Object>> notes=s.listNoteBooks(userId);
		for(Map<String,Object> map:notes){
			Iterator<Entry<String, Object>> it=map.entrySet().iterator();
		}
	}
}
