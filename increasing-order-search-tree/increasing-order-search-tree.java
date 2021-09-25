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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> value = new ArrayList<>();
        inOrder(root, value);
        
        TreeNode result = new TreeNode(0);
        TreeNode curr = result;
        
        for (Integer v : value) {
            curr.right = new TreeNode(v);
            curr = curr.right;
        }
        
        return result.right;
    }
    
    private void inOrder(TreeNode node, List<Integer> value) {
        if (node == null)
            return;
        
        inOrder(node.left, value);
        value.add(node.val);
        inOrder(node.right, value);
    }
}