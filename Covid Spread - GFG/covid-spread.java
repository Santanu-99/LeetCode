//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    class Pair{
        int row , col;
        Pair(){}
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
        
        public String toString(){
            return " ("+row+","+col+") ";
        }
    }
    
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    
    int getCountOfUninfected(int[][] hospital,boolean[][] vis,Queue<Pair> q){
        int count=0;
        for(int i=0;i<hospital.length;i++){
            for(int j=0;j<hospital[0].length;j++){
                if(hospital[i][j] == 2){
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                }
                else if(hospital[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    public int helpaterp(int[][] hospital) {
        // code here
        int m =hospital.length;
        int n = hospital[0].length;
        
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        int count = getCountOfUninfected(hospital,vis,q);
        
        
        int time = -1;
        while (q.size()  > 0){
            int tempSize = q.size();
            // System.out.println(q.toString());
            while(tempSize-- > 0){
                Pair rem = q.remove();
                
                int sr= rem.row;
                int sc= rem.col;
                
                for(int d=0;d<dir.length;d++){
                    int nr = sr + dir[d][0];
                    int nc = sc + dir[d][1];
                    
                    if(0<=nr && nr<m && 0<=nc && nc<n && !vis[nr][nc] && hospital[nr][nc] == 1){
                        vis[nr][nc] = true;
                        count--;
                        q.add(new Pair(nr,nc));
                    }
                    
                }
                
            }
            time++;
            
        }
        
        if(count>0) return -1;
        
        return time;
        
    }
}
