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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        TreeNode leftMost = root;
        
        while(qu.size() > 0){
            int tempSize = qu.size();
            for(int i=0;i<tempSize;i++){
                TreeNode rem = qu.remove();
                
                if(i==0){
                    leftMost = rem;
                }
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
        }
        
        return leftMost.val;
    }
}