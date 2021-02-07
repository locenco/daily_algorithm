package top.macondo.java.base.map;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author: zhangchong
 * @Date: 2021/2/1 14:42
 **/
public class HashMapTest {
	@Test
	public void testResize(){
		HashMap<Object, Object> map = new HashMap<>();
		map.put("1", "value1");
		map.size();
	}
}
