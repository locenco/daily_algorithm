package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2021/2/18 15:57
 **/
public class Lc62_uniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
	@Test
	public void testuniquePaths(){
		Assert.assertEquals(uniquePaths(3,2),3);
		Assert.assertEquals(uniquePaths(3,7),28);
	}
}
