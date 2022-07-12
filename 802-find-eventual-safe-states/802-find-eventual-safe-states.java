class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        
        // 0 -> unvisited, 1 -> visited, 2 -> safe
        for(int i=0;i<graph.length;i++){
            if(vis[i] == 0){
                dfs(graph, i , vis);                        
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<vis.length;i++){
            if(vis[i] == 2){
                ans.add(i);                
            }
        }
        
        return ans;
        
    }
    
    public boolean dfs(int[][] graph, int src , int[] vis){
        if(vis[src] == 2){
            return true;
        }
        else if(vis[src] == 1){
            return false;
        }
        else{
            vis[src] = 1;
            for(int nbr : graph[src]){
                boolean isSafe = dfs(graph, nbr , vis);
                if(isSafe == false){
                    return false;
                }
            }
            vis[src] = 2;
            return true;
        }
    }
}