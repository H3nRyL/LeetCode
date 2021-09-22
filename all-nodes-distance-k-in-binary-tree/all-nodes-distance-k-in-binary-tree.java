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
    private List<Integer> result = new ArrayList<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findNode(root, target, k);
        return result;
    }
    
    private int findNode(TreeNode node, TreeNode target, int k) {
        if (node == null)
            return -1;
        
        if (node == target) {
            findNodeDown(node, k);
            return 0;
        }
        
        int left = findNode(node.left, target, k);     
        if (left != -1) {
            if (left + 1 == k)
                result.add(node.val);
            else
                findNodeDown(node.right, k - left - 2);
            
            return left + 1;
        }
        
        int right = findNode(node.right, target, k);
        if (right != -1) {
            if (right + 1 == k)
                result.add(node.val);
            else 
                findNodeDown(node.left, k - right - 2);
            
            return right + 1;
        }
        
        return -1;
    }
    
    private void findNodeDown(TreeNode node, int k) {
        if (node == null || k < 0)
            return;
        
        if (k == 0) {
            result.add(node.val);
            return;
        }
        
        findNodeDown(node.left, k - 1);
        findNodeDown(node.right, k - 1);
    }
}