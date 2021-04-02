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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //printLL(head);
        if(head==null)
            return null;
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        if(mid==head)
            return root;
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        
        //printLL(head);
        return root;
    }
    
    private ListNode findMid(ListNode head){
        ListNode fst = head;
        ListNode slw = head;
        ListNode prv = head;
        
        while(fst!=null && fst.next!=null){
            prv = slw;
            slw = slw.next;
            fst = fst.next.next;
        }
        if(prv!=null)
            prv.next = null;
        return slw;
        
    }
    
    
    private void printLL(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
}
