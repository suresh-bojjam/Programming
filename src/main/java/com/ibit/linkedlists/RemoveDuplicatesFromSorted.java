package com.ibit.linkedlists;

public class RemoveDuplicatesFromSorted {

	public static ListNode deleteDuplicates(ListNode A) {
		if(A==null)
			return null;
		ListNode ptr1=A;
		ListNode ptr2=A.next;

		while(ptr2!=null) {
			if(ptr1.val==ptr2.val) { //do this until duplicates are removed
				ptr1.next=ptr2.next;
				ptr2=ptr2.next;
			}else {
				ptr1=ptr2;
				ptr2=ptr2.next;
			}
		}
		return A;
	}

	public static void display(ListNode A) {
		ListNode ptr=A;
		while(ptr!=null) {
			System.out.print(ptr.val+"->");
			ptr=ptr.next;
		}
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node=head;
		for(int i=2;i<=10;i++) {
			node.next=new ListNode(i);
			node=node.next;
			node.next=new ListNode(i);
			node=node.next;
		}		
		display(head);
		deleteDuplicates(head);
		System.out.println("\n");
		display(head);
	}
}

class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; next = null; }
}
