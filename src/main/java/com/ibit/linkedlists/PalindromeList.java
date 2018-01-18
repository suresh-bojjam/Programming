package com.ibit.linkedlists;

public class PalindromeList {


	public static void main(String args[]) {
		test();
	}
	
	public static void test() {
		ListNode A=new ListNode(1);
		ListNode temp1=A;
		ListNode temp2=null;
		
		for(int i=2;i<=10;i++) {
			temp2=new ListNode(i);
			temp1.setNext(temp2);
			temp1=temp2;
		}
		print(A);
		reverseLinkedList(A);
		print(A);
	}
	
	public static void reverseLinkedList(ListNode A) {
		ListNode currentNode=null,prevNode=null,nextNode=null;
		currentNode=A;
		nextNode=currentNode;
		while(currentNode.next!=null) {
			prevNode=currentNode;
			prevNode.next=nextNode;
			currentNode=currentNode.next;
			nextNode=currentNode.next;
			currentNode.next=prevNode;
		}
	}
	
	public static void print(ListNode A) {
		
		if(A==null)
			return;
		do {
			System.out.print(A.val+", ");
			A=A.next;
		}while(A!=null);
	}
	
	public int lPalinMethod1(ListNode A) {
		
		return 0;
	}
	
	static class ListNode {
		public int val;
		public ListNode next;
		
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public ListNode getNext() {
			return next;
		}
		public void setNext(ListNode next) {
			this.next = next;
		}
		ListNode(int x) { val = x; next = null; }
	}
}
