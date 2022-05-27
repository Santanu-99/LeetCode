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
    
    public int max(int... arr){
        int m = (int)-1e9;
        for(int ele: arr){
            if(ele > m){
                m = ele;
            }
        }
        return m;
    }
    
    public int nodeToRoot(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int leftBranch = nodeToRoot(node.left);
        int rightBranch = nodeToRoot(node.right);
        
        int recAns = max(leftBranch,rightBranch,0);
        
        return node.val+recAns;
    }
    
    
    public int maxPathSum(TreeNode root) {
        
        if(root == null){
            return (int)-1e9;
        }
        
        
        int leftSubtree = maxPathSum(root.left);
        int rightSubtree = maxPathSum(root.right);
        
        int maxLeftBranch = nodeToRoot(root.left);
        int maxRightBranch = nodeToRoot(root.right);
        int currSubtree = Math.max(maxLeftBranch,0) + root.val + Math.max(maxRightBranch,0);
        
        return max(currSubtree,leftSubtree,rightSubtree);
    }
}