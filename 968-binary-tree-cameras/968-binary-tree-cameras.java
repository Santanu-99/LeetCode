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
    public int minCameraCover(TreeNode root) {
        
        if(root.left == null && root.right == null){
            return 1;
        }
        
        int rootSt = cameraHelper(root);
        if(rootSt == 0){
            cameraCount++;
        }
        return cameraCount;
        
    }
    
//     keeps req camera count
    int cameraCount = 0;
    
//     2-> camera ,1 -> monitored  , 0 -> unmonitored
    public int cameraHelper(TreeNode root){
        
//         consider null is always monitored (Since not a part of tree)
        if(root == null){
            return 1;
        }
        
//         fetching state of left and right children
        int leftSt = cameraHelper(root.left);
        int rightSt = cameraHelper(root.right);
        
//         if either of children is unmonitored set a camera
        if(leftSt == 0 || rightSt == 0){
            cameraCount++;
            return 2;
        }
        
//         if both the children are monitored then set no camera
//         And return appropriate status of the node
        return Math.max(leftSt,rightSt) - 1;
    }
}