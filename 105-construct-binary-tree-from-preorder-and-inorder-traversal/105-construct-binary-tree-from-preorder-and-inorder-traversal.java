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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = construct(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
        return root;
    }
    private int getInorderPos(int[] inorder,int val){
        int i=0; 
        while(inorder[i] != val){
            i++;    
        }
        return i;

    }
    private TreeNode construct(int lo_pre,int hi_pre,int lo_in,int hi_in,int[] preorder,int[] inorder){
        if(lo_in>hi_in){
            return null;
        }
        
        int pos_pre = lo_pre;
        int pos_in = getInorderPos(inorder,preorder[pos_pre]);
        
        int lNcount = pos_in - lo_in;
        
        TreeNode node = new TreeNode(preorder[pos_pre]);
        node.left = construct(lo_pre +1 , lo_pre + lNcount , lo_in, pos_in-1 , preorder,inorder );
        node.right = construct(lo_pre+lNcount +1,hi_pre,pos_in +1, hi_in,preorder,inorder);
        
        return node ;
    }
}