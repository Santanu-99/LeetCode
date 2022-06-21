// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<>();
        
        // dfs and postfix adding to stack
        boolean visited[] = new boolean[V];
        for(int v=0;v<V;v++){
            if(!visited[v]){
                dfsAndPush(v,adj,st , visited);
            }
        }
        
        // creating transpose
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int v = 0; v<V; v++){
            transpose.add(new ArrayList<>());
        }
        
        for(int v = 0;v<V;v++){
            for(int nbr : adj.get(v)){
                transpose.get(nbr).add(v);
            }
        }
        
        
        // poping from stack and traversing componenets while counting
        visited = new boolean[V];
        int compCount = 0;
        while(st.size() > 0){
            int v = st.pop();
            if(!visited[v]){
                compCount++;
                dfs(v,transpose,visited);
            }
        }
        
        return compCount;
        
    }
    
    public void dfsAndPush(int src , ArrayList<ArrayList<Integer>> adj , Stack<Integer> st, boolean[] visited){
        visited[src] = true;
        for(int nbr : adj.get(src)){
            if(!visited[nbr]){
                dfsAndPush(nbr, adj , st,visited);
            }
        }
        st.push(src);
    }
    
    public void dfs(int src , ArrayList<ArrayList<Integer>> adj ,boolean[] visited){
        visited[src] = true;
        for(int nbr : adj.get(src)){
            if(!visited[nbr]){
                dfs(nbr, adj , visited);
            }
        }
    }
    
}
