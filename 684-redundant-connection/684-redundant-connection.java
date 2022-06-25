class Solution {
    int[] parent,rank;
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] edge = new int[2];
        
        parent= new int[edges.length+1];
        rank = new int[edges.length+1];
        
        for(int i=0;i<edges.length;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            int uLead = find(u);
            int vLead = find(v);
            if(uLead != vLead){
                union(uLead,vLead);
            }else{
                edge[0] = u;
                edge[1] = v;
            }
        }
        
        return edge;
    }
    
    public int find(int x){
        if(x == parent[x]){
            return parent[x];
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int s1l , int s2l){
        if(rank[s1l] > rank[s2l]){
            parent[s2l] = s1l;
        }
        else if(rank[s1l] < rank[s2l]){
            parent[s1l] = s2l;
        }
        else{
            parent[s2l] = s1l;
            rank[s1l]++;
        }
    }
}