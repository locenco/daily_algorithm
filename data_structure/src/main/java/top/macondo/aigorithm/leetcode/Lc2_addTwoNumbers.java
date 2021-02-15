package top.macondo.aigorithm.leetcode;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangchong
 * @Date: 2021/2/15 9:19
 **/
public class Lc2_addTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result = new ListNode();
		ListNode root = result;
		int temp = 0;
		if (l1 == null && l2 == null) {
			return root;
		}
		do{
			/**
			 * 1. 都有值，相加， 并10求余，高位写到进位
			 * 2. 有空则直接写
			 */
			int l1Val = 0;
			if (l1 !=null){
				l1Val = l1.val;
				l1 = l1.next;
			}
			int l2Val = 0;
			if (l2 !=null){
				l2Val = l2.val;
				l2 = l2.next;
			}
			int addSum = l1Val + l2Val + temp;
			result.val = addSum % 10;
			temp = addSum / 10;
			if (l1 == null && l2 == null && temp == 0) {
				return root;
			}
			result.next = new ListNode();
			result = result.next;
		}while (true);
	}
	@Test
	public void testAddSum(){
		ListNode node1 = new ListNode(2);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(3);
		ListNode node2 = new ListNode(5);
		node2.next = new ListNode(6);
		node2.next.next = new ListNode(4);

		ListNode sum = addTwoNumbers(node1,node2);
		Assert.assertEquals(sum.val,7);
		Assert.assertEquals(sum.next.val,0);
		Assert.assertEquals(sum.next.next.val,8 );
	}

}
