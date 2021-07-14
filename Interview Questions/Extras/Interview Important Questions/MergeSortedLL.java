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
    public ListNode mergeKLists(ListNode[] lists) {
        TreeMap<Integer,Integer> mp = new TreeMap();
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp!=null){
                if(mp.containsKey(temp.val)){
                    mp.put(temp.val,mp.get(temp.val)+1);
                }else{
                    mp.put(temp.val,1);
                }
                temp = temp.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode l1 = head;
        for(Map.Entry<Integer,Integer> et : mp.entrySet()){
            int val = et.getValue();
            while(val-->0){
                l1.next = new ListNode(et.getKey());
                l1 = l1.next;
            }
        }
        return head.next;
    }
}