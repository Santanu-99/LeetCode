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
        helper(root,"");
        return sum;
    }
    int sum = 0;
    void helper(TreeNode root, String psf){
        if(root == null){
            return;
        }
        
        psf = psf + root.val;
        
        if(root.left == null && root.right == null){
            int leafNum = Integer.parseInt(psf);
            sum = sum + leafNum;
        }
        
        helper(root.left ,psf);
        helper(root.right , psf);
        
    }
}