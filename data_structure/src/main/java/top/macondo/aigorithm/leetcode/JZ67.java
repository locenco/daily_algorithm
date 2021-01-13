package top.macondo.aigorithm.leetcode;

/**
 * 长为 n 2<=n<=60
 * m段  2<=m<=n
 * @author: zhangchong
 * @Date: 2020/9/20 16:52
 **/
public class JZ67 {
	/**
	 * 动态规划的自底向上方式
	 * @param target
	 * @return
	 */
	public static int cutRope(int target) {
		if (target > 60 || target < 2){
			throw new IllegalArgumentException("2 <= n <= 60");
		}
		int[] result = new int[target + 1];
		result[0] = 1;
		result[1] = 1;
		for (int i = 2; i <= target ; i++) {
			int q = -1;
			for (int j = 1; j <= i; j++) {
				q = Math.max(q, result[i - j] * j );
			}
			result[i] = q;
		}
		result[2] = 1;
		result[3] = 2;
		return result[target];
	}

	/**
	 * 第二种解法
	 *
	 * @param args
	 */

	public static void main(String[] args) {
		System.out.println(cutRope(7));
	}
}
