package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author: zhangchong
 * @Date: 2021/2/18 9:22
 **/
public class Lc32_longestValidParentheses {
	public int longestValidParentheses(String s) {
		Stack<Integer> parenthensStack = new Stack<>();
		int longestValid = 0;
		parenthensStack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				parenthensStack.push(i);
			}else {
				parenthensStack.pop();
				if (parenthensStack.isEmpty()) {
					parenthensStack.push(i);
				}else {
					longestValid = Math.max(i - parenthensStack.peek(),longestValid);
				}
			}
		}
		return longestValid;
	}
	public int longestValidParentheses2(String s) {
		int[] dp = new int[s.length()];
		int longestValid = 0;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				}else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
			}
			longestValid = Math.max(longestValid, dp[i]);
		}
		return longestValid;
	}

	@Test
	public void testlongestValidParentheses(){
		Assert.assertEquals(longestValidParentheses2("(()"),2);
		Assert.assertEquals(longestValidParentheses2(")()())"),4);
		Assert.assertEquals(longestValidParentheses2(""),0);
		Assert.assertEquals(longestValidParentheses2("())()"),2);
	}


}
