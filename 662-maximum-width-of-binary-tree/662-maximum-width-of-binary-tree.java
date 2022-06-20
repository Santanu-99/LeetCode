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
    class Pair{
        int min,max;
        Pair(){}
        Pair(int min ,int max){
            this.min = min;
            this.max = max;
        }
        
        public String toString(){
            return "minI@"+min+":maxI@"+max;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer,Pair> hm = new HashMap<>();
        helper(root,hm,0,0);
        
        int maxD = 0;
        int lvl = 0;
        // System.out.println(hm);
        while(hm.containsKey(lvl)){
            Pair lp = hm.get(lvl);
            int d = lp.max - lp.min + 1;
            if(maxD < d){
                maxD = d;
            }
            
            
            lvl++;
        }
        
        return maxD;
    }
    
    public void helper(TreeNode root , HashMap<Integer,Pair> hm , int lvl ,int idx){
        if(root == null){
            return;
        }
        Pair mp = new Pair(idx,idx);
        if(hm.containsKey(lvl)){
           Pair p = hm.get(lvl);
            mp.min = p.min;
            mp.max = idx;
        }
        hm.put(lvl,mp);
        
        helper(root.left,hm,lvl+1,idx*2+1);
        helper(root.right,hm,lvl+1,idx*2+2);
    }
}