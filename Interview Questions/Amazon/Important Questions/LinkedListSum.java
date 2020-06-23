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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        int carry  = 0;
        while(l1!=null || l2!=null){
            int sum = 0;
            
            if(l1==null){
                sum = l2.val + carry;
                l2 = l2.next;
            }
            else if(l2==null){
                sum = l1.val + carry;
                l1 = l1.next;
            }
            else{
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            System.out.print(sum);
            
            l3.next = new ListNode(sum%10);
            
            carry = sum/10;
            
            l3 = l3.next;
        }
        if(carry>0)
        {
            l3.next = new ListNode(carry);
        }
        
        
        
        
        return head.next;
    }
}