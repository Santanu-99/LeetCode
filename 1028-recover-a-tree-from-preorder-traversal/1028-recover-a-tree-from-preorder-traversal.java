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
    int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        if(traversal.length() == 0){
            return null;
        }
        
        i = 0;
        TreeNode root = helper(traversal,0);
        return root;
    }
    
    public TreeNode helper(String traversal , int depth){
        int d=0;
        while( i+d < traversal.length() &&  traversal.charAt(i+d) == '-'){
            d++;
        }
        int nd = 0;
        while(i+d+nd < traversal.length() && traversal.charAt(i+d+nd) != '-'){
            nd++;
        }
        
        if(d<depth){
            return null;
        }
        int val = Integer.parseInt(traversal.substring(i+d,i+d+nd));
        i = i+d+nd;
        TreeNode node = new TreeNode(val);
        node.left = helper(traversal,depth+1);
        node.right = helper(traversal,depth+1);
        
        return node;
        
    }
}