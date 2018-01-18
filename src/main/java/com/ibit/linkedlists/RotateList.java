package com.ibit.linkedlists;

public class RotateList {

	public static ListNode rotateList(ListNode head,int kposition) {
		int position=getSizeOfTheList(head)-kposition;
		position=position+1;

		//break the relation
		ListNode prev=null,current=null;
		current=head;
		int count=0;
		while(current!=null && count!=position) {
			count++;
			if(count!=position) {
				prev=current;
				current=current.next;	
			}
		}			
		prev.next=null;
		ListNode temp=current;

		//add the second list to head position	
		while(temp.next!=null) temp=temp.next;
		//merge the lists
		temp.next=head;

		return current;
	}

	public static void display(ListNode A) {
		ListNode ptr=A;
		while(ptr!=null) {
			System.out.print(ptr.val+"->");
			ptr=ptr.next;
		}
	}

	public static int getSizeOfTheList(ListNode head) {
		int count=0;
		while(head!=null) {
			++count;
			head=head.next;
		}
		return count;
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node=head;
		for(int i=2;i<=10;i++) {
			node.next=new ListNode(i);
			node=node.next;
		}		
		display(head);
		System.out.println("\n");
		//head=rotateList(head,2);
		//display(head);
		display(rotateList(head,4));
	}
}

