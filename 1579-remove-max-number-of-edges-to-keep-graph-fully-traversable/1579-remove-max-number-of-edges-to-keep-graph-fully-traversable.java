class Solution {
    
    
    int find(int[] parent , int[] rank, int x){
        if(parent[x] == x){
            return x;
        }
        else{
            parent[x] = find(parent , rank , parent[x]);
            return parent[x];
        }
    }
    
    void union(int[] parent, int[] rank , int xLead , int yLead){
        if(rank[xLead] < rank[yLead]){
            parent[xLead] = yLead;
        }
        else if(rank[xLead] > rank[yLead]){
            parent[yLead] = xLead;
        }
        else{
            parent[yLead] = xLead;
            rank[xLead]++;
        }
    }
    
    
    boolean isConnectedComp(int[] parent){
        int count=0;
        for(int i = 1; i<parent.length;i++){
            if(parent[i] == i){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        // Initializing DSU of alice and bob
        int[] alice_parent, alice_rank;
        int[] bob_parent, bob_rank;
        
        alice_parent = new int[n+1];
        alice_rank = new int[n+1];
        bob_parent = new int[n+1];
        bob_rank = new int[n+1];
        
        for(int i = 0; i < n+1 ; i++){
            alice_parent[i] = i;
            alice_rank[i] = 0;
            bob_parent[i] = i;
            bob_rank[i] = 0;
        }
        
        
        // sorting all the edges on the basis of it's type
        Arrays.sort(edges , (a , b) -> {
            return b[0] - a[0];
        });
        
        
        int rCount = 0;
        
        for(int[] edge : edges){
            if(edge[0] == 3){
                int u = edge[1];
                int v = edge[2];

                int alice_uLead = find(alice_parent,alice_rank,u);
                int alice_vLead = find(alice_parent,alice_rank,v);

                int bob_uLead = find(bob_parent,bob_rank,u);
                int bob_vLead = find(bob_parent,bob_rank,v);

                if(alice_uLead != alice_vLead && bob_uLead != bob_vLead){
                    union(alice_parent,alice_rank,alice_uLead,alice_vLead);
                    union(bob_parent,bob_rank,bob_uLead,bob_vLead);
                }
                else if(alice_uLead != alice_vLead){
                    union(alice_parent,alice_rank,alice_uLead,alice_vLead);
                }
                else if(bob_uLead != bob_vLead){
                    union(bob_parent,bob_rank,bob_uLead,bob_vLead);
                }
                else{
                    rCount++;
                }
            }
            else if(edge[0] == 1){
                int u = edge[1];
                int v = edge[2];
                
                int alice_uLead = find(alice_parent,alice_rank,u);
                int alice_vLead = find(alice_parent,alice_rank,v);
                
                if(alice_uLead != alice_vLead){
                    union(alice_parent,alice_rank,alice_uLead,alice_vLead);
                }
                else{
                    rCount++;
                }
            }
            else if(edge[0] == 2 ){
                int u = edge[1];
                int v = edge[2];
                
                int bob_uLead = find(bob_parent,bob_rank,u);
                int bob_vLead = find(bob_parent,bob_rank,v);
                
                if(bob_uLead != bob_vLead){
                    union(bob_parent,bob_rank,bob_uLead,bob_vLead);
                }
                else{
                    rCount++;
                }
            }
            
            
        }
        
        boolean alice_isConn = isConnectedComp(alice_parent);
        boolean bob_isConn = isConnectedComp(bob_parent);
        
        if(alice_isConn == true && bob_isConn == true){
            return rCount;
        }
            
        
        return -1;
    }
}