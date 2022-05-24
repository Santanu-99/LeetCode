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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = construct(0,inorder.length-1,0,postorder.length-1,inorder,postorder);
        return root;
    }
    private int getInorderPos(int[] inorder,int val){
        int i=0; 
        while(inorder[i] != val){
            i++;    
        }
        return i;

    }
    
    private TreeNode construct(int lo_in,int hi_in,int lo_post,int hi_post,int[] inorder,int[] postorder){
        
        if(lo_in > hi_in){
            return null;
        }
        
        
        int pos_in = getInorderPos(inorder,postorder[hi_post]);
        int rNcount = hi_in - pos_in;
        
        TreeNode newNode = new TreeNode(postorder[hi_post]);
        
        
        
        newNode.left = construct(lo_in,pos_in-1,lo_post,hi_post-rNcount-1,inorder,postorder);
        newNode.right = construct(pos_in+1,hi_in,hi_post-rNcount,hi_post-1,inorder,postorder);
        
        return newNode;
    }
}