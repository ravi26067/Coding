class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) 
            return;
        
        ListNode slow = head, fast = slow.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Stack<ListNode> stack = new Stack();
        ListNode current = slow.next;
        slow.next = null;
        while(current != null) {
            stack.push(current);
            current = current.next;
        }

        current = head;
        while(stack.size() > 0) {
            stack.peek().next = current.next;
            current.next = stack.pop();
            current = current.next.next;
        }
    }
}
