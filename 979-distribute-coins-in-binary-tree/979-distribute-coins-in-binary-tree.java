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
    class Pair{
        int nCount , cCount;
        Pair(){}
        
        Pair(int nCount, int cCount){
            this.nCount = nCount;
            this.cCount = cCount;
        }
    }
    
    int count=0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return count;
    }
    
    public Pair helper(TreeNode node){
        if(node == null){
            return new Pair(0,0);
        }
        
        Pair leftPair = helper(node.left);
        Pair rightPair = helper(node.right);
        
        int totNodes = 1 + leftPair.nCount + rightPair.nCount;
        int totCoins = node.val + leftPair.cCount + rightPair.cCount;
        
        count += Math.abs(totNodes - totCoins);
        
        Pair myPair = new Pair(totNodes , totCoins);
        return myPair;
    }
}