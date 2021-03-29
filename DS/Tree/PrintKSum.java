import java.util.ArrayList;

public class PrintKSum {

    static ArrayList<Integer> path;

    public static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    public static void printKPathUtil(Node root, int k) {

        if (root == null)
            return;

        path.add(root.data);

        printKPathUtil(root.left, k);

        printKPathUtil(root.right, k);

        int f = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            f += path.get(i);

            if (f == k) {
                printKSums(i);
            }
        }

        if (!path.isEmpty())
            path.remove(path.size() - 1);


    }

    public static void printKSums(int j) {

        for (int i = j; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void printKPath(Node node, int k) {
        path = new ArrayList<>();
        printKPathUtil(node, k);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 5;
        printKPath(root, k);
    }

}
