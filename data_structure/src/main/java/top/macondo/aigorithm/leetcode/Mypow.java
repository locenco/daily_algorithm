package top.macondo.aigorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2021/2/19 16:19
 **/
public class Mypow {
	public double myPow(double x, int n) {
		double sum = 1;
		double tmp = x;
		while (n != 0) {
			if ((n & 1) == 1) {
				sum *= tmp;
			}
			tmp *= tmp;
			n = n >> 1;
		}

		return sum;
	}

	public double myPow2(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}
		double y = myPow(x, n / 2);
		return (n & 1) == 0 ? y * y : y * y * x;
	}
	public double quickMul(double x, long N) {
		if (N == 0) {
			return 1.0;
		}
		double y = quickMul(x, N / 2);
		return N % 2 == 0 ? y * y : y * y * x;
	}

	public double myPow3(double x, int n) {
		long N = n;
		return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
	}

	@Test
	public void test(){
		Assert.assertEquals(myPow(2.0,3),8.0,0.0);
		Assert.assertEquals(myPow(2.0,4),16.0,0.0);
		Assert.assertEquals(myPow2(2.0,-3),1/8.0,0.0);
	}
	public static void main(String[] args) {
		System.out.println(5 >> 1);
		System.out.println(4 >> 1);
		System.out.println(3 >> 1);
		System.out.println(2 >> 1);
		System.out.println(1 >> 1);
		System.out.println(5 & 1);
		System.out.println(4 & 1);
		System.out.println(3 & 1);
		System.out.println(2 & 1);
		System.out.println(1 & 1);
	}
}
