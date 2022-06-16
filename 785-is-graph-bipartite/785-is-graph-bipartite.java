class Solution {
    
    public boolean dfs(int[][] graph, int[] vis, int v , int color){
        vis[v] = color;
        int ncolor = color * -1;
        for(int nbr : graph[v]){
            if(vis[nbr] == 0 ){
                boolean ans = dfs(graph , vis,nbr,ncolor); 
                if(!ans){
                    return false;
                }
            }else{
                if(vis[nbr] != ncolor){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    
    public boolean isBipartite(int[][] graph) {
        
        int[] vis = new int[graph.length];
        
        boolean valid=true;
        
        for(int i=0; i<graph.length; i++){
            if(vis[i]==0){
                valid = dfs(graph,vis,i,1);
                if(!valid){
                    return false;
                }    
            }
        }
        
        return valid;
    }
}