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
    
    public class Pair{
        int s,b;
        Pair(){};
        Pair(int s,int b){
            this.s = s;
            this.b = b;
        }
    }
    
    public int max(int... arr){
        int m = (int)-1e9;
        for(int ele: arr){
            if(ele > m){
                m = ele;
            }
        }
        return m;
    }  
    
    public int maxPathSum(TreeNode root) {   
        Pair ans = getAnsPair(root);
        return ans.s;
    }
    
    public Pair getAnsPair(TreeNode node){
        if(node == null){
            return new Pair((int)-1e9,0);
        }
        
        Pair leftPair = getAnsPair(node.left);
        Pair rightPair = getAnsPair(node.right);
        
        int maxBranch = node.val + max(leftPair.b,rightPair.b,0);
        
        int currSubtree = node.val + max(leftPair.b,0) + max(rightPair.b,0);
        int maxSubtree = max(currSubtree,leftPair.s,rightPair.s);
        
        return new Pair(maxSubtree,maxBranch);
    }
}