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
    
    class Pair implements Comparable<Pair>{
        TreeNode node; int h,v;
        Pair(){}
        Pair(TreeNode node,int v, int h){
            this.node = node;
            this.v = v;
            this.h = h;
        }
        
        public int compareTo(Pair other){
            if(this.h == other.h){
                return this.node.val - other.node.val;
            }else{
                return this.h - other.h;
            }
        }
    }
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> retVal = new LinkedList<>();
        
        if(root == null){
            return retVal;
        }
        
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root,0,0));
        
        int lmv,rmv;
        lmv = rmv = 0;
        
        HashMap<Integer,List<Pair>> hm = new HashMap<>();
        
        while(qu.size()>0){
            Pair remPair = qu.remove();
            TreeNode remNode = remPair.node;
            
            if(remPair.v < lmv){
                lmv = remPair.v;
            }
            if(rmv < remPair.v){
                rmv = remPair.v;
            }
            
            List<Pair> list = hm.getOrDefault(remPair.v , new LinkedList<>());
            list.add(remPair);
            hm.put(remPair.v , list);
            
            if(remNode.left != null){
                qu.add(new Pair(remNode.left, remPair.v-1 , remPair.h+1));
            }
            if(remNode.right != null){
                qu.add(new Pair(remNode.right,remPair.v+1, remPair.h+1));
            }
        }
        
        
        for(int i = lmv ; i<= rmv;i++){
            List<Pair> list = hm.get(i);
            Collections.sort(list);
            
            List<Integer> vl = new LinkedList<>();
            for(Pair myPair : list){
                vl.add(myPair.node.val);
            }
            
            retVal.add(vl);
        }
        
        return retVal;
       
    }
}