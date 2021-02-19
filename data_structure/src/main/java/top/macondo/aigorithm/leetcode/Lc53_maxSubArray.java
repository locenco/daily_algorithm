package top.macondo.aigorithm.leetcode;

/**
 * @author: zhangchong
 * @Date: 2021/2/18 15:11
 **/
public class Lc53_maxSubArray {
	public int maxSubArray(int[] nums) {
		int sum = 0;
		int ans = nums[0];
		for (int num : nums) {
			sum = Math.max(sum + num, num);
			ans = Math.max(ans, sum);
		}
		return ans;
	}
}
