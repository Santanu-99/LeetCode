//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         
         int[][] dp = new int[n][W+1];
         for(int[] ar : dp){
             Arrays.fill(ar,-1);
         }
         int ans = getMaxVal(W,n-1,wt,val,dp);
         return ans;
    } 
    
    static int getMaxVal(int cap,int itm , int[] wt,int[] val,int[][] dp){
        if(itm<0) return 0;
        if(cap==0) return dp[itm][cap]=0;
        
        if(dp[itm][cap] != -1) return dp[itm][cap];
        int inc = 0;
        if(cap-wt[itm]>=0)
            inc = getMaxVal(cap-wt[itm],itm-1,wt,val,dp) + val[itm];
        int exc = getMaxVal(cap,itm-1,wt,val,dp);
        
        int myAns = Math.max(inc,exc);
        dp[itm][cap]=myAns;
        
        return myAns;
        
    }
}


