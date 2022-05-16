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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> retVal = new LinkedList<>();
        if(root == null){
            return retVal;
        }
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        while(qu.size() != 0){
            int Lsize = qu.size();
            for(int i=1;i<=Lsize;i++){
                TreeNode rem = qu.remove();
                
                if(i==Lsize){
                    retVal.add(rem.val);
                }
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
        }
        return retVal;
    }
}