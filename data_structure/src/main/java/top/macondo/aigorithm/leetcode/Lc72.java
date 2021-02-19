package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2021/2/18 17:03
 **/
public class Lc72 {
	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length()+1][word2.length()+1];

		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= word2.length(); i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				int temp;
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					temp = dp[i - 1][j - 1];
				}else {
					temp = dp[i - 1][j - 1] + 1; //替换
				}
				//删除 or 插入
				dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), temp);
			}
		}
		return dp[word1.length()][word2.length()];
	}
	@Test
	public void test(){
		Assert.assertEquals(minDistance("horse","ros"), 3);
	}
}
