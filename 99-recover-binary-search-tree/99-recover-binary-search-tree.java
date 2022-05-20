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
    
    
    
    
    public void recoverTree(TreeNode root) {
        TreeNode prev,curr,n1,n2;
        prev = n1 = n2 = null;
        curr = root;
        
        
        while(curr!= null){
            if(curr.left == null){
//                 print
                if(prev != null && prev.val > curr.val){
                    if(n1 == null){
                        n1 = prev;
                        n2 = curr;
                    }else{
                        n2 = curr;
                    }
                }
                prev = curr;
                curr = curr.right;
            }
            else{
                TreeNode iop = getInorderPredecessor(curr);
                if(iop.right == null){
                    iop.right = curr;
                    curr = curr.left;
                }else{
//                     print
                    if(prev != null && prev.val > curr.val){
                        if(n1 == null){
                            n1 = prev;
                            n2 = curr;
                        }else{
                            n2 = curr;
                        }
                    }
                    iop.right = null;
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
        

    }
}