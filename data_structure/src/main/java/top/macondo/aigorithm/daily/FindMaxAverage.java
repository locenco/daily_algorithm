package top.macondo.aigorithm.daily;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 提示：
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * @author: zhangchong
 * @Date: 2021/2/4 20:31
 **/
public class FindMaxAverage {
	public double findMaxAverage(int[] nums, int k) {
		double sum = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		double max = sum;
		for (int i = 1; i <= nums.length - k; i++) {
			sum = sum - nums[i - 1] + nums[i + k - 1];
			max = Math.max(sum, max);
		}
		return max / k;
	}
	@Test
	public void testFindMaxAverage(){
		Assert.assertTrue(findMaxAverage(new int[]{1,12,-5,-6,50,3},4) == 12.75);
		System.out.println(findMaxAverage(new int[]{0,4,0,3},1) );
		System.out.println((findMaxAverage(new int[]{0,1,1,3,3},4)));
	}
}
