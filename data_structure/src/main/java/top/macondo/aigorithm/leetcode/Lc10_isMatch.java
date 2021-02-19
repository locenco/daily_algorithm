package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;
import top.macondo.aigorithm.jz.JZ52;

/**
 * 正则匹配
 *  动态规划版本
 *  递归版本 {@link JZ52}
 * @author: zhangchong
 * @Date: 2021/2/17 21:50
 **/
public class Lc10_isMatch {
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (p.charAt(j-1) == '*') {
					dp[i][j] = dp[i][j - 2] || (matches(s, p, i, j-1) && dp[i - 1][j]);
				}else {
					dp[i][j] = matches(s, p, i, j) && dp[i - 1][j - 1];
				}
			}
		}
		return dp[s.length()][p.length()];
	}
	public boolean matches(String s, String p, int i, int j) {
		if (i == 0) {
			return false;
		}
		if (p.charAt(j - 1) == '.') {
			return true;
		}
		return s.charAt(i - 1) == p.charAt(j - 1);
	}

	@Test
	public void testisMatch(){
		Assert.assertTrue(isMatch("aa","a*"));
	}
}
