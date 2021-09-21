/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (checkDescendant(root, p))
            if (checkDescendant(p, q))
                return p;
        
        if (checkDescendant(root, q))
            if (checkDescendant(q, p))
                return q;
        
        if ((checkDescendant(root.left, p) && checkDescendant(root.right, q)) 
            || (checkDescendant(root.left, q) && checkDescendant(root.right, p)))
            return root;
        
        if (checkDescendant(root.left, p) && checkDescendant(root.left, q))
            return lowestCommonAncestor(root.left, p, q);
        
        if (checkDescendant(root.right, p) && checkDescendant(root.right, q))
            return lowestCommonAncestor(root.right, p, q);
        
        return null;
    }
    
    private boolean checkDescendant(TreeNode root, TreeNode node) {
        if (root == null)
            return false;
        
        if (root.val == node.val)
            return true;
        
        return checkDescendant(root.left, node) || checkDescendant(root.right, node);
    }
}