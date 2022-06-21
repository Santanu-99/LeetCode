/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>();
        
        // creating new nodes corresponding to original node
        dfs(node, map);
        
        return map.get(node);
        
    }
    
    public void dfs(Node src , HashMap<Node, Node> map){
        if(!map.containsKey(src)){
            Node newNode = new Node(src.val , new ArrayList<Node>());
            map.put(src , newNode);
        }
        
        for(Node nbr : src.neighbors){
            if(!map.containsKey(nbr)){
                dfs(nbr,map);
                Node n = map.get(nbr);
                Node o = map.get(src);
                o.neighbors.add(n);
            }else{
                Node n = map.get(nbr);
                Node o = map.get(src);
                o.neighbors.add(n);
            }
        }
    }
}