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
    
    private int convert(String bNum){
        char ch;
        int ans=0;
        int mul = 1;
        for(int i=bNum.length()-1;i>=0;i--){
            ch = bNum.charAt(i);
            
            ans += ch == '0'? 0 : mul;
            mul *= 2;
            
        }
        
        return ans;
    }
    
    
    private ArrayList<String> postOrder(TreeNode node){
        if(node == null){
            return new ArrayList();
        }
        if(node.left == null && node.right == null){
            ArrayList<String> base = new ArrayList<>();
            base.add(""+node.val);
            return base;
        }
        
        ArrayList<String> leftAns = postOrder(node.left);
        ArrayList<String> rightAns = postOrder(node.right);
        
        ArrayList<String> myAns = new ArrayList<>();
        
        for(String ele: leftAns){
            myAns.add(node.val+ele);
        }
        for(String ele: rightAns){
            myAns.add(node.val+ele);
        }
        
        return myAns;
        
    }
    
    
    
    
    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> arr = postOrder(root);
        int sum = 0;
        for(int i=0;i<arr.size();i++){
            String bNum = arr.get(i);
            int num = convert(bNum);
            sum = sum+ num;
        }
        return sum;
    }
}