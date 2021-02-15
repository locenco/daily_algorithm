package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2021/2/15 9:02
 **/
public class Lc1_twoSum {
	public int[] twoSum(int[] nums, int target) {
		/**
		 * 两种情况。
		 * 1. 都在左，都在右。 递归
		 * 2. 左一个，右一个。 双循环
		 */
		for (int i = 0; i < nums.length - 1; i++) {
			int number1 = nums[i];
			int expectNumber2 = target - number1;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == expectNumber2){
					return new int[]{i,j};
				}
			}
		}
		return null;
	}
	@Test
	public void testTwoSum(){
		Assert.assertArrayEquals(twoSum(new int[]{2,7,11,15},9),new int[]{0,1});
		Assert.assertArrayEquals(twoSum(new int[]{3,2,4},6),new int[]{1,2});
		Assert.assertArrayEquals(twoSum(new int[]{3,3},6),new int[]{0,1});
	}

}
