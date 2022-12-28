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
                    System.out.println(ob.minDeletions(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java
class Solution
{
	public int minDeletions(int arr[], int n) 
	{ 
	   //code here.
	   int lis = getLIS(n,arr);
	   int minOp = n - lis;
	   return minOp;
	} 
	
	int getLIS(int n,int[] arr){
	    
	    int lis = 0;
	    
	    int[] dp = new int[n];
	    for(int i=0;i<n;i++){
	        int maxLength = 0;
	        for(int si=0;si<i;si++){
	            if(arr[si]<arr[i]){
	                maxLength = Math.max(maxLength,dp[si]);
	            }
	        }
	        dp[i] = maxLength + 1;
	        lis = Math.max(dp[i],lis);
	    }
	    
	    
	    return lis;
	}
}