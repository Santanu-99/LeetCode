//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    int mod = (int)1e9 + 7;
    
    int countWays(int n)
    {
        
        // your code here
        int[] dp = new int[n+1];
        int ans = countWays_Memo(n,dp);
        return ans;
    }
    int countWays_Memo(int n,int[] dp){
        if(n<0){
            return 0;
        }
        else if(n==0){
            return dp[n]=1;
        }
        
        if(dp[n]!=0) return dp[n];
        
        int myAns = (countWays_Memo(n-1,dp) + countWays_Memo(n-2,dp))%mod;
        return dp[n]=myAns;
    }
}

