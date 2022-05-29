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
    public boolean isValidBST(TreeNode root) {
        boolean ans = bstValidator(root,Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }
    
    private boolean bstValidator(TreeNode node, long low,long high){
        
        if(node == null){
            return true;
        }
        
        boolean ans = true;
        if(low < node.val && node.val < high){
            ans = true;
        }else{
            ans = false;
        }
        
        boolean left = bstValidator(node.left, low, node.val);
        boolean right = bstValidator(node.right, node.val , high);
        
        return ans && left && right; 
    }
}