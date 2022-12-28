//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        int count =0;
        for(int c=1;c<=m;c++){
            for(int r=1;r<=n;r++){
                if(S1.charAt(r-1) == S2.charAt(c-1)){
                    dp[r][c] = dp[r-1][c-1]+1;
                }
                if(dp[r][c] > count){
                    count = dp[r][c];
                }
            }
        }
        // for(int i=0;i<=m;i++){
        //     for(int j=0;j<=n;j++){
        //         System.out.print(dp[i][j]+", ");
        //     }
        //     System.out.println();
        // }
        
        // int ops = S1.length()-count + S2.length()-count;
        return count;
    }
}