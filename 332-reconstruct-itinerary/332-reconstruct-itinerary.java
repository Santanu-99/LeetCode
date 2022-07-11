class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        // duplicating graph
        HashMap<String,PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            
            if(graph.containsKey(from)){
                PriorityQueue<String> pq = graph.get(from);
                pq.add(to);
                graph.put(from,pq);
            }
            else{
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(to);
                graph.put(from,pq);
            }
        }
        
        // hierholzer's algorithm
        Stack<String> st = new Stack<>();
        String start = "JFK";
        dfs(graph,start,st);
        List<String> ans = new ArrayList<>();
        
        while(st.size() > 0){
            ans.add(st.pop());
        }
        return ans;
    }
    
    public void dfs(HashMap<String,PriorityQueue<String>> graph , String v , Stack<String> st){
        
        if(!graph.containsKey(v)){
            st.push(v);
            return;
        }
        
        PriorityQueue<String> pq = graph.get(v);
        while(pq.size()>0){
            String nbr = pq.remove();
            dfs(graph, nbr, st);
        }
        st.push(v);
    }
    
    
    
    
}