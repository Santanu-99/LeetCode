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
        TreeNode head,tail;
        Pair(){}
        Pair(TreeNode head,TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    
    public void flatten(TreeNode root) {
        helper(root);
        
    }
    
    public Pair helper(TreeNode node){
        if(node == null){
            return null;
        }
        
        
        
        if(node.left != null && node.right != null){
            Pair lPair= helper(node.left);
            Pair rPair= helper(node.right);
           
            lPair.tail.right = node.right;
            node.right = lPair.head;
            node.left = null;
            Pair myPair = new Pair(node,rPair.tail);
            return myPair;
        }else if(node.left == null && node.right == null){
            Pair myPair = new Pair(node,node);
            return myPair;
        }
        else if(node.left != null){
            Pair lPair= helper(node.left);
            node.right = lPair.head;
            node.left = null;
            Pair myPair = new Pair(node,lPair.tail);
            return myPair;
        }else{
            Pair rPair= helper(node.right);
            Pair myPair = new Pair(node,rPair.tail);
            return myPair;
        }
               
        
    }
}