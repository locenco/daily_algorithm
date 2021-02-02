package top.macondo.aigorithm.daliy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意：字符串长度 和 k 不会超过 104。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 * <p>
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路： 从左至右，设置三个标记curindex，posindex，nextindex。
 * posindex在定了左端起始位置curindex后，循环内用完k，找到最大长度
 * nextindex则用来标记第一个和curindex不相同的值，下次curindex直接从那里开始
 * 最终curindex往右走到头，返回最大值。
 * 这里再加个数据修正，如果到头了，k还剩有值，这时候，需要往curindex左侧加值
 * @author: zhangchong
 * @Date: 2021/2/2 21:43
 **/
public class CharacterReplacement {
	/**
	 * 自己硬编码写的算法
	 * @param s
	 * @param k
	 * @return
	 */
	public int characterReplacement(String s, int k) {
		if (s == null || "".equals(s)) {
			return 0;
		}
		int length = s.length();
		int maxSubStrLength = 0;
		for (int curIndex = 0, nextIndex = 0; curIndex < length; curIndex = nextIndex) {
			int cur = s.charAt(curIndex);
			int posIndex = curIndex + 1;
			nextIndex = curIndex + 1;
			boolean continuous = true;
			int tmpK = k;
			while (tmpK >= 0 && posIndex < length) {
				if (s.charAt(posIndex) == cur) {
					if (continuous) {
						nextIndex++;
					}
				} else if (tmpK > 0){
					tmpK--;
					continuous = false;
				}else {
					break;
				}
				posIndex++;
			}

			int curLength = (posIndex - curIndex);
			if (tmpK > 0 && posIndex == length) {
				curLength += tmpK > length - curLength ? length - curLength : tmpK;
			}
			maxSubStrLength = curLength > maxSubStrLength ? curLength : maxSubStrLength;
		}
		return maxSubStrLength;
	}

	/**
	 * 网上学到的滑动窗口的思想
	 * 初始都是0，right 往右滑动，并且保证窗口内，max + k 等于窗口大小
	 * 当 窗口大小 right - left + 1 > max + k时
	 * 		窗口左边界往右滑动，更新max，其实就是更新窗口大小。最终，left到最右端的距离就说最大窗口值
	 */
	public int characterReplacement2(String s, int k) {
		char[] sArr = s.toCharArray();
		int[] sCount = new int[26];
		int left = 0;
		int max = 0;
		for (int right = 0; right < s.length(); right++) {
			int index = sArr[right] - 'A';
			sCount[index]++;

			max = Math.max(sCount[index], max);
			if (right - left + 1 > max + k) {
				sCount[sArr[left] - 'A']--;
				left++;
			}
		}
		return sArr.length - left;

	}
	@Test
	public void testCharacterReplacement() {
		Assert.assertEquals(characterReplacement("ABAB", 2), 4);
		Assert.assertEquals(characterReplacement("ABBB", 2), 4);
		Assert.assertEquals(characterReplacement("AABABBA", 1), 4);
		Assert.assertEquals(characterReplacement2("ABAB", 2), 4);
		Assert.assertEquals(characterReplacement2("ABBB", 2), 4);
		Assert.assertEquals(characterReplacement2("AABABBA", 1), 4);
	}
}
