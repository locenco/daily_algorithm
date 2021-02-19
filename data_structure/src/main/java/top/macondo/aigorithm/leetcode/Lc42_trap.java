package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2021/2/18 14:55
 **/
public class Lc42_trap {
	public int trap(int[] height) {
		int[] max_left = new int[height.length];
		int[] max_right = new int[height.length];
		for (int i = 1; i < height.length - 1; i++) {
			max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
		}
		for (int i = height.length -2; i >= 0; i--) {
			max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
		}
		int ans = 0;
		for (int i = 0; i < height.length; i++) {
			int min = Math.min(max_left[i],max_right[i]);
			ans += min > height[i] ? min - height[i] : 0;
		}
		return ans;
	}
	@Test
	public void testTrap(){
		Assert.assertEquals(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}),6);
		Assert.assertEquals(trap(new int[]{4,2,0,3,2,5}),9);
	}
}
