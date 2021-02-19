package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2021/2/18 16:29
 **/
public class Lc64 {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[] f = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int temp;
				if (j == 0) {
					temp = f[j];
				} else if (i == 0) {
					temp = f[j - 1];
				}else {
					temp = Math.min(f[j - 1], f[j]);
				}
				f[j] = temp + grid[i][j];
			}
		}
		return f[n - 1];
	}
	@Test
	public void testminPathSum(){
		Assert.assertEquals(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}),7);
		Assert.assertEquals(minPathSum(new int[][]{{1,2,3},{4,5,6}}),12);
	}
}
