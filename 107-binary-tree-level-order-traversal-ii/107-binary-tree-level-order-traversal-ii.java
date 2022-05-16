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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        
        if(root != null){
            Queue<TreeNode> qu = new LinkedList<>();
            qu.add(root);
            qu.add(null);

            Stack<ArrayList<Integer>> st = new Stack<>();
            ArrayList<Integer> lvl = new ArrayList<>();

            while(qu.size() > 0){
                TreeNode rem = qu.remove();
                if(rem != null){
                    lvl.add(rem.val);
                    if(rem.left != null){
                        qu.add(rem.left);
                    }
                    if(rem.right != null){
                        qu.add(rem.right);
                    }
                }else{
                    st.push(lvl);
                    lvl = new ArrayList<>();
                    if(qu.size() > 0){
                        qu.add(null);
                    }
                }
            }

            while(st.size() > 0){
                res.add(st.pop());
            }
        }
        
        
        return res;
    }
}