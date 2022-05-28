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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        hm.put(0,1);
        findPathSum(root,targetSum,0,hm);
        return count;
    }
    
    public void findPathSum(TreeNode node, int targetSum, int sum, HashMap<Integer,Integer> hm){
        if(node == null){
            return;
        }
        
//         checking if there is a path from current node which can be equals to target
        int currSum = sum + node.val;
        if( hm.containsKey( currSum - targetSum ) ){
            count += hm.get(currSum - targetSum);
        }
        hm.put(currSum, hm.getOrDefault(currSum,0) + 1);
        
        
//         Ṭraversal
        findPathSum(node.left, targetSum, currSum, hm);
        findPathSum(node.right, targetSum, currSum, hm);
        
//         removing currSum from hm while backtracking
        if(hm.get(currSum) == 1){
            hm.remove(currSum);
        }else{
            hm.put( currSum, hm.get(currSum)-1 );
        }
    }
}