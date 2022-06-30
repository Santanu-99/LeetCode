// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    static class Pair{
        int u,v;
        Pair(){}
        Pair(int u , int v){
            this.u = u;
            this.v = v;
        }
    }
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        ArrayList<Pair> bridges = new ArrayList<>();
        int[] dis = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj, vis, dis, low, bridges, i, -1);
            }
        }
        
        for(Pair bridge : bridges){
            if((bridge.u == c && bridge.v == d) || (bridge.u == d && bridge.v == c) ){
                return 1;
            }
        }
        
        return 0;
    }
    
    static int time=0;
    static public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] dis, int[] low,ArrayList<Pair> bridges, int u, int p){
        dis[u]=low[u]=time++;
        vis[u]=true;
        int c=0;
        for(int v: adj.get(u)){
            if(p==v){
                continue;
            }
            else if(vis[v]){
                low[u] = Math.min(dis[v] , low[u]);
            }
            else{
                c++;
                dfs(adj, vis, dis, low, bridges, v, u);
                low[u] = Math.min(low[v], low[u]);
                
                if(dis[u]<low[v]){
                    bridges.add(new Pair(u,v));
                }
            }
        }
        
        
    }
}