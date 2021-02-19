package top.macondo.aigorithm.leetcode;

/**
 *
 * @author: zhangchong
 * @Date: 2021/2/18 16:04
 **/
public class Lc63_uniquePathsWithObstacles {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 0) {
				dp[i][0] = 1;
			}else {
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 0) {
				dp[0][i] = 1;
			}else {
				break;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				}else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	/**
	 * 空间复杂度：O(m)  使用一维数组存储一行的f值。
	 * 当i向下滚动时，左侧的f(i-1)已经滚动到表示左侧方格的f值，再加上上方方格的f(i)，即为新的f值
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[] f = new int[n];
		f[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					f[j] = 0;
					continue;
				} else if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
					f[j] += f[j - 1];
				}
			}
		}
		return f[n - 1];
	}
}
