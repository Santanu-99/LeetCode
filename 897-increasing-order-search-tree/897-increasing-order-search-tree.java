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
    private class Pair{
        TreeNode start;
        TreeNode end;
        
        Pair(){}
        
        Pair(TreeNode start , TreeNode end){
            this.start = start;
            this.end = end;
        }
    }
    
    private Pair getPair(TreeNode node){
        if(node == null){
            return null;
        }
        
        Pair leftPair = getPair(node.left);
        Pair rightPair = getPair(node.right);        
        
        Pair myPair = new Pair();
        
        // Tree Adjustment
        if(leftPair != null && rightPair != null){
            leftPair.end.right = node;
            node.left = null;
            node.right = rightPair.start;

            // MyPair creation
            myPair.start = leftPair.start;
            myPair.end = rightPair.end;    
        }
        
        else if(leftPair != null){
            leftPair.end.right = node;
            node.left = null;

            // MyPair creation
            myPair.start = leftPair.start;
            myPair.end = node; 
        }
        else if(rightPair != null){
            node.left = null;
            node.right = rightPair.start;
            
            // MyPair creation
            myPair.start = node;
            myPair.end = rightPair.end;  
        }else{
            myPair.start = node;
            myPair.end = node;
        }
        
        return myPair;

    }
    
    public TreeNode increasingBST(TreeNode root) {
        Pair ans = getPair(root);
        
        return ans.start;
    }
}