// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                adj.add(t1);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.bellman_ford(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
*   adj: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        // Write your code here
        int[] arr1 = new int[V];
        Arrays.fill(arr1 , (int)1e8);
        arr1[S] = 0;
        int[] arr2 = new int[V];
        for(int j=0;j<V;j++){
            arr2[j] = arr1[j];
        }
        
        for(int i=1; i<V; i++){
            for(ArrayList<Integer> edge : adj){
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                
                arr2[v] = Math.min(arr1[u] + wt , arr2[v]);
            }
            
            arr1 = arr2;
            arr2 = new int[V];
            for(int j=0;j<V;j++){
                arr2[j] = arr1[j];
            }
            
        }
        
        
        
        return arr1;
        
    }
}

