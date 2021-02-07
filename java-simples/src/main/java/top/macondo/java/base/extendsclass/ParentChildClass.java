package top.macondo.java.base.extendsclass;

import lombok.Data;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2020/11/20 20:15
 **/
public class ParentChildClass {
	@Data
	class parent{
		String a;
	}
	@Data
	class child extends parent {
		String b;
	}
	@Test
	public void test(){
		child child = new child();
		child.setB("b");
		parent parent = child;
		System.out.println(child);
		System.out.println(parent);
	}
}
