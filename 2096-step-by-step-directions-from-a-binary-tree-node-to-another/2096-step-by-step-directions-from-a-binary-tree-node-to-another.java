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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<TreeNode> n2rSt = getN2RPath(root,startValue);
        ArrayList<TreeNode> n2rDst = getN2RPath(root,destValue);
        
        
        int i = n2rSt.size() - 1;
        int j = n2rDst.size() - 1;
        
        while( 0<=i && 0<=j && n2rSt.get(i) == n2rDst.get(j)){
            i--;
            j--;
        }
        
        i++;
        j++;
        
        StringBuilder sb = new StringBuilder();
        
       for(int ii = 0;ii < i ; ii++ ){
           sb.append('U');
       }
        
        for(int jj = j-1; jj>=0;jj--){
            if(n2rDst.get(jj+1).left == n2rDst.get(jj)){
                sb.append('L');
            }else if(n2rDst.get(jj+1).right == n2rDst.get(jj)){
                sb.append('R');
            }
        }
        
        return sb.toString();
        
    }
    
    ArrayList<TreeNode> getN2RPath(TreeNode root, int x){
        
        if(root == null){
            return new ArrayList<>();
        }
        
        
        if(root.val == x){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }
        
        ArrayList<TreeNode> left = getN2RPath(root.left , x);
        if(left.size() > 0){
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right = getN2RPath(root.right , x);
        if(right.size() > 0){
            right.add(root);
            return right;
        }
        
        return new ArrayList<>();
    }
    
    
}