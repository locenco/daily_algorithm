package top.macondo.aigorithm.jz;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class JZ34 {
	public static void main(String[] args) {
		System.out.println(new JZ34().FirstNotRepeatingChar("abAcdeff"));
	}
	public int FirstNotRepeatingChar(String str) {
		int[] words = new int[58];//a-z 65-90;A-Z 97-122
		for(int i = 0;i<str.length();i++){
			words[((int)str.charAt(i))-65] += 1;
		}
		for(int i=0;i<str.length();i++){
			if(words[((int)str.charAt(i))-65]==1)
				return i;
		}
		return -1;
	}
}
