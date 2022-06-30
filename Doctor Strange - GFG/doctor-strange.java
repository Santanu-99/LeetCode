// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    int arr [][] = new int[K][2];
		    for(int i = 0;i<K;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.doctorStrange(N, K, arr);
            System.out.println(ans);
    	    
		}
	}
}



// } Driver Code Ends


//User function Template for Java

//User function Template for Java


class Complete{
    
    // Function for finding maximum and value pair
    public static int doctorStrange (int n, int k, int g[][]) {
        //Complete the function
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<g.length;i++){
            int u = g[i][0];
            int v = g[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] vis = new boolean[n+1];
        int[] dis = new int[n+1];
        int[] low = new int[n+1];
        boolean[] aps = new boolean[n+1];
        
    
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfs(graph, vis, dis, low, aps, i, -1);
            }
        }
        
        int count = 0;
        for(boolean ap : aps){
            if(ap){
                count++;
            }
        }
        
        return count;
    }
    
    static int time=0;
    public static void dfs(ArrayList<Integer>[] graph, boolean[] vis, int[] dis, int[] low, boolean[] aps, int u, int p){
        vis[u] = true;
        dis[u] = low[u] = time++;
        
        int c = 0;
        for(int v : graph[u]){
            if(v == p){
                continue;
            }
            else if(vis[v]){
                low[u] = Math.min(dis[v] , low[u]);
            }
            else{
                c++;
                dfs(graph, vis, dis, low, aps, v, u);
                low[u] = Math.min(low[u], low[v]);
                
                if(p!=-1 && dis[u] <= low[v]){
                    aps[u] = true;
                }
                
            }
            
            
        }
        if(p== -1 && c>1){
            aps[u] = true;
        }
    }
    
    
}