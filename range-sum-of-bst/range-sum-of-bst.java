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
    private int sum;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        sumBST(root, low, high);
        return sum;
    }
    
    private void sumBST(TreeNode node, int low, int high) {
        if (node == null)
            return;
        
        if (node.val >= low && node.val <= high)
            sum += node.val;
        
        if (node.val > low)
            sumBST(node.left, low, high);
        if (node.val < high)
            sumBST(node.right, low, high);
    }
}