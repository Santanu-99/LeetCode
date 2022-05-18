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
    
    private TreeNode getNode(TreeNode node,int x){
        if(node == null){
            return null;
        }
        
        if(node.val == x){
            return node;
        }
        
        TreeNode fLeft = getNode(node.left,x);
        TreeNode fRight = getNode(node.right,x);
        
        TreeNode myAns;
        if(fLeft != null){
            myAns = fLeft;
        }else{
            myAns = fRight;
        }
        
        return myAns;
    }
    
    
    private int sizeOfTree(TreeNode node){
        
        if(node == null){
            return 0;
        }
        
        int ls = sizeOfTree(node.left);
        int rs = sizeOfTree(node.right);
        
        int mySize = ls+ rs+ 1;
        return mySize;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode target = getNode(root,x);
        int lSubTree = sizeOfTree(target.left);
        int rSubTree = sizeOfTree(target.right);
        
        int totTree = sizeOfTree(root);
        int rest = totTree - (lSubTree + rSubTree + 1);
        int max = Math.max(rest,Math.max(lSubTree,rSubTree));
        
        boolean ans;
        if(max > totTree-max){
            ans = true;
        }else{
            ans = false;
        }
        return ans;
    }
}