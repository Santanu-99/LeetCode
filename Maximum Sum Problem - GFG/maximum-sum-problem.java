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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maxSum(int n) 
    { 
        //code here.
        // int ans = getMaxSum(n);
        int dp[] = new int[n+1];
        int ans = getMaxSum_memo(n,dp);
        return ans;
    } 
    
    int getMaxSum_memo(int n,int[] dp){
        if(n<=4){
            return dp[n]=n;
        }
        
        if(dp[n] != 0) return dp[n];
        
        int div2 = getMaxSum_memo(n/2,dp);
        int div3 = getMaxSum_memo(n/3,dp);
        int div4 = getMaxSum_memo(n/4,dp);
        
        int sum = div2 + div3 + div4;
        int myAns = Math.max(n,sum);
        
        return dp[n]=myAns;
    }
    
    
    int getMaxSum(int n){
        if(n<=4){
            return n;
        }
        
        int div2 = getMaxSum(n/2);
        int div3 = getMaxSum(n/3);
        int div4 = getMaxSum(n/4);
        
        int sum = div2 + div3 + div4;
        int myAns = Math.max(n,sum);
        
        return myAns;
    }
}
