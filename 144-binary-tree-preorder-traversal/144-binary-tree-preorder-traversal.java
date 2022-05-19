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
    
     private TreeNode getInorderPredecessor(TreeNode node){
        
        TreeNode iop = node.left;
        while( iop.right != null && iop.right != node){
            iop = iop.right;
        }
        return iop;
    }
    
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> retVal = new ArrayList<>();
        
        TreeNode curr = root;
        while(curr!= null){
            if(curr.left == null){
                retVal.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode iop = getInorderPredecessor(curr);
                
                if(iop.right == null){
                    retVal.add(curr.val);
                    iop.right = curr;
                    curr = curr.left;
                }else{
                    iop.right = null;
                  
                    curr = curr.right;
                    
                }
                                

            }
        }
        
        return retVal;
    }
}