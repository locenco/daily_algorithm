package top.macondo.aigorithm.leetcode.recursion;

import top.macondo.aigorithm.leetcode.ListNode;

/**
 * 反转链表
 * @author: zhangchong
 * @Date: 2021/2/19 15:35
 **/
public class Lc_reverseList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newList = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newList;
	}

	/**
	 * 迭代
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}
}
