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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key) { // key < root.val check in left sub-tree
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) { // key > then root.val check in right sub-tree
            root.right = deleteNode(root.right, key);
        } else { // key == root.val we found nodes need to delete
            if (root.left == null) { 
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.val = successor(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int successor(TreeNode root) {
        return root.left == null ? root.val : successor(root.left);
    }
}
