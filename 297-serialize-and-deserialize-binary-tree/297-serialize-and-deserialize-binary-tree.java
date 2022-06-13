/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    class Pair{
        TreeNode node;
        int status;
        
        Pair(){}
        Pair(TreeNode node,int status){
            this.node = node;
            this.status = status;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder data = new StringBuilder();
        serializeHelper(root,data);
        return data.toString();
    }
    
    void serializeHelper(TreeNode node ,StringBuilder data){
        if(node == null){
            data.append(".");
            data.append(" ");
            return;

        }
        data.append(node.val+" ");
        serializeHelper(node.left,data);
        serializeHelper(node.right,data);
    }

    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        
        String[] darray = data.split(" ");
        
  
        Stack<Pair> st = new Stack<>();
        TreeNode root = new TreeNode(Integer.parseInt(darray[0]));
        Pair rootPair = new Pair(root,0);
        st.push(rootPair);
        int idx = 0;
        while(st.size() > 0 ){
            Pair oPair = st.peek();
            
//          process left
            if(oPair.status==0){
                oPair.status++;
                idx++;
                if(!darray[idx].equals(".")){
                    TreeNode node = new TreeNode(Integer.parseInt(darray[idx]));
                    oPair.node.left = node;
                    Pair nPair = new Pair(node,0);
                    st.push(nPair);
                }
            }
            
//             process right
            else if(oPair.status==1){
                oPair.status++;
                idx++;
                if(!darray[idx].equals(".")){
                    TreeNode node = new TreeNode(Integer.parseInt(darray[idx]));
                    oPair.node.right = node;
                    Pair nPair = new Pair(node,0);
                    st.push(nPair);
                }
                
            }
//             just pop the top pair
            else{
                st.pop();
            }
        }
            
        return root;
            
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));