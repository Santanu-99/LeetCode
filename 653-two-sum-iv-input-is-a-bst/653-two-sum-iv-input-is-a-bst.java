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
    
    TreeNode root;
    public boolean isPresent(int k,int avoid){
        TreeNode temp = root;
        boolean ans = false;
        
        while(temp != null){
            if(temp.val == k && temp.val != avoid){
                ans = true;
                break;
            }
            else if(temp.val < k){
                temp = temp.right;
            }
            else{
                temp = temp.left;
            }
        }
        
        return ans;
    }
    public boolean getAns(TreeNode root, int k) {
        
        if(root == null){
            return false;
        }
        
        boolean myAns = isPresent(k-root.val,root.val);
        if(myAns){
            return myAns;
        }
        
        boolean leftAns = getAns(root.left,k);
        if(leftAns){
            return leftAns;
        }
        boolean rightAns = getAns(root.right,k);
        if(rightAns){
            return rightAns;
        }
        
        return false;
        
    }
    public boolean findTarget(TreeNode root, int k) {
        this.root = root;
        return getAns(root,k);
        
    }
    
}