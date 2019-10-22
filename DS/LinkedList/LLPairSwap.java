package com.datastructures;

public class LLPairSwap {

	Node head;
	
	
	//basic code
	
	class Node{
		int data;
		Node next;
		public Node(int val) {
			data = val;
			next = null;
		}
	}
	
	public void push(int val) {
		Node new_node = new Node(val);
		new_node.next = head;
		head = new_node;
	}
	
	public void printList() {
		Node curr = head;
		while(curr!=null) {
			System.out.print(curr.data+ " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	//logical methods
	
	public void pairwiseSwap() {
		Node curr = head;
		
		while(curr!=null && curr.next!=null) {
			int temp = curr.data;
			curr.data = curr.next.data;
			curr.next.data = temp;
			curr = curr.next.next;
		}
	}
	
	public static void main(String[] args) {
		LLPairSwap ll = new LLPairSwap();
		ll.push(12);
		ll.push(15);
		ll.push(9);
		ll.push(5);
		ll.push(45);
		ll.push(13);
		ll.push(10);
		ll.push(6);
		ll.printList();
		ll.pairwiseSwap();
		System.out.println("After swap");
		ll.printList();
	}

}
