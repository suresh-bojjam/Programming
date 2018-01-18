package com.ibit.linkedlists;

public class MergeTwoSortedLists {

	/**
	 * Method merge the two list by inserting the second list elements into first list in a sorted order
	 * we should not create the new LinkedList
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode MergeListMethod2(ListNode head1, ListNode head2) {
		return null;
	}
	
	
	/**
	 * Method merge the two list by creating the new list
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode MergeList(ListNode head1, ListNode head2) {
		ListNode head=new ListNode(0);
		ListNode ptr1=head1;
		ListNode ptr2=head2;
		ListNode ptr3=null;


		if(ptr1.val<=ptr2.val) {
			head.val=ptr1.val;
			ptr1=ptr1.next;
		}else {
			head.val=ptr2.val;
			ptr2=ptr2.next;
		}
		
		ptr3=head;

		ListNode node;
		for(;ptr1!=null&&ptr2!=null;) {
			if(ptr1.val<=ptr2.val) {
				node=new ListNode(ptr1.val);
				ptr1=ptr1.next;
			}else {
				node=new ListNode(ptr2.val);
				ptr2=ptr2.next;
			}
			ptr3.next=node;
			ptr3=ptr3.next;	
		}

		if(ptr1!=null) {
			while(ptr1!=null) {
				insertInSortedList(head,ptr1.val);
				ptr1=ptr1.next;
			}
		}

		if(ptr2!=null) {
			while(ptr2!=null) {
				insertInSortedList(head,ptr2.val);
				ptr2=ptr2.next;
			}
		}		
		return head;
	}


	public static boolean insertInSortedList(ListNode head,int x) {

		ListNode current;
		ListNode new_node=new ListNode(x);

		/* Special case for head node */
		if (head == null || head.val >= new_node.val)
		{
			new_node.next = head;
			head = new_node;
		}
		else {
			/* Locate the node before point of insertion. */
			current = head;

			while (current.next != null &&
					current.next.val < new_node.val)
				current = current.next;

			new_node.next = current.next;
			current.next = new_node;
		}
		return false;
	}		


	public static void display(ListNode A) {
		ListNode ptr=A;
		while(ptr!=null) {
			System.out.print(ptr.val+"->");
			ptr=ptr.next;
		}
	}

	public static void main(String[] args) {
		ListNode head1=new ListNode(1);
		ListNode node=head1;
		for(int i=2;i<=5;i++) {
			node.next=new ListNode(i);
			node=node.next;
		}

		ListNode head2=new ListNode(6);
		node=head2;
		for(int i=7;i<=10;i++) {
			node.next=new ListNode(i);
			node=node.next;
		}

		display(head1);
		System.out.println("\n");
		display(head2);
		System.out.println("--after merge\n");
		display(MergeList(head1,head2));
	}
}