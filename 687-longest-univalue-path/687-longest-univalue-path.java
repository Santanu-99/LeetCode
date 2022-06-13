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
    int maxPath;
    public int longestUnivaluePath(TreeNode root) {
        maxPath=0;
        getLongestUniValuePath(root,-1);
        if(maxPath == 0){
            return 0;
        }
        return --maxPath;
    }
    
    public int getLongestUniValuePath(TreeNode node,int val){
        
        if(node == null){
            return 0;
        }
        
        int lPath = getLongestUniValuePath(node.left,node.val);
        int rPath = getLongestUniValuePath(node.right,node.val);
        
        int path = lPath + rPath + 1;
        if(maxPath < path){
            maxPath = path;
        }
        
        if(node.val == val){   
            return 1+Math.max(lPath,rPath);
        }else{
            return 0;
        }
    }
}