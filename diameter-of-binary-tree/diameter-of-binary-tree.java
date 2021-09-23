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
    private int diameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        diameter(root);
        return diameter;
    }
    
    private int diameter(TreeNode node) {
        if (node == null)
            return 0;
        
        int left = diameter(node.left);
        int right = diameter(node.right);
        diameter = Math.max(diameter, left + right);
        
        return Math.max(left, right) + 1;
    }
}