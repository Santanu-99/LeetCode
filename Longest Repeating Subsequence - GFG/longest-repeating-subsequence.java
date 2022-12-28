//{ Driver Code Starts
//Initial Template for Java

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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        
        int l = str.length();
        int[][] dp = new int[l+1][l+1];
        for(int[] ar: dp){
            Arrays.fill(ar,-1);
        }
        int ans = calcLcs_memo(l,l,str,dp);
        return ans;
    }
    
    int calcLcs_memo(int x,int y,String s,int[][] dp){
        
        if(x==0 || y==0){
            return dp[x][y]=0;
        }
        
        
        if(dp[x][y]!=-1) return dp[x][y];
        
        int myAns = 0;
        if(s.charAt(x-1)==s.charAt(y-1) && x!=y){
            myAns =calcLcs_memo(x-1,y-1,s,dp)+1;
        }
        else{
            int first =calcLcs_memo(x-1,y,s,dp);
            int second =calcLcs_memo(x,y-1,s,dp);
            myAns = Math.max(first,second);
        }
        
        return dp[x][y]=myAns;
    }
}