package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2021/2/17 20:28
 **/
public class Lc5_longestPalindrome {
	public String longestPalindrome(String s) {

		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		/**
		 * 回文的长度从0 到n-1
		 */
		String longestPalindrome = "";
		for (int l = 0; l < n; l++) {
			for (int i = 0; i + l < n; i++) {
				int j = i + l;
				if (l == 0) {
					dp[i][j] = true;
				} else if (l == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				}else {
					dp[i][j] =  s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
				}
				if (dp[i][j] && l + 1 > longestPalindrome.length()) {
					longestPalindrome = s.substring(i, i + l + 1);
				}
			}
		}
		return longestPalindrome;
	}
	@Test
	public void testlongestPalindrome(){
		Assert.assertEquals(longestPalindrome("abab"),"aba");
	}
}
