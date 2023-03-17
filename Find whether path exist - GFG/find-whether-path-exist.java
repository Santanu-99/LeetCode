//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int sr=-1 , sc=-1 ;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    sr = i; sc = j;
                    break;
                }
            }
        }
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        return dfs(sr , sc , grid,vis);
    }
    
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    
    boolean dfs(int sr , int sc , int[][] graph , boolean[][] vis){
        if(graph[sr][sc] == 2){
            return true;
        }
        
        vis[sr][sc] = true;
        
        boolean res = false;
        for(int d=0;d<dir.length;d++){
            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1];
            
            if(0<=nr && nr<graph.length && 0<=nc && nc<graph[0].length && !vis[nr][nc] && graph[nr][nc]!=0){
                res = res || dfs(nr,nc,graph,vis);
            }
        }
        
        return res;
    }
}