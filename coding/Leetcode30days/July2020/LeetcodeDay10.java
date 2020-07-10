class Solution {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node current = head;
        while (current != null || !stack.isEmpty()) {
            if (current.child != null) {
                if (current.next != null) stack.push(current.next);
                current.next = current.child;
                current.next.prev = current;
                current.child = null;
            } else {
                if (current.next == null && !stack.isEmpty()) {
                    current.next = stack.pop();
                    current.next.prev = current;
                }
            }
            current = current.next;
        }
        return head;
    }
}