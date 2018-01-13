package test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class T04MD5 {//MD5加密
	@Test
	public void testMd5(){
		String str="12345678";
		//commons-codec
		String md5=DigestUtils.md5Hex(str);
		//25d55ad283aa400af464c76d713c07ad
		//25d55ad283aa400af464c76d713c07ad
		System.out.println(md5);
	}
	@Test
	public void testMd5Crypt(){
		String pwd="12345678";
		String salt="你吃了吗";
		String s=DigestUtils.md5Hex(pwd+salt);
		//2d418137b63729b8b07db2be3ea9ed1e
		//2d418137b63729b8b07db2be3ea9ed1e
		//加盐防止破解
		System.out.println(s);
	}
}
