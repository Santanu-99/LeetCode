//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        // boolean[] stackpath = new boolean[V];
        
        // for(int v=0;v<V;v++){
        //     if(!vis[v]){
        //         boolean cyclic = dfs(v , vis , stackpath , adj);
        //         if(cyclic){
        //             return true;
        //         }
        //     }
        // }
        int[] inDegree = new int[V];
        
        
        boolean cyclic = bfs_kahnAlgo(V, vis , inDegree , adj);
        if(cyclic){
            return true;
        }
        return false;
    }
    
    boolean bfs_kahnAlgo(int V , boolean[] vis ,int[] inDegree, ArrayList<ArrayList<Integer>> adj ){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int v=0;v<V;v++){
            for(int nbr : adj.get(v)){
                inDegree[nbr] += 1;
            }
        }
        Queue<Integer> q= new ArrayDeque<>();
        
        for(int v=0;v<V;v++){
            if(inDegree[v] == 0){
                q.add(v);
            }
        }
        
        
        while(q.size() > 0){
            int remV = q.remove();
            for(int nbr : adj.get(remV)){
                inDegree[nbr] -= 1;
                if(inDegree[nbr] == 0){
                    q.add(nbr);
                }
            }
            ans.add(remV);
        }
        
        if(ans.size() == V){
            return false;
        }
        return true;
        
        
    }
    
    boolean dfs(int src ,boolean[] vis ,boolean[] stackpath, ArrayList<ArrayList<Integer>> adj ){
        vis[src] = true;
        stackpath[src] = true;
        for(int nbr : adj.get(src)){
            if(stackpath[nbr]){
                return true;
            }
            
            if(!vis[nbr]){
                if(dfs(nbr,vis,stackpath,adj)){
                    return true;
                }
            }
            
        }
        stackpath[src] = false;
        return false;
    }
}