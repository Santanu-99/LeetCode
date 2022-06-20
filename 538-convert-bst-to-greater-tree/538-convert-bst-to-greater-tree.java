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
    public TreeNode convertBST(TreeNode root) {
        helper(root,0);
        return root;
    }
    
    int helper(TreeNode node,int sum){
        if(node == null){
            return sum;
        }
        int rightSum = helper(node.right,sum);
        int mySum = rightSum + node.val;
        node.val = mySum;
        int leftSum = helper(node.left, mySum);
        
        return leftSum;
    }
}