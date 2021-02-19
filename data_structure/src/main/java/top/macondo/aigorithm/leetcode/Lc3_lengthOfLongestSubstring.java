package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * TODO 多思考
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: zhangchong
 * @Date: 2021/2/15 9:56
 **/
public class Lc3_lengthOfLongestSubstring {
	/**
	 * 滑动窗口，从左往右，新增则增大窗口，有重复，则重置，重新计数。
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		// 记录字符上一次出现的位置
		int[] last = new int[128];
		for(int i = 0; i < 128; i++) {
			last[i] = -1;
		}
		int n = s.length();

		int res = 0;   // 子串的最大长度
		int start = 0; // 窗口开始位置
		/**
		 * 每次将最新的字符 index 记录到last
		 * 当index滑到当前字符，如果该字符的旧位置比start大，则从start到当前字符之间，是有重复的。
		 * 	 1. 将start 改为旧位置的后一位。
		 * 	 2. 当前字符写入last
		 * 当前的res的长度计算时，用i - start +1。并求最大
		 */
		for(int i = 0; i < n; i++) {
			int index = s.charAt(i);
			start = Math.max(start, last[index] + 1);
			res   = Math.max(res, i - start + 1);
			last[index] = i;
		}

		return res;
	}
	@Test
	public void testLength(){
		Assert.assertEquals(lengthOfLongestSubstring("abcabcbb"),3);
	}
}
