package top.macondo.aigorithm.daliy;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 两数组并集
 * @author: zhangchong
 * @Date: 2021/2/3 21:59
 **/
public class ArrayUnionSet {
	/**
	 * 思想一：首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，
	 * 然后遍历第二个数组，对于第二个数组中的每个数字，
	 * 如果在哈希表中存在这个数字，则将该数字添加到答案，同时减少哈希表中该数字出现的次数。
	 */
	public Integer[] unionSet(int[] num1, int[] num2) {
		Map<Integer, Integer> num1Map = new HashMap<>();
		for (int num : num1) {
			num1Map.merge(num,1,(a,b)->{
				return a + b;});
		}
		List<Integer> result = new ArrayList<>();
		for (int num : num2) {
			int cur = num1Map.get(num);
			if (cur > 0) {
				num1Map.put(num, cur - 1);
				result.add(num);
			}
		}
		return result.stream().toArray(Integer[]::new);
	}

	/**
	 * 初始时，两个指针分别指向两个数组的头部。
	 * 每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，
	 * 如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。
	 * 当至少有一个指针超出数组范围时，遍历结束。
	 * @return
	 */
	public Integer[] unionSet2(int[] num1, int[] num2) {
		int num1Index = 0;
		int num2Index = 0;
		Arrays.sort(num1);
		Arrays.sort(num2);

		List<Integer> result = new ArrayList<>();
		while (num1Index < num1.length && num2Index < num2.length) {
			if (num1[num1Index] > num2[num2Index]) {
				num2Index++;
			}else if (num1[num1Index] < num2[num2Index]){
				num1Index++;
			}else {
				result.add(num1[num1Index]);
				num2Index++;
				num1Index++;
			}
		}
		return result.stream().toArray(Integer[]::new);
	}
	@Test
	public void testUnionSet(){
		int[] num1 = {1, 1, 2, 2};
		int[] num2 = { 2, 2};
		Assert.assertEquals(unionSet(num1,num2).length, 2);
		Assert.assertEquals(Optional.ofNullable(unionSet(num1, num2)[0]).get().intValue(), 2);
		Assert.assertEquals(Optional.ofNullable(unionSet(num1, num2)[1]).get().intValue(), 2);
	}
}
