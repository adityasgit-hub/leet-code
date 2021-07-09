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
    public void flatten(TreeNode root) {
        flattenRoot(root);
    }
    
    public TreeNode flattenRoot(TreeNode root) {
        if(root==null) 
            return null;
        if(root != null) {
            TreeNode rootLeft = flattenRoot(root.left);
            flattenRoot(root.right);

            if(root.left !=null) {
                rootLeft.right = root.right;
            }
            root.right = null != root.left? root.left : root.right;
            root.left = null;

        }
        
        while(root !=null) {
            if(root.right == null) {
                return root;
            }
            root = root.right;
        }
        return root;
        
    }
}