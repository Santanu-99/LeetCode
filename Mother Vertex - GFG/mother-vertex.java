// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Stack<Integer> st = new Stack<Integer>();
        boolean[] visited = new boolean[V];
        for(int v=0; v<V ; v++){
            if(!visited[v]){
                dfs(v,adj,visited,st);
            }
        }
        
        
        
        visited = new boolean[V];
        dfsCheck(st.peek() , adj , visited);
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                return -1;
            }
        }
        
        return st.peek();
    }
    
    public void dfs(int src ,ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer> st){
        visited[src] = true;
        for(int nbr : adj.get(src)){
            if(!visited[nbr]){
                dfs(nbr,adj,visited,st);
            }
        }
        st.push(src);
    }
    public void dfsCheck(int src ,ArrayList<ArrayList<Integer>> adj ,boolean[] visited){
        visited[src] = true;
        for(int nbr : adj.get(src)){
            if(!visited[nbr]){
                dfsCheck(nbr,adj,visited);
            }
        }
    }
}