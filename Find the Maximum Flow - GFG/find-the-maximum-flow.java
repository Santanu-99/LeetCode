// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
    
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
            input_line = read.readLine().trim().split("\\s+");
            for(int i=0;i<M;i++)
            {
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[3*i]));
                e.add(Integer.parseInt(input_line[3*i+1]));
                e.add(Integer.parseInt(input_line[3*i+2]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            int ans = ob.findMaxFlow(N, M, Edges); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        int graph[][] = new int[N+1][N+1];
        int residualGraph[][] = new int[N+1][N+1];
        
        for(ArrayList<Integer> edge : Edges){
            int pv = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            
            graph[pv][v] += wt;
            graph[v][pv] += wt;
            
            residualGraph[pv][v] += wt;
            residualGraph[v][pv] += wt;
            
        }
        
        int maxFlow = 0;
        int[] parent = new int[N+1];
        boolean vis[] = new boolean[N+1];
        while(pathFound(residualGraph, 1, parent,vis) == true){
            int v = N;
            int minFlow = Integer.MAX_VALUE;
            while(v != 1){
                int pv = parent[v];
                if(residualGraph[pv][v] < minFlow){
                    minFlow = residualGraph[pv][v];
                }
                v = pv;
            }
            
            v = N;
            while(v != 1){
                int pv = parent[v];
                
                residualGraph[pv][v] -= minFlow;
                residualGraph[v][pv] += minFlow;
                
                
                v = pv;
            }
            
            maxFlow += minFlow;
            vis = new boolean[N+1];
            parent = new int[N+1];
        }
        
        
        return maxFlow;
    }
    
    boolean pathFound(int[][] residualGraph, int p , int[] parent, boolean[] vis){
        if(p == residualGraph.length -1 ){
            vis[p] = true;
            return true;
        }
        
        
        vis[p] = true;
        for(int i=1; i<residualGraph[p].length; i++){
            if(residualGraph[p][i] > 0 && vis[i] == false){
                parent[i] = p;
                boolean exists = pathFound(residualGraph, i, parent, vis);
                if(exists){
                    return true;
                }
            }
        }
        
        return false;
    }
}