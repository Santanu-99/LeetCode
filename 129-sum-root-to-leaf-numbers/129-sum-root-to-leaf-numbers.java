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
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return sum;
    }
    int sum = 0;
    void helper(TreeNode root, StringBuilder psf){
        if(root == null){
            return;
        }
        
        psf = psf.append(root.val);
        
        if(root.left == null && root.right == null){
            int leafNum = Integer.parseInt(psf.toString());
            sum = sum + leafNum;
        }
        
        helper(root.left ,psf);
        helper(root.right , psf);
        
        psf.deleteCharAt(psf.length()-1);
        
    }
}