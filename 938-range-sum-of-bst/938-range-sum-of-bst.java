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
    public int rangeSumBST(TreeNode root, int low, int high) {
        
         if(root == null){
            return 0;
        }
        
        
        int myAns=0; 
        
        if(low <= root.val && root.val <= high){
            int recSum = rangeSumBST(root.left,low,high);
            recSum += rangeSumBST(root.right,low,high);
            myAns = recSum + root.val;
        }
        else if(high < root.val){
            myAns= rangeSumBST(root.left,low,high);
        }
        else if(root.val < low){
            myAns = rangeSumBST(root.right,low,high);
        }
        
        return myAns;
    }
}