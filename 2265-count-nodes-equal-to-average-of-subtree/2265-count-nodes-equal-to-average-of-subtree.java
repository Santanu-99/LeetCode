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
     int sum , count,  avgCount;
        Pair(){}
        
        Pair(int sum , int count,int avgCount){
            this.sum = sum ; 
            this.count = count;
            this.avgCount = avgCount;
        }
    }
    private Pair getAverageCount(TreeNode root){
        
        if(root == null){
            return new Pair();
        }
        
        
        
        Pair left = getAverageCount(root.left);
        Pair right = getAverageCount(root.right);
        
        int total_sum = left.sum + right.sum + root.val;
        int total_nodes = left.count + right.count + 1;
        int average = total_sum / total_nodes;
        
        Pair myPair = new Pair(total_sum,total_nodes,left.avgCount + right.avgCount);
        if(average == root.val){
            myPair.avgCount += 1;
        }
        
        return myPair;
    }
    public int averageOfSubtree(TreeNode root) {
        Pair myPair= getAverageCount(root);
        return myPair.avgCount;
    }
}