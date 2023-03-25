//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static class Edge{
        int src , dest ,wt;
        Edge(){
            
        }
        Edge(int src , int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    int ans = kruskalAlgoMST(V, E,edges);
	    return ans;
	   
	}
	
	static int[] parent , rank;
	
	static int findParent(int x){
	    if(parent[x] == x){
	        return x;
	    }
	    return parent[x] = findParent(parent[x]);
	}
	
	static void union(int x ,int y){
	    if(rank[x] == rank[y]){
	        parent[y] = x;
	        rank[x]++;
	    }
	    else if(rank[x] < rank[y]){
	        parent[x] = y;
	    }
	    else{
	        parent[y] = x;
	    }
	}
	
	static int kruskalAlgoMST(int V, int E, int edges[][]){
	    parent = new int[V];
	    rank = new int[V];
	    for(int i=0;i<V;i++){
	        parent[i] = i;
	    }
	    
	    PriorityQueue<int[]> pq =  new PriorityQueue<>((a,b)->{
	        return a[2]-b[2];
	    });
	    
	    for(int[] edge : edges){
	        pq.add(edge);
	    }
	    
	    int totWt = 0;
	    while(pq.size() > 0){
	        int[] edge = pq.remove();
	        int u = edge[0];
	        int v = edge[1];
	        int wt = edge[2];
	        int pu = findParent(u);
	        int pv = findParent(v);
	        
	        if(pu != pv){
	            union(pu,pv);
	            totWt += wt;
	        }
	    }
	    
	    return totWt;
	}
	
	static int primsAlgoMST(int V, int E, int edges[][]){
	    ArrayList<Edge>[] graph = new ArrayList[V];
	    for(int i=0;i<V;i++){
	        graph[i] = new ArrayList<>();
	    }
	    for(int[] edge : edges){
	        int u = edge[0];
	        int v = edge[1];
	        int wt = edge[2];
	        
	        graph[u].add(new Edge(u,v,wt));
	        graph[v].add(new Edge(v,u,wt));
	    }
	    
	    
	    PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->{
	        return a.wt - b.wt;
	    });
	    
	    pq.add(new Edge(-1,0,0));
	    boolean vis[] = new boolean[V];
	    int totWt = 0;
	    while(pq.size() > 0){
	        
	        //remove
	        Edge rem = pq.remove();
	        
	        int src = rem.src;
	        int dest = rem.dest;
	        int wt = rem.wt;
	        
	        //check
	        if(src != -1 && vis[dest]){
	            continue;
	        }
	        
	        
	        //work
	        vis[dest] = true;
	        totWt += wt;
	        
	        //add
	        for(Edge adjEdge : graph[dest]){
	            if(vis[adjEdge.dest] == false){
	                pq.add(adjEdge);
	            }
	        }
	        
	    }
	    
	    return totWt;
	}
}