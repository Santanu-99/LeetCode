class Solution {
    
    int[] parent, rank;
    
    
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int i=1;i<=n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int i=threshold + 1; i<=n ;i++){
            for(int j = 2*i ; j<=n; j=j+i){
                int iLead = find(i);
                int jLead = find(j);
                
                if(iLead != jLead){
                    union(iLead , jLead);
                }
            }
        }
        
        
        List<Boolean> ans = new ArrayList<>();
        
        for(int[] query : queries){
            int u = query[0];
            int v = query[1];
            
            int uLead = find(u);
            int vLead = find(v);
            
            if(uLead == vLead){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        
        }
        
        return ans;
    }
    
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    void union(int xLead , int yLead){
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
}