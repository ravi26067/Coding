/**
Simple java solution.
Here we are using three pointers

* Prev
* Curr
* Next
We are using these pointers to remove the value which is present in linkedlist. We are also taking care of 
the case if our head node contain that value which should be deleted. Here is the simple efficient java code:

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        if (head == null)
            return head;
        next = head.next;
        while (curr != null) {
            if (curr.val == val) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                curr = curr.next;
                if (curr != null)
                    next = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
                if (curr != null)
                    next = curr.next;
            }
        }
        return head;
    }
}