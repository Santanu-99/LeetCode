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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int nums[], int n)  
	{  
	    //code here.
	    int[] sum_dp = new int[n];
	    for(int ei = 0;ei<n;ei++){
	        int max = 0;
	        for(int j = 0;j<ei;j++){
	            if(nums[j] < nums[ei]){
	                max = Math.max(sum_dp[j],max);
	            }
	        }
	        max = max + nums[ei];
	        sum_dp[ei] = max;
	    }
	    
	    
	    int ans = 0;
	    for(int sum : sum_dp){
	        ans = Math.max(sum,ans);
	    }
	    return ans;
	}  
}