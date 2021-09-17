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
    public int goodNodes(TreeNode root) {
        int max = root.val;        
        return checkGood(root.left, max) + checkGood(root.right, max) + 1;
    }
    
    private int checkGood(TreeNode node, int max) {
        if (node == null)
            return 0;
        
        if (node.val < max)
            return checkGood(node.left, max) + checkGood(node.right, max);
        else {
            max = node.val;
            return checkGood(node.left, max) + checkGood(node.right, max) + 1;
        }
    }
}