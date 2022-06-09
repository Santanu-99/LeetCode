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
        Node curr = root;
        Node head,tail;
        
        
        while(curr != null){
//             find the first pointer in the level with a child and assign it to curr
                while(curr!= null && curr.left == null && curr.right == null){
                    curr = curr.next;
                }
            
//             set the head/tail pointer w.r.t curr pointer
                if(curr==null){
                    break;
                }if(curr.left != null){
                    head = tail = curr.left;
                }else{
                    head = tail = curr.right;
                }
            
            
//             loop
            while(curr!=null){
                
//             find the next sibling and update tail
                    if(curr.left != null && curr.left != tail){
                        tail.next = curr.left;
                        tail = tail.next;
                    }
                
                    if(curr.right != null && curr.right != tail){
                        tail.next = curr.right;
                        tail = tail.next;
                    }
                    
                
//                 find the next  curr
                curr = curr.next;
                while(curr != null && curr.left == null && curr.right == null){
                    curr = curr.next;
                }
            }            
//             unitl curr == null
            
            
//             make curr = head
            curr = head;
        }
        return root;
        
    }
}