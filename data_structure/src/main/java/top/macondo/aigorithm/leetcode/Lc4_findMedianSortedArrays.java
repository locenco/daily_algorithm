package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * @author: zhangchong
 * @Date: 2021/2/15 10:32
 **/
public class Lc4_findMedianSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if (m == 0 && n == 0) {
			return 0;
		} else if (m == 0 && n == 1) {
			return nums2[0];
		} else if (m == 1 && n == 0) {
			return nums1[0];
		}

		boolean isOdd = (m + n) % 2 == 1;
		int middle = (m + n) / 2; // 4 ->2 (2,3) ,5-> 2 (3)
		int nums1Index = 0, nums2Index = 0;

		/**
		 * 1. 分奇数偶数。
		 * 2. 计数，比大小，找到中位数
		 * 3. 边值边界处理
		 */
		double middle1 = 0;
		double middle2 = 0;
		for (int i = 0; i < middle -1; i++) {
			if (nums1Index == m){
				nums2Index ++;
			}else if (nums2Index == n){
				nums1Index ++;
			}else if (nums1[nums1Index] > nums2[nums2Index]){
				nums2Index ++;
			}else {
				nums1Index ++;
			}
		}
		if (nums1Index == m){
			middle1 = nums2[nums2Index];
			middle2 = nums2[nums2Index+1];
		}else if (nums2Index == n){
			middle1 = nums1[nums1Index];
			middle2 = nums1[nums1Index+1];
		}else if (nums1[nums1Index] < nums2[nums2Index]){
			middle1 = nums1[nums1Index];
			if (nums1Index + 1 == m) {
				middle2 = nums2[nums2Index];
			}else {
				middle2 = nums1[nums1Index + 1] > nums2[nums2Index] ? nums2[nums2Index] : nums1[nums1Index + 1];
			}
		}else {
			middle1 = nums2[nums2Index];
			if (nums2Index + 1 == n) {
				middle2 = nums1[nums1Index];
			}else {
				middle2 = nums1[nums1Index] > nums2[nums2Index + 1] ? nums2[nums2Index + 1] : nums1[nums1Index];
			}
		}
		return isOdd ? middle2 : (middle1+ middle2)/2.0;
	}


	@Test
	public void testfindMedianSortedArrays(){
		System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
		System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
		System.out.println(findMedianSortedArrays(new int[]{0,0},new int[]{0,0}));
		System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4,5}));
		System.out.println(findMedianSortedArrays(new int[]{},new int[]{1}));
		System.out.println(findMedianSortedArrays(new int[]{3,4},new int[]{}));
		System.out.println(findMedianSortedArrays(new int[]{3},new int[]{-2,-1}));
	}
}
