package com.ibit.linkedlists;

/**
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 *  Note:
 *      Given m, n satisfy the following condition:
 *      1 ≤ m ≤ n ≤ length of list.
 *  Note 2:
 *      Usually the version often seen in the interviews is reversing the 
 *      whole linked list which is obviously an easier version of this question.
 **/

public class ReverseList2 {
	
	public static ListNode reverseThePortion(ListNode head,int m,int n) {
		if(!(1<=m && m<=n && n<= getSizeOfTheList(head)))
			return null;
		
		ListNode prev=null,current=null,next=null; 
		
		prev=head;
		current=head;
		int count=1;
		while(current!=null&&count!=m) {
			prev=current;
			current=current.next;
			count++;
		}
		
		
		
		return null;
	}
	
	public static int getSizeOfTheList(ListNode head) {
		int count=0;
		while(head!=null) {
			++count;
			head=head.next;
		}
		return count;
	}
	public static void main(String args[]) {
		
	}
}