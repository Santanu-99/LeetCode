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
    private int leftHeight(TreeNode node){
        int count =0;
        while(node != null){
            node = node.left;
            count++;
        }
        return count;
    }
    private int rightHeight(TreeNode node){
        int count =0;
        while(node != null){
            node = node.right;
            count++;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int lh = leftHeight(root.left);
        int rh = rightHeight(root.right);
        
        int leftNCount=0 , rightNCount=0;
        if(lh == rh){
            leftNCount = rightNCount = (1 << lh) - 1;
        }
        else{
            leftNCount = countNodes(root.left);
            rightNCount = countNodes(root.right);
        }
        
        int count = leftNCount+rightNCount+1;
        return count;

    }
}