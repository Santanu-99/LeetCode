//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        int l = S.length();
        int[][] dp = new int[l][l];
        for(int[] ar : dp) Arrays.fill(ar,-1);
        int ans = getLongestPal(0,l-1,S,dp);
        return ans;
    }
    
    int getLongestPal(int i,int j,String s,int[][] dp){
           if(i==j){
               return dp[i][j]=1;
           }
           else if(i>j){
               return dp[i][j]=0;
           }
           
           if(dp[i][j] !=-1) return dp[i][j];
           
           
           int len = 0;
           if(s.charAt(i) == s.charAt(j)){
                len = getLongestPal(i+1,j-1,s,dp)+2;
           }
           else{
                int right = getLongestPal(i+1,j,s,dp);
                int left = getLongestPal(i,j-1,s,dp);
                len = Math.max(left,right);               
           }
           
           return dp[i][j]=len;
    }
    
}