// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            for(int i = 0;i < N;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < N;j++)
                    graph[i][j] = Integer.parseInt(a[j]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.eulerPath(N, graph));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int eulerPath(int N, int graph[][]){
        // code here
        int oddCount = 0;
        for(int[] nbrs : graph){
            int degree = 0;
            for(int nbr : nbrs){
                if(nbr == 1){
                    degree++;
                }
            }
            
            if(degree % 2 != 0){
                oddCount++;
            }
        }
        
        if(oddCount == 2 || oddCount == 0){
            return 1;
        }
        else{
            return 0;   
        } 
    }
}