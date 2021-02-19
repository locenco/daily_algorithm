package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2021/2/18 16:50
 **/
public class Lc70 {
	public int climbStairs(int n) {
		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}
	@Test
	public void test(){
		Assert.assertEquals(climbStairs(3),3);
		Assert.assertEquals(climbStairs(4),5);
	}
}
