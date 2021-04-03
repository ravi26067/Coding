import java.util.LinkedList;
import java.util.Queue;

/**
 * Approach is similar to convert list to BST
 */

class Node {
    int data;
    Node next, prev;

    Node(int d) {
        data = d;
        next = prev = null;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int data) {
        val = data;
        left = right = null;
    }
}

class DoublyLL {

    Node head;

    void pushNode(int num) {

        Node new_node = new Node(num);

        new_node.prev = null;
        new_node.next = head;

        if (head != null)
            head.prev = new_node;

        head = new_node;

        return;
    }

    void printNode() {
        Node node = head;
        //System.out.println("Printing DLL");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    private TreeNode createBSTRec(Node head1){


        if(head1==null)
            return null;

        Node mid = findMid(head1);

        TreeNode root = new TreeNode(mid.data);
        if(mid == head1)
            return root;

        root.left = createBSTRec(head1);
        root.right = createBSTRec(mid.next);

        return root;

    }

    public TreeNode createBST(){
        return createBSTRec(head);
    }

    public Node findMid(Node head1){
        Node slow = head1;
        Node fast = head1;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = slow.prev;
        slow.prev = null;
        if(prev!=null)
            prev.next=null;

        return slow;
    }


    public void printBST(TreeNode root){
        Queue<TreeNode > queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                System.out.println();
                if(queue.isEmpty())
                    return;
                queue.add(null);
            }else {
                System.out.print(node.val + " ");
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();
        ll.pushNode(7);
        ll.pushNode(6);
        ll.pushNode(5);
        ll.pushNode(4);
        ll.pushNode(3);
        ll.pushNode(2);
        ll.pushNode(1);

        ll.printNode();

        TreeNode root = ll.createBST();

        ll.printBST(root);

    }
}
