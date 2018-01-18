package com.ibit.linkedlists;

public class RemoveNthNodefromList {

/*
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
	
	public static ListNode removeNthFromEnd(ListNode A, int B) {
		int rem=0,position=0;
		
		//identify the location Or index of the Node to delete
		if(B>getSizeOfTheList(A)) {
			//delete the element
			return removeNthElement(A,1);
		}else {
			position=getSizeOfTheList(A)-B;
			System.out.println("position: "+position);
			//delete the element
			return removeNthElement(A,position+1);
			
/*			rem=B%getSizeOfTheList(A);
			System.out.println("rem: "+rem);
			position=getSizeOfTheList(A)-rem;
			System.out.println("position: "+position);
			//delete the element
			removeNthElement(A,position);*/
		}
	}
	
	
	public static ListNode removeNthElement(ListNode A,int position) {
		ListNode current=null,prev=null,next=null;
		
		if(position<=0)
			return null;
		if(position==1) {
			A=A.next;
			return A;
		}
		
		current=A;
		next=A.next;
		prev=A;
		
		int count=1;
		while(count!=position) {
			prev=current;
			current=next;
			next=next.next;
			++count;
		}
		//delete the i'th position element
		prev.next=current.next;
		return A;
	}

	public static int getSizeOfTheList(ListNode head) {
		int count=0;
		while(head!=null) {
			++count;
			head=head.next;
		}
		return count;
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
		for(int i=2;i<=10;i++) {
			node.next=new ListNode(i);
			node=node.next;
		}
		//display(removeNthElement(head1,1));
		display(removeNthFromEnd(head1,6));
	}
}