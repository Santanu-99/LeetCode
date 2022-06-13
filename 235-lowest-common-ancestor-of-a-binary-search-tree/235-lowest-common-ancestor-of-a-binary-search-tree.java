/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public ArrayList<TreeNode> getRootToNode(TreeNode root,int x){
        ArrayList<TreeNode> al = new ArrayList<>();
        TreeNode node = root;
        while(node.val != x){
            al.add(node);
            if(node.val < x){
                node = node.right;
            }else{
                node = node.left;
            }
        }
        al.add(node);
        return al;
        
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> r2np = getRootToNode(root,p.val);
        ArrayList<TreeNode> r2nq = getRootToNode(root,q.val);
        int i=0;
        while(i<Math.min(r2np.size() ,r2nq.size()) && r2np.get(i).val == r2nq.get(i).val){
            i++;
        }
        i = i-1;
        return r2np.get(i);
        
    }
}