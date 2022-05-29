/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        
        Node lNode = root;
        while(lNode.left != null){
            
            Node node = lNode;
            while(node != null){
                
                if(node.next != null){
                    node.left.next = node.right;
                    node.right.next = node.next.left;
                }else{
                    node.left.next = node.right;
                }
                node = node.next;
            }
            
            lNode= lNode.left;
        }
        
        return root;
    }
}