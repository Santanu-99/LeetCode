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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        
        TreeNode temp = root.left ;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        
        // if(root.left != null && root.right != null){
        //     int temp = root.left.val;
        //     root.left.val = root.right.val;
        //     root.right.val = temp;
        // }
        
        return root;
    }
}