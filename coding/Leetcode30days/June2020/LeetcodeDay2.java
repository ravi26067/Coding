/**
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        if(node.next==null)
            node = node.next;
        else{
            node.val = node.next.val;
            node.next = node.next.next;
        }
        
    }
}