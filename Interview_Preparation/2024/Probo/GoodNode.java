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
    // Method to count the number of good nodes in the binary tree
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE; // Initialize max to the minimum integer value
        
        int res[] = new int[1]; // Array to store the result (number of good nodes)
        res[0] = 0; // Initialize the result to 0
        
        // Call the helper function to perform DFS traversal and count good nodes
        return goodNodesDFS(root, max, res);
    }

    // Recursive helper function to perform DFS traversal and count good nodes
    public int goodNodesDFS(TreeNode root, int max, int[] res) {
        // Base case: if the current node is null, return 0 (no good nodes)
        if (root == null) {
            return 0;
        }
        
        // If the value of the current node is greater than or equal to the max value encountered so far,
        // it is a good node, so increment the result count and update the max value
        if (root.val >= max) {
            res[0]++; // Increment the count of good nodes
            max = root.val; // Update the max value
        }
        
        // Recursively traverse the left and right subtrees
        // Note: We don't need to update the result count here since we're passing the count by reference
        goodNodesDFS(root.left, max, res); // DFS traversal on the left subtree
        goodNodesDFS(root.right, max, res); // DFS traversal on the right subtree
        
        // Return the final count of good nodes
        return res[0];
    }
}
