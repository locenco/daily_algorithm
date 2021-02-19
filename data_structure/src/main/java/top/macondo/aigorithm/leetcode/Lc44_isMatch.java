package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2021/2/18 15:28
 **/
public class Lc44_isMatch {
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i <= p.length(); ++i) {
			if (p.charAt(i - 1) == '*') {
				dp[0][i] = true;
			} else {
				break;
			}
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				}else {
					dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
				}
			}
		}
		return dp[s.length()][p.length()];
	}

	@Test
	public void testisMatch(){
		Assert.assertEquals(isMatch("aa","*"),true);
		Assert.assertEquals(isMatch("aa","a"),false);
		Assert.assertEquals(isMatch("cb","?a"),false);
		Assert.assertEquals(isMatch("adceb","*a*b"),true);
		Assert.assertEquals(isMatch("acdcb","a*c?b"),false);
	}
}
