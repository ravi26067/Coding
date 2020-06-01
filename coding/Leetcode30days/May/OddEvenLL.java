import java.util.Scanner;

import javax.swing.tree.TreeNode;

// 5 9 -6 9 -5 7 8
// 9 -5 7 8 5 9 -6

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class OddEvenLL {

	public ListNode oddEvenList(ListNode head) {
		
		ListNode head2 = null,head3 = null;
		
		ListNode head1 = head;
		
		if(head==null)
			return head;
		
		if(head.next!=null) {
			head2 = head.next;
			head3 = head.next;
		}
		
		while(head1.next != null && head1.next.next!=null) {
			ListNode temp = head1.next;
			head1.next = temp.next;
			head1 = head1.next;
			head3.next = temp.next.next;
			head3 = head3.next;
		}
		head1.next = head2;
		
		return head;
	}

	public static void main(String[] args) {

		OddEvenLL ps = new OddEvenLL();
		ListNode head;
		ListNode tail;
		int val = 0;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			head = null;
			tail = null;
			while (true) {
				val = sc.nextInt();
				if (val == -1) {
					break;
				}

				ListNode temp = new ListNode(val);
				if (tail == null) {
					tail = temp;
					head = temp;
				} else {
					tail.next = temp;
					tail = tail.next;
				}

			}

			tail = head;
			while (tail != null) {
				System.out.print(tail.val + "-> ");
				tail = tail.next;
			}
			System.out.print(null + "\n");
			
			tail = ps.oddEvenList(head);
			while (tail != null) {
				System.out.print(tail.val + "-> ");
				tail = tail.next;
			}
			System.out.print(null + "\n");
			
			t--;
		}
	}
}
