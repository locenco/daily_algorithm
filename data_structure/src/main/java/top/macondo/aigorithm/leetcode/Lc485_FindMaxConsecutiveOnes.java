package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangchong
 * @Date: 2021/2/15 8:48
 **/
public class Lc485_FindMaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int maxConsecutive = 0;
		int tempConsecutive = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1){
				tempConsecutive++;
			}else {
				maxConsecutive = Math.max(maxConsecutive, tempConsecutive);
				tempConsecutive = 0;
			}
		}
		maxConsecutive = Math.max(maxConsecutive, tempConsecutive);
		return maxConsecutive;
	}
	@Test
	public void testMax(){
		int[] nums = new int[]{1,1,0,1,1,1};
		Assert.assertEquals(findMaxConsecutiveOnes(nums), 3);
	}
}
