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
    public int sumNumbers(TreeNode root) {
        
        helper(root,0);
        return sum;
    }
    int sum = 0;
    void helper(TreeNode root, int nsf){
        if(root == null){
            return;
        }
        
        nsf = nsf*10 + root.val ;
        
        if(root.left == null && root.right == null){
            sum = sum + nsf;
        }
        
        helper(root.left ,nsf);
        helper(root.right , nsf);
        
        
    }
}