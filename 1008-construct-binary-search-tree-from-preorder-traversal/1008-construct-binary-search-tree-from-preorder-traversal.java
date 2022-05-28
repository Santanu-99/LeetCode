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
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = helper(Integer.MIN_VALUE, Integer.MAX_VALUE,preorder);
        return root;
    }
    
    public TreeNode helper( int low, int high, int[] preorder){
        
        if(idx == preorder.length){
            return null;
        }
        
        int val = preorder[idx];
        TreeNode node = null;
        if( low<val && val<high ){
            node = new TreeNode(val);
        }else{
            return null;
        }
        idx++;
        node.left = helper(low,val,preorder);
        node.right = helper(val,high,preorder);
        return node;
    }
}