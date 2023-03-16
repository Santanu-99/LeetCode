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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    class Pair{
        int row ,col;
        Pair(){}
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
        
        public String toString(){
            return " ( "+this.row +" , "+this.col+" ) ";
        }
    }
    
    int X[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int Y[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        
        if(KnightPos[0] == TargetPos[0] && KnightPos[1]==TargetPos[1]){
            return 0;
        }
        
        
        
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][N];
        // seed
        q.add(new Pair(KnightPos[1]-1,KnightPos[0]-1));
        vis[KnightPos[1]-1][KnightPos[0]-1] = true;
        
        int step = 1;
        
        while(q.size() > 0){
            int tempSize = q.size();
            // System.out.println(q.toString());
            while(tempSize-- > 0){
                Pair rem = q.remove();
                
                int sr = rem.row;
                int sc = rem.col;
                
                for(int d=0;d<8;d++){
                    int nr = sr + X[d];
                    int nc = sc + Y[d];
                    
                    if(0<=nr && nr<N && 0<=nc && nc<N && vis[nr][nc]==false){
                        if(nr == TargetPos[1]-1 && nc ==TargetPos[0]-1){
                            return step;
                        }
                        vis[nr][nc] = true;
                        q.add(new Pair(nr,nc));
                    }
                }
                
            }
            step++;
        }
        
        return -1;
    }
}